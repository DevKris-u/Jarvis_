package com.example.jarvis

object KnowledgeBase {
    private val qa = mapOf(
        "kto był pierwszy w kosmosie" to "Jurij Gagarin, sir."
    )

    fun answer(q: String) =
        qa.entries.firstOrNull { q.contains(it.key) }?.value
}
