package co.id.ilhamelmujib.githubuser.feature.users

import base.BaseViewModel
import org.koin.core.annotation.KoinViewModel

class UserViewModel: BaseViewModel<UserContract.Event, UserContract.State, UserContract.Effect>() {
    override fun createInitialState(): UserContract.State {
        return UserContract.State(
            isLoading = false
        )
    }

    override fun handleEvent(event: UserContract.Event) {
    }
}