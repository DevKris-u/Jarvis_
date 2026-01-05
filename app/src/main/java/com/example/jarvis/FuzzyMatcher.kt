package com.example.jarvis

import kotlin.math.min

object FuzzyMatcher {

    private fun levenshtein(a: String, b: String): Int {
        val dp = Array(a.length + 1) { IntArray(b.length + 1) }

        for (i in 0..a.length) dp[i][0] = i
        for (j in 0..b.length) dp[0][j] = j

        for (i in 1..a.length) {
            for (j in 1..b.length) {
                val cost = if (a[i - 1] == b[j - 1]) 0 else 1
                dp[i][j] = min(
                    min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                    dp[i - 1][j - 1] + cost
                )
            }
        }
        return dp[a.length][b.length]
    }

    private fun similarity(a: String, b: String): Double {
        val longer = if (a.length > b.length) a else b
        val shorter = if (a.length > b.length) b else a
        if (longer.isEmpty()) return 1.0
        return (longer.length - levenshtein(longer, shorter)).toDouble() / longer.length
    }

    fun match(input: String, patterns: List<String>, threshold: Double = 0.6): String? {
        var best: String? = null
        var bestScore = 0.0

        for (p in patterns) {
            val score = similarity(input, p)
            if (score > bestScore && score >= threshold) {
                bestScore = score
                best = p
            }
        }
        return best
    }
}
