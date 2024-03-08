package com.mikhail.newsboard.data

import com.mikhail.newsboard.features.onboarding.impl.R

enum class OnboardingPage(
    val resource: Int,
    val description: Int
) {
    SEARCH(
        resource = R.raw.lottie_search,
        description = R.string.onboarding_pager_item_search
    ),
    CATEGORIZE(
        resource = R.raw.lottie_categorize,
        description = R.string.onboarding_pager_item_categorize
    ),
    SAVE(
        resource = R.raw.lottie_bookmark,
        description = R.string.onboarding_pager_item_save
    );

    companion object {

        fun from(id: Int): OnboardingPage {
            return entries.first { it.ordinal == id }
        }
    }
}