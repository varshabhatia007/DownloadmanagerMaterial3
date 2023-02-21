package com.example.downloadmanagermaterial3.navigation

import androidx.annotation.DrawableRes
import com.example.downloadmanagermaterial3.R

sealed class TopLevelDestination(
    val title: String,
    val route: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
) {
    object Home : TopLevelDestination(
        title = "Home",
        route = "home",
        selectedIcon = R.drawable.ic_home_filled,
        unselectedIcon = R.drawable.ic_home_outlined
    )

    object ImageUrls : TopLevelDestination(
        title = "ImageUrl",
        route = "imageurl",
        selectedIcon = R.drawable.ic_search_filled,
        unselectedIcon = R.drawable.ic_search_outlined
    )
}

val bottomNavItems = listOf(
    TopLevelDestination.Home,
    TopLevelDestination.ImageUrls,
)
