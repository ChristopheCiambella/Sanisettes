package eu.ciambella.sanisettes.design.core.bottombar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun AppNavigationBar(
    bottomBarProperty: NavigationBarProperty,
) {
    NavigationBar(
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        tonalElevation = 0.dp,
    ) {
        bottomBarProperty.navigationBarItems.forEach { navigationBarItem ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            if (navigationBarItem.isSelected) {
                                navigationBarItem.selectedIcon
                            } else {
                                navigationBarItem.unselectedIcon
                            }
                        ),
                        contentDescription = null
                    )
                },
                selected = navigationBarItem.isSelected,
                onClick = navigationBarItem.onClick,
                label = {
                    Text(
                        text = navigationBarItem.label,
                    )
                }
            )
        }
    }
}
