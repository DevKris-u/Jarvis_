package com.example.jarvis

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

class Speech(ctx: Context) {
    private val tts = TextToSpeech(ctx) {
        if (it == TextToSpeech.SUCCESS)
            tts.language = Locale.US
    }

    fun speak(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}
