/* 
 * Copyright (c) 2011-2012 Yuichi Hirano
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.uraroji.garage.android.mp3recvoice;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Calendar;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private Calendar rightNow = Calendar.getInstance();

	public static boolean isWatching = false;
	public static boolean isRecording = false;
	public static int intDelayMillis = 200;

	// エミュレータではマイクからの入力サンプリングレートは8KHzしかサポートしていない模様
	private static RecMicToMp3 mRecMicToMp3 = new RecMicToMp3(
			Environment.getExternalStorageDirectory() + "", 8000);
	private static AudioRecognizer mAudioRecognizer = new AudioRecognizer();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.i(TAG, "onCreate");

		final TextView statusTextView = (TextView) findViewById(R.id.StatusTextView);

		mRecMicToMp3.setHandle(new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case RecMicToMp3.MSG_REC_STARTED:
					statusTextView.setText("録音中");
					break;
				case RecMicToMp3.MSG_REC_STOPPED:
					statusTextView.setText("");
					break;
				case RecMicToMp3.MSG_ERROR_GET_MIN_BUFFERSIZE:
					statusTextView.setText("");
					Toast.makeText(MainActivity.this,
							"録音が開始できませんでした。この端末が録音をサポートしていない可能性があります。",
							Toast.LENGTH_LONG).show();
					break;
				case RecMicToMp3.MSG_ERROR_CREATE_FILE:
					statusTextView.setText("");
					Toast.makeText(MainActivity.this, "ファイルが生成できませんでした",
							Toast.LENGTH_LONG).show();
					break;
				case RecMicToMp3.MSG_ERROR_REC_START:
					statusTextView.setText("");
					Toast.makeText(MainActivity.this, "Не удалось начать запись",
							Toast.LENGTH_LONG).show();
					break;
				case RecMicToMp3.MSG_ERROR_AUDIO_RECORD:
					statusTextView.setText("");
					Toast.makeText(MainActivity.this, "録音ができませんでした",
							Toast.LENGTH_LONG).show();
					break;
				case RecMicToMp3.MSG_ERROR_AUDIO_ENCODE:
					statusTextView.setText("");
					Toast.makeText(MainActivity.this, "エンコードに失敗しました",
							Toast.LENGTH_LONG).show();
					break;
				case RecMicToMp3.MSG_ERROR_WRITE_FILE:
					statusTextView.setText("");
					Toast.makeText(MainActivity.this, "ファイルの書き込みに失敗しました",
							Toast.LENGTH_LONG).show();
					break;
				case RecMicToMp3.MSG_ERROR_CLOSE_FILE:
					statusTextView.setText("");
					Toast.makeText(MainActivity.this, "ファイルの書き込みに失敗しました",
							Toast.LENGTH_LONG).show();
					break;
				default:
					break;
				}
			}
		});

		Button startButton = (Button) findViewById(R.id.StartButton);
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isWatching) {
					isWatching = true;
					watching();
				}
				//mRecMicToMp3.start();
			}
		});
		Button stopButton = (Button) findViewById(R.id.StopButton);
		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isWatching) isWatching = false;
				//mRecMicToMp3.stop();
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mRecMicToMp3.stop();
	}



	private static class MyHandler extends Handler {}
	private final MyHandler mHandler = new MyHandler();

	private static String recordingID;
	private static String filePath;

	public static class MyRunnable implements Runnable {
		private final WeakReference<Activity> mActivity;

		public MyRunnable(Activity activity) {
			mActivity = new WeakReference<Activity>(activity);
		}

		@Override
		public void run() {
			Log.i(TAG,  "run");

			Activity activity = mActivity.get();

			Calendar rightNow = Calendar.getInstance();
			if (activity != null) {

				if(isRecording) {
					mRecMicToMp3.stop();
					Log.i(TAG, recordingID + " stopRecording");
					isRecording = false;
					intDelayMillis = 2000;
					//mAudioRecognizer.listenSound(recordingID, false, filePath);

					// send hashes to rest
				} else {
					recordingID = System.currentTimeMillis() / 1000 + "";
					filePath = Environment.getExternalStorageDirectory() + "/recording" + recordingID + ".mp3";

					mRecMicToMp3.setFilePath(filePath);
					mRecMicToMp3.start();

					Log.i(TAG,  rightNow.getTimeInMillis() + " startRecording");
					isRecording = true;
					intDelayMillis = 20000;
				}

				if(isWatching) {
					MyHandler mHandler = new MyHandler();
					mHandler.postDelayed(this, intDelayMillis);
				} else {
					mRecMicToMp3.stop();
					Log.i(TAG,  rightNow.getTimeInMillis() + " stopRecording");
				}
			}
		}
	}

	private void watching() {
		mHandler.postDelayed(mRunnable, intDelayMillis);
	}

	private MyRunnable mRunnable = new MyRunnable(this);

}
