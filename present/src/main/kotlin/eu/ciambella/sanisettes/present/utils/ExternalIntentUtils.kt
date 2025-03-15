package eu.ciambella.sanisettes.present.utils

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri

object ExternalIntentUtils {

    fun startNavigationActivity(
        context: Context,
        address: String
    ) {
        val uri = Uri.parse("google.navigation:q=" + Uri.encode(address))
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            setPackage("com.google.android.apps.maps")
            flags = FLAG_ACTIVITY_NEW_TASK
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }

}
