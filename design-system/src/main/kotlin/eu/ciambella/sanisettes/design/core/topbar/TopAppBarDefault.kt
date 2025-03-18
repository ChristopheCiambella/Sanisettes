package eu.ciambella.sanisettes.design.core.topbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSwitchFilter(
    property: TopAppBarProperty.SwitchFilterAppBar,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = property.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = property.switchLabel,
                    modifier = Modifier.padding(
                        end = 8.dp
                    )
                )
                Switch(
                    checked = property.switchFilterOn,
                    onCheckedChange = property.switchFilterChanged
                )
            }
        }
    )
}
