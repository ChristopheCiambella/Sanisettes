package eu.ciambella.sanisettes.design.core.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

@Composable
fun MapsContent(
    property: MapsContentProperty,
    modifier: Modifier = Modifier,
) {
    var initialCameraSet by remember { mutableStateOf(false) }
    val cameraPositionState = rememberCameraPositionState()
    property.centerOnPosition?.also { (latitude, longitude) ->
        LaunchedEffect(Unit) {
            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(latitude, longitude), 11F)
            cameraPositionState.animate(cameraUpdate)
            initialCameraSet = true
        }
    }
    LaunchedEffect(cameraPositionState) {
        snapshotFlow { cameraPositionState.isMoving }
            .distinctUntilChanged()
            .filter { moving -> !moving }
            .collect {
                if (initialCameraSet) {
                    property.onLocationChanged(
                        cameraPositionState.position.target.latitude,
                        cameraPositionState.position.target.longitude
                    )
                }
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
