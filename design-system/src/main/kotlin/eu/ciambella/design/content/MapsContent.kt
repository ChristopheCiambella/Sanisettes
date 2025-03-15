package eu.ciambella.design.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import eu.ciambella.design.components.ToiletCard
import eu.ciambella.design.toilettest.components.ToiletCardProperty
import eu.ciambella.design.toilettest.content.LazyColumnContentProperty
import eu.ciambella.design.toilettest.content.MapsContentProperty

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

    }
}
