package eu.ciambella.sanisettes.design.core.bottombar

data class NavigationBarItemProperty(
    val iconResId: Int,
    val labelResId: Int,
    val isSelected: Boolean,
    val onClick: () -> Unit
)
