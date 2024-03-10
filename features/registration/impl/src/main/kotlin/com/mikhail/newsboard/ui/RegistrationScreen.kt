package com.mikhail.newsboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.mikhail.newsboard.RegistrationComponent
import com.mikhail.newsboard.features.registration.impl.R
import com.mikhail.newsboard.theme.NewsTheme
import com.mikhail.newsboard.widgets.BaseScreen
import com.mikhail.newsboard.widgets.NewsOutlinedTextField
import com.mikhail.newsboard.widgets.NewsPlaceholder
import com.mikhail.newsboard.widgets.NewsSingleLineButton

@Composable
fun RegistrationScreen(
    component: RegistrationComponent,
    modifier: Modifier = Modifier
) {
    val model by component.model.subscribeAsState()

    BaseScreen(
        modifier = modifier,
        topbarText = stringResource(R.string.registration_topbar_title),
        underText = stringResource(R.string.registration_hello_message),
        isImePaddingApplied = true
    ) {
        Spacer(modifier = Modifier.padding(top = 16.dp))

        NewsOutlinedTextField(
            modifier = Modifier.padding(top = 16.dp),
            value = model.username,
            onValueChange = component::onUsernameChange,
            placeholder = {
                NewsPlaceholder(
                    text = stringResource(R.string.registration_username_placeholder)
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_username),
                    contentDescription = null
                )
            }
        )

        NewsOutlinedTextField(
            modifier = Modifier.padding(top = 16.dp),
            value = model.email,
            onValueChange = component::onEmailChange,
            placeholder = {
                NewsPlaceholder(
                    text = stringResource(R.string.registration_email_placeholder)
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_email),
                    contentDescription = null
                )
            }
        )

        NewsOutlinedTextField(
            modifier = Modifier.padding(top = 16.dp),
            value = model.password,
            onValueChange = component::onPasswordChange,
            placeholder = {
                NewsPlaceholder(
                    text = stringResource(R.string.registration_password_placeholder)
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_password),
                    contentDescription = null
                )
            }
        )

        NewsOutlinedTextField(
            modifier = Modifier.padding(top = 16.dp),
            value = model.passwordRepeat,
            onValueChange = component::onPasswordRepeatChange,
            placeholder = {
                NewsPlaceholder(
                    text = stringResource(R.string.registration_repeat_password_placeholder)
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_password),
                    contentDescription = null
                )
            }
        )

        NewsSingleLineButton(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(R.string.registration_sign_up_button)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.registration_already_have_an_account_title) + " ",
                style = NewsTheme.typography.regular,
                fontSize = 16.sp,
                color = NewsTheme.color.blackLight
            )
            Text(
                text = stringResource(R.string.registration_sign_in_title),
                style = NewsTheme.typography.medium,
                fontSize = 16.sp,
                color = NewsTheme.color.black
            )
        }
    }
}