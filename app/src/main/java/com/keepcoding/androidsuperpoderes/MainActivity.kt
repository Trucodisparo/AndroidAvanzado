package com.keepcoding.androidsuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keepcoding.androidsuperpoderes.navigation.NavigationGraph
import com.keepcoding.androidsuperpoderes.presentation.login.LoginScreen
import com.keepcoding.androidsuperpoderes.ui.theme.AndroidSuperPoderesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidSuperPoderesTheme {
                NavigationGraph()
            }
        }
    }
}


@Composable
fun BaseComposable(
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier
            .height(300.dp)
            .width(300.dp),
        color = Color(red = 0, blue = 0, green = 255),
    ) {
        Box {
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(30.dp)
                    .align(Alignment.Center),
                color = Color(red = 255, blue = 0, green = 0)
            ) {
                Box {
                    Surface(
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp),
                        color = Color(red = 255, blue = 255, green = 255)
                    ) {}
                }
                Box {
                    Surface(
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp)
                            .align(Alignment.CenterEnd),
                        color = Color(red = 0, blue = 255, green = 0)
                    ) {}
                }
            }
        }

        Box {
            Surface(
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp)
                    .align(Alignment.BottomStart),
                color = Color(red = 0, blue = 0, green = 0)
            ) {}
        }

        Box {
            Surface(
                modifier = Modifier
                    .width(90.dp)
                    .height(270.dp)
                    .align(Alignment.Center),
                color = Color(red = 150, blue = 150, green = 150)
            ) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExercisePreview(){
    AndroidSuperPoderesTheme() {
        BaseComposable{}
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text("Bye!")
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidSuperPoderesTheme {
        Greeting("Android")
    }
}

@Composable
fun BaseComposable2(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Box(modifier = Modifier.weight(2f))
            Box(modifier = Modifier
                .background(Color.Blue)
                .weight(2f)
                .aspectRatio(1f))
            Box(modifier = Modifier
                .background(Color.Red)
                .weight(3f)
                .aspectRatio(1f))
            Box(modifier = Modifier
                .background(Color.Yellow)
                .weight(4f)
                .aspectRatio(1f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Box(modifier = Modifier
                    .background(Color.Blue)
                    .weight(11f)
                    .aspectRatio(1f))
                Box(modifier = Modifier
                    .background(Color.Red)
                    .weight(22f)
                    .aspectRatio(1f))
                Box(modifier = Modifier
                    .background(Color.Yellow)
                    .fillMaxHeight()
                    .weight(33f)
                    .aspectRatio(1f))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Black)
                .aspectRatio(1f))
            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.DarkGray)
                .aspectRatio(1f))
            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Blue)
                .aspectRatio(1f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = Modifier
                .background(Color.Green)
                .weight(1f)
                .fillMaxHeight())
            Box(modifier = Modifier
                .background(Color.Cyan)
                .weight(1f)
                .fillMaxHeight())
            Box(modifier = Modifier
                .background(Color.Magenta)
                .weight(1f)
                .fillMaxHeight())
        }
        Spacer(modifier = Modifier.size(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)) {
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.Blue)
                        .weight(2f)
                    )
                    Row(modifier = Modifier.weight(3.5f)) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .background(Color.White)
                                .weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .background(Color.Red)
                                .weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .background(Color.Yellow)
                                .weight(1f)
                        )
                    }
                    Row(modifier = Modifier.weight(3.5f)) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .background(Color.Cyan)
                                .weight(1f)
                        )
                        Column(modifier = Modifier.fillMaxHeight().weight(1f)) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Blue)
                                    .weight(1f)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Red)
                                    .weight(1f)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Yellow)
                                    .weight(1f)
                            )
                        }
                    }
                    Column(modifier = Modifier.fillMaxHeight().weight(2f)) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Blue)
                            .weight(1f)
                        )
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red)
                            .weight(1f)
                        )
                    }

                }
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)) {
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.Red)
                        .weight(2f)
                    )
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.Green)
                        .weight(3.5f)
                    )
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.White)
                        .weight(3.5f)
                    )
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.Red)
                        .weight(2f)
                    )
                }
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)) {
                    Box(modifier = Modifier.fillMaxHeight().background(Color.Yellow).weight(1f))
                    Box(modifier = Modifier.fillMaxHeight().background(Color.Black).weight(1f))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExercisePreview2(){
    AndroidSuperPoderesTheme() {
        BaseComposable2{}
    }
}