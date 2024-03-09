package com.mikhail.newsboard.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mikhail.newsboard.RegistrationComponent
import com.mikhail.newsboard.features.registration.impl.R
import com.mikhail.newsboard.widgets.BaseScreen
import com.mikhail.newsboard.widgets.NewsOutlinedTextField

@Composable
fun RegistrationScreen(
    component: RegistrationComponent,
    modifier: Modifier = Modifier
) {
    BaseScreen(
        modifier = modifier,
        topbarText = stringResource(R.string.registration_topbar_title),
        underText = stringResource(R.string.registration_hello_message),
        isImePaddingApplied = true
    ) {
        Spacer(modifier = Modifier.padding(top = 16.dp))

        NewsOutlinedTextField()
    }
}