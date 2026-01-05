package com.example.jarvis

object CerebrasClient {

    fun ask(text: String): String {
        return "Oczywiście, sir."
    }

    fun paraphrase(text: String): String {
        return ask("Powiedz to jak Jarvis:\n$text")
    }
}
