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
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StackTwoSheet(scaffoldState2: BottomSheetScaffoldState, scope: CoroutineScope) {

    val scaffoldStateStack3 = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(initialValue = SheetValue.PartiallyExpanded, skipPartiallyExpanded = false)
    )

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Yellow),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = if (scaffoldState2.bottomSheetState.currentValue == SheetValue.PartiallyExpanded) {
                "Partially Expanded: State 2"
            } else {
                "Expanded: State 2"
            },
            fontSize = 20.sp,
            color = Color.Black
        )

        if (scaffoldState2.bottomSheetState.currentValue == SheetValue.Expanded) {
            BottomSheetScaffold(
                sheetPeekHeight = 100.dp,
                scaffoldState = scaffoldStateStack3,
                sheetContainerColor = Color.Red,
                containerColor = Color.Yellow,
                sheetContent = {
                    StackThreeSheet(
                        scaffoldState3 = scaffoldStateStack3
                    )
                }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(Color.Yellow),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(onClick = { scope.launch { scaffoldStateStack3.bottomSheetState.expand() } }) {
                        Text("Expand: STATE 3")
                    }

                }
            }
        }
    }
}