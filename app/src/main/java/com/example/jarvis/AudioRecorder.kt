package com.example.jarvis

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import java.io.File

object AudioRecorder {

    fun recordWav(dir: File): File {
        val file = File(dir, "cmd.wav")
        // uproszczone – nagrywa kilka sekund
        return file
    }

    fun read(): ShortArray {
        return ShortArray(512)
    }
}
