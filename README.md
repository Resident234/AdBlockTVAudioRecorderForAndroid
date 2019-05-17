# AdBlockTV AudioRecorder For Android

<h2>StartUp instruction</h2>

1) Go to File -> New -> Import Project  http://prntscr.com/npn8ku 

2) Select directory with cloned repo http://prntscr.com/npn91w

3) Download lame3 from https://sourceforge.net/projects/lame/files/lame/ . 
Так же lame лежит в этом репозитории в папке lame-3.100


Trables solutions:

1) error: undefined reference to 'bcopy'  => 
Create Application.mk https://developer.android.com/ndk/guides/application_mk и разместить его рядом с Android.mk .
В Application.mk добавить APP_CFLAGS += -DSTDC_HEADERS , первый ответ на вопрос https://stackoverflow.com/questions/27893149/android-ndk-for-x86-64-has-no-reference-for-bcopy-and-index


2) 



<h2><a id="user-content-usage" class="anchor" aria-hidden="true" href="#usage"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Usage</h2>

<ul>
<li>Press the "Start" button to start recording, then press the "Stop" button to stop recording.</li>
<li>Recorded content is saved mezzo.mp3 on the SD card root directory(/sdcard or /mnt/sdcard).</li>
</ul>

