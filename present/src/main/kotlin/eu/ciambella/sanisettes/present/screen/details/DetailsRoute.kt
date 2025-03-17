package eu.ciambella.sanisettes.present.screen.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import eu.ciambella.sanisettes.design.core.scaffold.MainScaffold
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun SanisetteDetailsRoute(
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    MainScaffold(
        state.value,
        modifier
    )
}
