package com.example.jarvis

import android.content.Context

object JarvisBrain {

    fun respond(ctx: Context, cmd: String): String {
        KnowledgeBase.answer(cmd)?.let { return it }
        WebSearch.answer(cmd)?.let { return CerebrasClient.paraphrase(it) }
        return CerebrasClient.ask(cmd)
    }
}
