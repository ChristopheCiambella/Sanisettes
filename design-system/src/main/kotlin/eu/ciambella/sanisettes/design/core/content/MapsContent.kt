package eu.ciambella.sanisettes.design.core.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

private const val BOUNDS_PADDING_PIXEL = 100

@Composable
fun MapsContent(
    property: MapsContentProperty,
    modifier: Modifier = Modifier,
) {
    val cameraPositionState = rememberCameraPositionState()
    LaunchedEffect(Unit) {
        if (property.markers.isNotEmpty()) {
            val builder = LatLngBounds.Builder()
            property.markers.forEach {
                builder.include(
                    LatLng(it.latitude, it.longitude)
                )
            }
            val bounds = builder.build()
            val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, BOUNDS_PADDING_PIXEL)
            cameraPositionState.animate(cameraUpdate)
        }
    }
    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
    ) {
        property.markers.forEach { marker ->
            Marker(
                state = MarkerState(
                    position = LatLng(
                        marker.latitude,
                        marker.longitude
                    )
                ),
                title = marker.title,
                onClick = {
                    marker.onClick.invoke()
                    true
                }
            )
        }
    }
}
