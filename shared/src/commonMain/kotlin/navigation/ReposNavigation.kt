package navigation

import BaseNavigation
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object ReposNavigation : BaseNavigation() {
    override val route = "repos"
    const val ARG_USER_ID = "userId"

    override val arguments = listOf(
        navArgument(ARG_USER_ID) { type = NavType.StringType }
    )

    fun createRoute(userId: String) = "$route/$userId"
}

//fun NavGraphBuilder.reposGraph(navController: NavController) {
//    composable(
//        route = ReposNavigation.destination,
//        arguments = ReposNavigation.arguments
//    ) { backStackEntry ->
//        val userId = backStackEntry.arguments?.getString(ReposNavigation.ARG_USER_ID)
//            ?: throw IllegalStateException("User ID is required")
//
//        ReposScreenDestination(
//            UserId = userId,
//            navController = navController
//        )
//    }
//}