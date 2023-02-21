package com.example.downloadmanagermaterial3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.downloadmanagermaterial3.home.HomeScreen
import com.example.downloadmanagermaterial3.home.HomeViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.downloadmanagermaterial3.detail.DetailScreen

@Composable
fun DownloadManagerNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TopLevelDestination.Home.route
    ) {
        composable(route = TopLevelDestination.Home.route) { backStackEntry ->
            bottomBarState.value = true
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(homeViewModel)
        }

        composable(route = TopLevelDestination.ImageUrls.route) { backStackEntry ->
            bottomBarState.value = true
            val homeViewModel: HomeViewModel = hiltViewModel()
            DetailScreen(homeViewModel)
        }
    }
}
