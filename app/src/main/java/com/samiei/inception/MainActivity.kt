package com.samiei.inception

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.samiei.inception.Compose.ItemView
import com.samiei.inception.Model.User
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyView()
        }
    }
}


data class Message(val author: String, val body: String)

@Composable
fun MyView() {
    Scaffold {
        MyViewContent();
    }
}


@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(top = 8.dp, start = 8.dp, bottom = 8.dp, end = 8.dp))
    {
        Text(text = "Hello ${message.author}!")
        Text(text = message.body)
    }
}

fun showToast(context: Context, user: User) {
    Toast.makeText(context, user.description, Toast.LENGTH_SHORT).show()
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(message = Message("afshin", "salam"))
}


@Composable
fun MyViewContent() {

    val userList = remember {
        DataProvider.userList
    }
    val context = LocalContext.current
    LazyColumn(
        contentPadding = PaddingValues(2.dp, 2.dp)

    ) {

        items(userList) { user ->
            ItemView(
                user = user
            )
            androidx.compose.material.Divider(thickness = 2.dp)

//            Box(Modifier.clickable(onClick = { //handle onClick })) {
//                // Your item layout
//            }))


        }
    }


}









