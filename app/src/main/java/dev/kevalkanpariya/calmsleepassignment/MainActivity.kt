package dev.kevalkanpariya.calmsleepassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.calmsleepassignment.presentation.StackOneSheet
import dev.kevalkanpariya.calmsleepassignment.ui.theme.CalmSleepAssignmentTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalmSleepAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Screen()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen() {
    val scope = rememberCoroutineScope()
    val scaffoldStateStack1 = rememberBottomSheetScaffoldState()
    
    BottomSheetScaffold(
        scaffoldState = scaffoldStateStack1,
        sheetPeekHeight = 240.dp,
        sheetContainerColor = Color.White,
        sheetContent = {
            StackOneSheet(
                scaffoldState1 = scaffoldStateStack1,
                scope = scope
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { scope.launch { scaffoldStateStack1.bottomSheetState.expand() } }) {
                Text("Expand: STATE 1")
            }

        }
    }


}