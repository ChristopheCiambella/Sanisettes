package eu.ciambella.sanisettes.present.common.mapper

import android.content.Context
import eu.ciambella.sanisettes.design.components.ErrorProperty
import eu.ciambella.sanisettes.present.R

class ErrorPropertyMapper(
    private val context: Context
) {

    fun mapUnknownError() = ErrorProperty(
        title = context.getString(R.string.error_title),
        message = context.getString(R.string.error_message),
    )
}
