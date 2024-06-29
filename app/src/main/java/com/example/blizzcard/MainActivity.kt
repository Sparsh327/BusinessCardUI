package com.example.blizzcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blizzcard.ui.theme.BlizzCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlizzCardTheme {
            Surface {
                CreateBizCard()
            }
            }
        }
    }
}




@Composable
fun CreateBizCard(){
val buttonClickedState = remember {
    mutableStateOf(false)
}
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
       Card(
           modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight()
               .padding(16.dp),
           shape = RoundedCornerShape(corner = CornerSize(15.dp)),
           elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
           colors = CardDefaults.cardColors(containerColor = Color.White)
       ) {
        Column(
            horizontalAlignment =Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()

                       // .padding(20.dp)

        ) {
            CreateImageProfile()
            Divider()
            ContactInfo()
            Button(onClick = {
                buttonClickedState.value = !buttonClickedState.value
            }) {
                Text(text = "Portfolio", style = MaterialTheme.typography.titleMedium)
                
            }
            if(!buttonClickedState.value){
                Content()
            }else{
                Box{}
            }


        }
       }
    }
}

@Composable
private fun ContactInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Miles.P", style = MaterialTheme.typography.titleLarge,
            color = Color.Blue
        )
        Text(
            text = "Android Compose Programmer", style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = "@themilesCompse", style = MaterialTheme.typography.titleMedium,
        )

    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(10.dp),

        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = Color.White
    ) {
        Image(
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.dp), contentDescription = ""
        )

    }
}

@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp),

        ) {
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),

shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            color = Color.White

        ) {
Portfolio(data = listOf("Project 1", "Project 2", "Project 3","Project 4",
    "Project 5","Project 6","Project 7"
    ))
        }

    }
}

@Composable
fun Portfolio(data: List<String>) {
  LazyColumn {
      items(data) {     item->
           Card(
               modifier = Modifier
                   .padding(15.dp)
                   .fillMaxWidth(),
               shape = RectangleShape,
              colors = CardDefaults.cardColors(containerColor = Color.White)
           ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                     //   .padding(8.dp)
                      //  .background(MaterialTheme.colorScheme.surface)
                       // .padding(16.dp)
                ){

                CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A great project")
                    }

                }
           }

      }
  }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BlizzCardTheme {
        CreateBizCard()
    }
}