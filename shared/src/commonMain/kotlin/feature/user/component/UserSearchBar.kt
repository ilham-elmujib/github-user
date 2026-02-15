package feature.user.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import feature.user.viewmodel.UserContract
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.ic_close
import github_user.shared.generated.resources.ic_search
import github_user.shared.generated.resources.user_search_placeholder
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserSearchBar(
    modifier: Modifier = Modifier,
    onEvent: (UserContract.Event) -> Unit,
    uiState: UserContract.State,
) {
    SearchBar(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = if (!uiState.searchBarExpanded) 16.dp else 0.dp, vertical = 0.dp),
        inputField = {
            SearchBarDefaults.InputField(
                query = uiState.searchQuery,
                onQueryChange = {
                    onEvent(UserContract.Event.OnSearchQueryChange(it))
                },
                onSearch = {
                    onEvent(UserContract.Event.OnSearchBarExpand(false))
                },
                expanded = uiState.searchBarExpanded,
                onExpandedChange = {
                    onEvent(UserContract.Event.OnSearchBarExpand(it))
                },
                placeholder = {
                    Text(stringResource(Res.string.user_search_placeholder))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_search),
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    if (uiState.searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                onEvent(UserContract.Event.OnSearchQueryChange(""))
                                onEvent(UserContract.Event.OnSearchBarExpand(false))
                            }
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.ic_close),
                                contentDescription = "Clear search"
                            )
                        }
                    }
                }
            )
        },
        expanded = uiState.searchBarExpanded,
        onExpandedChange = {
            onEvent(UserContract.Event.OnSearchBarExpand(it))
        },
    ) {
        UserContent(
            usersResult = uiState.usersResult,
            onItemClick = {
                onEvent(UserContract.Event.OnNavigateToRepo(it.login))
            },
            onRetry = {
                onEvent(UserContract.Event.OnRetryGetUsers)
            }
        )
    }
}