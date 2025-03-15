package eu.ciambella.toilettest.present.screen.maps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import eu.ciambella.design.scaffold.MainScaffold
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ToiletMapsRoute(
    modifier: Modifier = Modifier,
    viewModel: ToiletMapsViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = rememberUpdatedState(LocalLifecycleOwner.current)
    DisposableEffect(lifecycleOwner.value) {
        val lifecycle = lifecycleOwner.value.lifecycle
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> viewModel.create()
                else -> Unit
            }
        }
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
    MainScaffold(
        state.value,
        modifier
    )
}
