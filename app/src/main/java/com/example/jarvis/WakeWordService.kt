package com.example.jarvis

import android.app.Service
import android.content.Intent
import android.os.IBinder
import ai.picovoice.porcupine.*

class WakeWordService : Service() {

    private lateinit var porcupine: Porcupine

    override fun onCreate() {
        super.onCreate()
        porcupine = Porcupine.Builder()
            .setAccessKey("TWÓJ_PICOVOICE_ACCESS_KEY")
            .setKeywordPath("wake_up_jarvis.ppn")
            .build(applicationContext)

        Thread {
            while (true) {
                if (porcupine.process(AudioRecorder.read())) {
                    onWakeWord()
                }
            }
        }.start()
    }

    private fun onWakeWord() {
        val wav = AudioRecorder.recordWav(cacheDir)
        val text = WhisperClient.transcribe(wav)
        val response = JarvisBrain.respond(this, text)
        Speech(this).speak(response)
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
