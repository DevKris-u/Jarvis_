package com.example.jarvis

object IntentDetector {

    enum class Intent {
        BOOK_PAGE,
        SAVE_BOOK,
        STOP,
        UNKNOWN
    }

    private val bookPagePatterns = listOf(
        "na której stronie skończyłem",
        "na jakiej stronie skończyłem",
        "gdzie skończyłem czytać",
        "która strona książki",
        "na jakiej stronie jestem",
        "gdzie przerwałem czytanie"
    )

    private val saveBookPatterns = listOf(
        "zapamiętaj książkę",
        "zapisz książkę",
        "zapamiętaj że skończyłem",
        "zapisz stronę książki"
    )

    private val stopPatterns = listOf(
        "jarvis stop",
        "stop jarvis",
        "zakończ",
        "koniec"
    )

    fun detect(command: String): Intent {
        val text = command.lowercase()

        FuzzyMatcher.match(text, stopPatterns, 0.8)?.let {
            return Intent.STOP
        }

        FuzzyMatcher.match(text, saveBookPatterns)?.let {
            return Intent.SAVE_BOOK
        }

        FuzzyMatcher.match(text, bookPagePatterns)?.let {
            return Intent.BOOK_PAGE
        }

        return Intent.UNKNOWN
    }
}
