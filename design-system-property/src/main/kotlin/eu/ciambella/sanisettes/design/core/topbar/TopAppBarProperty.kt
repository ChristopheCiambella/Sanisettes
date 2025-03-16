package eu.ciambella.sanisettes.design.core.topbar

sealed class TopAppBarProperty {
    data class Default(
        val titleResId: Int
    ) : TopAppBarProperty()
}
