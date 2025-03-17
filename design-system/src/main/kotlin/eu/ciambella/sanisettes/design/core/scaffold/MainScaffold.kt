package eu.ciambella.sanisettes.design.core.scaffold

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.ciambella.sanisettes.design.core.bottombar.AppNavigationBar
import eu.ciambella.sanisettes.design.core.bottomsheet.BottomSheet
import eu.ciambella.sanisettes.design.core.content.Content
import eu.ciambella.sanisettes.design.core.topbar.AppTopAppBar

@Composable
fun MainScaffold(
    property: ScaffoldProperty,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            property.topAppBarProperty?.also {
                AppTopAppBar(it)
            }
        },
        content = {
            property.bottomSheetContentProperty?.also { bottomSheet ->
                BottomSheet(
                    property = bottomSheet,
                )
            }
            Content(
                property = property.contentProperty,
                modifier = Modifier.padding(it)
            )
        },
        bottomBar = {
            property.navigationBarProperty?.also {
                AppNavigationBar(bottomBarProperty = it)
            }
        }
    )
}
