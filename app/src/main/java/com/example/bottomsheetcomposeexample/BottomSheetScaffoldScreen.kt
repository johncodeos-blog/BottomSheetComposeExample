package com.example.bottomsheetcomposeexample

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScaffoldScreen() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        sheetContent = {
            BottomSheetContent()
        },
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = colorResource(id = R.color.colorPrimary),
        // sheetPeekHeight = 0.dp,
        // scrimColor = Color.Red,  // Color for the fade background when you open/close the bottom sheet
    ) {
        Scaffold(
            topBar = { TopBar() },
            backgroundColor = colorResource(id = R.color.colorPrimaryDark)
        ) {
            BottomSheetScaffoldMainScreen(scope = scope, state = bottomSheetScaffoldState)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomSheetScaffoldScreenPreview() {
    BottomSheetScaffoldScreen()
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScaffoldMainScreen(scope: CoroutineScope, state: BottomSheetScaffoldState) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.colorPrimary),
                contentColor = Color.White
            ),
            onClick = {
                scope.launch {
                    if (state.bottomSheetState.isCollapsed) {
                        state.bottomSheetState.expand()
                    } else {
                        state.bottomSheetState.collapse()
                    }
                }
            }) {
            if (state.bottomSheetState.isCollapsed) {
                Text(text = "Open Bottom Sheet Scaffold")
            } else {
                Text(text = "Close Bottom Sheet Scaffold")
            }
        }
    }
}
