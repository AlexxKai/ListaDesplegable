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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
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
                                    "Grupos de música",
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
                        LazyColumn {
                            //Un item simple
                            item {
                                Row(
                                    modifier = Modifier
                                        .padding(10.dp)
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
                                    var expanded by remember { mutableStateOf(false) }
                                    val patata: String = LoremIpsum(200).values.first()
                                    Column(
                                        modifier = Modifier
                                            .clickable { expanded = !expanded }) {
                                        Text(
                                            text = "Linkin Park",
                                            color = Color.White
                                        )
                                        AnimatedVisibility(!expanded) {
                                            Text(
                                                text = "hola",
                                                color = Color.Magenta
                                            )
                                        }
                                        AnimatedVisibility(expanded) {
                                            Text(
                                                text = patata,
                                                color = Color.Magenta,
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
data class Mensaje(val nombre:String, val descCorta: String, val descLarga: String, val imagenID: Int)
private val mensajes: List<Mensaje> = listOf(
    Mensaje("Linkin Park", "Linkin Park es una banda estadounidense de rock alternativo y rap rock que en sus inicios se caracterizó por su sonido de nu metal y rap metal.", "sda", R.drawable.lp2),
    Mensaje("Título 2", "Descripción 2"),
    Mensaje("Título 3", "Descripción 3"),
    Mensaje("Título 4", "Descripción 4"),
    Mensaje("Título 5", "Descripción 5")
)
