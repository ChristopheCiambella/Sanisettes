package eu.ciambella.sanisettes.design.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.ciambella.sanisettes.design.R

@Composable
fun Loading(
    property: LoadingProperty? = null,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(16.dp)
                .size(40.dp),
            color = colorResource(R.color.loading),
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
    property?.nextCallback?.invoke()
}

@Preview
@Composable
fun LoadingPreview() {
    Loading()
}
