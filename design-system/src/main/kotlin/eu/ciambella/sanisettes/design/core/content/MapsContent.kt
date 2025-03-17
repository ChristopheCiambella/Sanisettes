package eu.ciambella.sanisettes.design.core.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import eu.ciambella.sanisettes.design.components.SanisetteSheet
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

@Composable
fun MapsContent(
    property: MapsContentProperty,
    modifier: Modifier = Modifier,
) {
    var initialCameraSet by remember { mutableStateOf(false) }
    val cameraPositionState = rememberCameraPositionState()
    property.mapsProperty.centerOnPosition?.also { (latitude, longitude) ->
        LaunchedEffect(Unit) {
            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(
                LatLng(latitude, longitude),
                property.mapsProperty.centerZoom ?: 11F
            )
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
                    property.mapsProperty.onLocationChanged(
                        cameraPositionState.position.target.latitude,
                        cameraPositionState.position.target.longitude
                    )
                }
            }
    }
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        GoogleMap(
            modifier = modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
        ) {
            property.mapsProperty.markers.forEach { marker ->
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
        property.sheetProperty?.also {
            SanisetteSheet(
                property = it,
                modifier = Modifier.padding(
                    bottom = WindowInsets.navigationBars
                        .asPaddingValues()
                        .calculateBottomPadding()
                )
            )
        }
    }
}
