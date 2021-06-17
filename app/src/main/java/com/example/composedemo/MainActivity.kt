package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}


@Composable
fun Main() {
    Scaffold(
        modifier = Modifier.background(color = Color(0xffFAFBFB)),
        topBar = {
            TopAppBar(
                modifier = Modifier.height(90.dp),
                title = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.one),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,            // crop the image if it's not a square
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)                       // clip to the circle shape

                        )
                        Column() {
                            Text(text = "Pawan Acharya")
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(3.dp)

                            ) {
                                Text(
                                    text = "Online",
                                    style = TextStyle(
                                        fontWeight = FontWeight.W300,
                                        fontSize = 14.sp
                                    )
                                )
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .clip(CircleShape)
                                        .background(Color.Green)

                                )
                            }

                        }
                    }
                },
                backgroundColor = Color(0xff01519F),
                contentColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Rounded.ArrowBackIos, null, Modifier.size(24.dp))
                    }
                },
                actions = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Rounded.MoreVert, null)
                    }

                }
            )
        },
    ) {
        InnerBody()
    }

}


@Composable
fun InnerBody() {
    Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxSize(1f)) {
        val message = remember { mutableStateOf("Hello") }
        TextField(

            value = message.value,
            onValueChange = { it ->
                message.value = it
            },


            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(12.dp)
                .background(color = Color.White)
                .border(width = 1.dp, color = Color(0xffF2F2F3), shape = RoundedCornerShape(20.dp))
                .clip(shape = RoundedCornerShape(20.dp)),

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
            ),
            leadingIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(
                        Icons.Rounded.EmojiEmotions,
                        null,
                        Modifier.size(24.dp),
                        tint = Color(0xff00C19C)


                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(
                        Icons.Rounded.KeyboardVoice,
                        null,
                        Modifier
                            .size(20.dp)
                            .background(Color(0xff00C19C), shape = CircleShape,),

                        tint = Color(0xffFFFFFF)


                    )
                }
            },


            )


    }
}


@Preview
@Composable
fun GreetingPreview() {
    Main()

}

