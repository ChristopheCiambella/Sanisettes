package eu.ciambella.sanisettes.design.core.bottombar

data class NavigationBarItemProperty(
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val label: String,
    val isSelected: Boolean,
    val onClick: () -> Unit
)
