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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
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
                val mensajes = listOf(
                    Mensaje(
                        "Linkin Park",
                        "Empezaron en 1996",
                        "Linkin Park es una banda estadounidense de rock alternativo y rap rock que en sus inicios se caracterizó por su sonido de nu metal y rap metal.",
                        R.drawable.lp2
                    ),
                    Mensaje(
                        "Sleeping With Sirens",
                        "Empezaron en 2009",
                        "Sleeping With Sirens es una banda estadounidense de post-hardcore procedente de Orlando, aunque actualmente reside en Grand Rapids, Estados Unidos. La banda fue fundada por miembros de For All We Know, Broadway, y Paddock Park.",
                        R.drawable.sleeping
                    ),
                    Mensaje(
                        "Desakato",
                        "Empezaron en 2003",
                        "Desakato fue un grupo de punk rock procedente de Llanera, en Asturias, que pese a cantar generalmente en castellano, en todos los discos incluye al menos un tema en asturiano. ",
                        R.drawable.zoo
                    ),
                    Mensaje(
                        "Zoo",
                        "Empezaron en 2014",
                        "ZOO, también conocido como Zoo Posse, fue un grupo musical valenciano nacido en 2014 en Gandía que se centra en el hip hop, el breakbeat, el rock y el ska, mezclados con ritmos electrónicos.",
                        R.drawable.lp2
                    ),
                    Mensaje(
                        "Aspencat",
                        "Empezaron en 2005",
                        "Aspencat fue un grupo musical español originario de Jalón, provincia de Alicante, en la Comunidad Valenciana. Su estilo se ha basado en el ska, el reggae y el drum and bass, pero en su última etapa han avanzado hacia unos ritmos más electrónicos donde se puede ver la presencia del dubstep.",
                        R.drawable.aspencat
                    ),
                )
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
                                containerColor = Color(0xFF6729DC),
                                titleContentColor = Color.White
                            )
                        )
                    }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(innerPadding)
                            .background(Color.Black),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        itemsIndexed(mensajes) { index, mensaje ->
                            Grupos(mensaje = mensaje, index = index)

                            if (index < mensajes.size - 1) {
                                HorizontalDivider(
                                    modifier = Modifier.padding(horizontal = 16.dp),
                                    thickness = 5.dp,
                                    color = Color(0xFFFFDE0D).copy(alpha = 0.4f)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class Mensaje(
    val nombre: String,
    val descCorta: String,
    val descLarga: String,
    val imagenID: Int
)

@Composable
fun Grupos(mensaje: Mensaje, index: Int) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFBABABD)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = mensaje.imagenID),
                contentDescription = "Imagen del grupo ${mensaje.nombre}",
                modifier = Modifier
                    .clip(CircleShape)
                    .border(shape = CircleShape, width = 2.dp, color = Color(0xFF6729DC))
                    .size(100.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = mensaje.nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Red
                )
                Text(
                    text = mensaje.descCorta,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                AnimatedVisibility(visible = expanded) {
                    Text(
                        text = mensaje.descLarga,
                        modifier = Modifier.padding(top = 8.dp),
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}
