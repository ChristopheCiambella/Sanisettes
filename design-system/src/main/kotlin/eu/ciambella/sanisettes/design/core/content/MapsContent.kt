package eu.ciambella.sanisettes.design.core.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsContent(
    property: MapsContentProperty,
    modifier: Modifier = Modifier,
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(
                property.startLatitude,
                property.startLongitude
            ),
            property.startZoom
        )
    }
    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapLoaded = {

        }
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
