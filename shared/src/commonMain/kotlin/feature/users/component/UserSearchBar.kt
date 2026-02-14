package feature.users.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.id.ilhamelmujib.githubuser.feature.users.component.UserContent
import feature.users.viewmodel.UserContract
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.ic_close
import github_user.shared.generated.resources.ic_search
import github_user.shared.generated.resources.user_screen_top_bar_title
import kotlinx.coroutines.flow.distinctUntilChanged
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserSearchBar(
    modifier: Modifier = Modifier,
    onEvent: (UserContract.Event) -> Unit,
    uiState: UserContract.State,
) {
    val searchState = remember { TextFieldState() }
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(searchState.text) {
        snapshotFlow { searchState.text }
            .distinctUntilChanged()
            .collect { query ->
                onEvent(UserContract.Event.OnSearchUser(query.toString()))
            }
    }

    SearchBar(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = if (!expanded) 16.dp else 0.dp, vertical = 0.dp),
        inputField = {
            SearchBarDefaults.InputField(
                state = searchState,
                onSearch = {
                    expanded = false
                },
                expanded = expanded,
                onExpandedChange = { expanded = it },
                placeholder = {
                    Text(stringResource(Res.string.user_screen_top_bar_title))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_search),
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    if (searchState.text.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                searchState.edit {
                                    replace(0, length, "")
                                }
                                expanded = false
                            }
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.ic_close),
                                contentDescription = "Clear search"
                            )
                        }
                    }
                },
                colors = SearchBarDefaults.inputFieldColors(),
            )
        },
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        UserContent(
            onEvent = onEvent,
            uiState = uiState
        )
    }
}