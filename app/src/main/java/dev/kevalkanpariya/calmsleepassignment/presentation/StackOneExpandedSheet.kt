package dev.kevalkanpariya.calmsleepassignment.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StackOneSheet(scaffoldState1: BottomSheetScaffoldState, scope: CoroutineScope) {

    val scaffoldStateStack2 = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(initialValue = SheetValue.PartiallyExpanded, skipPartiallyExpanded = false)
    )

    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {

        if (scaffoldState1.bottomSheetState.currentValue == SheetValue.Expanded) {
            BottomSheetScaffold(
                sheetPeekHeight = 100.dp,
                scaffoldState = scaffoldStateStack2,
                sheetContainerColor = Color.Yellow,
                containerColor = Color.White,
                sheetContent = {
                    StackTwoSheet(
                        scaffoldState2 = scaffoldStateStack2, scope = scope
                    )
                }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(onClick = { scope.launch { scaffoldStateStack2.bottomSheetState.expand() } }) {
                        Text("Expand: STATE 2")
                    }

                }
            }
        }
    }
}
