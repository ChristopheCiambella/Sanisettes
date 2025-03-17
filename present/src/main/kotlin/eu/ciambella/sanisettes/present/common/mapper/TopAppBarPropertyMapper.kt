package eu.ciambella.sanisettes.present.common.mapper

import android.content.Context
import eu.ciambella.sanisettes.design.core.topbar.TopAppBarProperty
import eu.ciambella.sanisettes.present.R

class TopAppBarPropertyMapper(
    private val context: Context,
) {

    fun mapSimpleTopAppBar(): TopAppBarProperty = TopAppBarProperty.SimpleAppBar(
        title = context.getString(R.string.app_name),
    )

    fun mapPmrFilterTopAppBar(
        pmrFilterEnable: Boolean,
        onPmrFilterValueChange: (Boolean) -> Unit,
    ): TopAppBarProperty = TopAppBarProperty.SwitchFilterAppBar(
        title = context.getString(R.string.app_name),
        switchLabel = context.getString(R.string.pmr),
        switchFilterOn = pmrFilterEnable,
        switchFilterChanged = onPmrFilterValueChange
    )
}
