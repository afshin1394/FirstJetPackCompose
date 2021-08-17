package com.samiei.inception.Compose

import android.content.res.Configuration
import android.view.View
import androidx.compose.compiler.plugins.kotlin.ComposeFqNames
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samiei.inception.Model.User
import com.samiei.inception.R


@Composable
fun ItemView(user: User) {

    var isExpanded by remember { mutableStateOf(false) }



        Row(
            modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(shape = CircleShape, elevation = 8.dp, modifier = Modifier.padding(4.dp)) {

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RectangleShape)
                        .border(1.6.dp, Color.Cyan, CircleShape)
                )

            }


            Spacer(modifier = Modifier.width(8.dp))


            Column() {
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp) {

                    Text(
                        text = user.name,
                        style = MaterialTheme.typography.h6,
                        color = Color.Cyan
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp) {
                    Text(
                        text = "Age : ${user.age}",
                        style = MaterialTheme.typography.body2
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp) {

                    Text(
                        text = "Bio : ${user.description}",
                        style = MaterialTheme.typography.body2,
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        )
                }

            }
//

    }

}


