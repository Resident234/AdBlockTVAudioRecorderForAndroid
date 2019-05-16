LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := mp3lame
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\Android.mk \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\com_uraroji_garage_android_lame_SimpleLame.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\bitstream.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\encoder.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\fft.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\gain_analysis.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\id3tag.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\lame.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\lame.rc \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\mpglib_interface.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\newmdct.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\presets.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\psymodel.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\quantize.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\quantize_pvt.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\reservoir.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\set_get.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\tables.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\takehiro.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\util.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\vbrquantize.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\VbrTag.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\lame-3.98.4_libmp3lame\version.c \
	E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni\Note.txt \

LOCAL_C_INCLUDES += E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\main\jni
LOCAL_C_INCLUDES += E:\SERVER_TEMP\Work_AdBlockTV\Mp3VoiceRecorderSampleForAndroid1\app\src\debug\jni

include $(BUILD_SHARED_LIBRARY)
