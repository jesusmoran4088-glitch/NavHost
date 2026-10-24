package udg.cuvalles.mynavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            Home(
                onNavigateProfile = { id, name ->
                    navController.navigate(Profile(userId = id, userName = name))
                }
            )
        }

        composable<Profile> { backStackEntry ->
            // Extraemos los datos usando la nueva API de Navigation
            val profile = backStackEntry.toRoute<Profile>()

            Profile(
                userId = profile.userId,
                userName = profile.userName,
                onBack = { navController.popBackStack() }
            )
        }
    }
}