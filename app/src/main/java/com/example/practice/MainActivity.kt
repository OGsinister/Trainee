package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.stage_1.firstTask.FirstSingleton
import com.example.practice.stage_1.firstTask.SecondSingleton
import com.example.practice.stage_1.fourthTask.MultiEven
import com.example.practice.stage_1.fourthTask.multiIfEven
import com.example.practice.stage_1.secondTask.Audi
import com.example.practice.stage_1.secondTask.Kawasaki
import com.example.practice.stage_1.secondTask.Mercedes
import com.example.practice.stage_1.secondTask.Vehicles
import com.example.practice.stage_1.secondTask.Yamaha
import com.example.practice.stage_1.thirdTask.removeElement
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowName(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ShowName(modifier: Modifier = Modifier) {
    // First task
    val firstSingletonName = FirstSingleton.printName()
    val secondSingletonName = SecondSingleton.getInstance()

    // Second task
    val audi = Audi(name = "Audi", volume = 100.2f)
    val mercedes = Mercedes(name = "Mercedes", volume = 100.3f)
    val yamaha = Yamaha(name = "Yamaha", volume = 87.5f)
    val kawasaki = Kawasaki(name = "Kawasaki", volume = 87.4f)

    val listVehicles = listOf<Vehicles>(audi, mercedes, yamaha, kawasaki)
    val sortedVehicles = listVehicles.sortedByDescending { it.volume }

    // Third task
    val testArray = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)

    // Fourth task
    val list = listOf(3, 52, 3, 1, 5, 20)
    val multiEven = MultiEven(list)

    Text(
        text = firstSingletonName,
        modifier = modifier
    )

    Column(
        modifier = modifier
            .padding(top = 30.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(sortedVehicles){
                Text(text = it.toString())
            }
        }
        Spacer(modifier = modifier.padding(top = 20.dp))
        Text(text = removeElement(testArray, 2).contentToString())

        Column(
            modifier = modifier.padding(top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Text(text = "Base list: $list \n" +
                    "First Decorator list: ${multiEven.multiIfEven()}")

            Text(text = "Base list: $list \n" +
                    "Second Decorator list: ${list.multiIfEven()}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeTheme {
        ShowName()
    }
}