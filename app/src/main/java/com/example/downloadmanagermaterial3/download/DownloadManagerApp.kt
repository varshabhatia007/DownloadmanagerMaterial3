package com.example.downloadmanagermaterial3.download

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.downloadmanagermaterial3.navigation.DownloadManagerNavigation
import com.example.downloadmanagermaterial3.navigation.TopLevelDestination
import com.example.downloadmanagermaterial3.navigation.bottomNavItems
import com.example.downloadmanagermaterial3.ui.theme.DownloadManagerMaterial3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DownloadManagerApp() {
    DownloadManagerMaterial3Theme {
        val navController = rememberNavController()
        val bottomBarState = remember { mutableStateOf(true) }

        Scaffold(
            bottomBar = {
                AnimatedVisibility(visible = bottomBarState.value) {
                    MainBottomBar(
                        destinations = bottomNavItems,
                        onNavigateToDestination = { destination ->
                            navController.navigate(destination.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        currentDestination = navController.currentBackStackEntryAsState().value?.destination
                    )
                }
            }
        ) { innerPadding ->
            DownloadManagerNavigation(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                bottomBarState = bottomBarState
            )
        }
    }
}

@Composable
private fun MainBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    NavigationBar {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)

            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }

                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = destination.route
                    )
                },
                label = { Text(text = destination.title) },
                alwaysShowLabel = false
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination): Boolean =
    this?.hierarchy?.any {
        it.route?.contains(destination.route, true) ?: false
    } ?: false
