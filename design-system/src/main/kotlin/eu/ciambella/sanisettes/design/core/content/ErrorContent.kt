package eu.ciambella.sanisettes.design.core.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.ciambella.sanisettes.design.components.ErrorProperty

@Composable
fun ErrorContent(
    property: ErrorProperty,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        property.title?.also { title ->
            Text(
                text = title,
                textAlign = TextAlign.Center
            )
        }
        property.message?.also { message ->
            Text(
                text = message,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                    top = 8.dp
                )
            )
        }
    }
}

@Preview
@Composable
fun ErrorContentPreview() {
    ErrorContent(
        property = ErrorProperty(
            title = "Impossible de charger cette page",
            message = "Vérifiez votre connexion internet.",
        )
    )
}
