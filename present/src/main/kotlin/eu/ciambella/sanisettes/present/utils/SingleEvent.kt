package eu.ciambella.sanisettes.present.utils

import java.util.concurrent.atomic.AtomicBoolean

class SingleEvent<out T>(
    private val content: T
) {

    private val hasBeenHandled = AtomicBoolean(false)

    fun getContentIfNotHandled(): T? = if (hasBeenHandled.get()) {
        null
    } else {
        hasBeenHandled.set(true)
        content
    }
}
