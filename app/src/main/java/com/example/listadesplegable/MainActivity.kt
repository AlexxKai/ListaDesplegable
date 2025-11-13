package com.example.listadesplegable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listadesplegable.ui.theme.ListaDesplegableTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDesplegableTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            modifier = Modifier.height(60.dp),
                            title = {
                                Text(
                                    "Primera ventana",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = Color.White
                            )
                        )
                    }
                ) { innerPadding ->
                    Surface {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(innerPadding)
                                .background(Color.DarkGray),
                            horizontalAlignment = Alignment.CenterHorizontally
                        )
                        {
                            //Cuandro para entregar
                            LazyColumn(
                            ) {
                                //Un item simple
                                item {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Start,
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.lp2),
                                            contentDescription = "Imagen cargada en local",
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .border(
                                                    shape = CircleShape,
                                                    width = 2.dp,
                                                    color = Color.Black
                                                )
                                                .size(100.dp),
                                        )
                                        Column {
                                            Text(
                                                text = "Linkin Park",
                                                modifier = Modifier
                                                    .size(100.dp),
                                                color = Color.White
                                            )
                                            Text(
                                                text = "Descripción",
                                                modifier = Modifier
                                                    .size(70.dp),
                                                color = Color.Magenta
                                            )
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Carta() {
    Card {
        var expanded by remember { mutableStateOf(false) }
        Column(Modifier.clickable { expanded = !expanded }) {
            Image(painterResource(R.drawable.lp))
            AnimatedVisibility(expanded) {
                Text(
                    text = "Linkin Park",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
