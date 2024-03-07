package com.mikhail.newsboard.data

import com.mikhail.newsboard.core.ui.R

enum class OnboardingPage(val resource: Int) {
    SEARCH(resource = R.drawable.ic_search),
    CATEGORIZE(resource = R.drawable.ic_categories),
    SAVE(resource = R.drawable.ic_bookmark);

    companion object {

        fun from(id: Int): OnboardingPage {
            return entries.first { it.ordinal == id }
        }
    }
}