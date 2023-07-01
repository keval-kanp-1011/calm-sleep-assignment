package dev.kevalkanpariya.calmsleepassignment.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StackThreeSheet(scaffoldState3: BottomSheetScaffoldState) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Red),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = if (scaffoldState3.bottomSheetState.currentValue == SheetValue.PartiallyExpanded) {
                "Partially Expanded: State 3"
            } else {
                "Expanded: State 3"
            },
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}