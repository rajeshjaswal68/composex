package `in`.digitalgears.composex.myUI

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun ComposeOne() {
    Column(
        modifier = Modifier
            .fillMaxSize(0.65f)
            .padding(16.dp)
            .background(Color.Green),


        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Text(text = "Hello Circus!", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "Nello Focus!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Fellow Locus!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )

    }

}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = "the land of rising sun",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ), startY = 1000f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 32.sp,
                        fontFamily = FontFamily.Cursive
                    ),
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.LineThrough
                )
            }
        }
    }

}

@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    val color = remember {
        mutableStateOf(
            Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        )
    }

    Box(
        modifier = modifier
            .background(color.value)
            .clickable {
                color.value = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
            }
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)),
            contentAlignment = Alignment.Center,


            ) {
            Text(
                "Composable Internal State. External State also possible, but is messier. there are better solutions in upcoming tutorials",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(all = 20.dp)


            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SkullFold() {

    /*
    Scaffold allows you to implement a UI with the basic Material Design layout structure. Scaffold provides slots for the most common top-level Material components, such as TopAppBar, BottomAppBar, FloatingActionButton, and Drawer.
     */

    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember { mutableStateOf("")}
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 150.dp)
        ) {
            TextField(
                value = textFieldState,
                onValueChange = { textFieldState = it},
                label = { Text("Enter your name") },
                singleLine = true
            )
            //Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                scope.launch { scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState") }

            }) {
                Text(text = "Greet Me!")
            }
        }

    }
}

@Composable
fun ListColumn(){
    val scrollState = rememberScrollState()
    Column (
         modifier = Modifier.verticalScroll(scrollState)
            ) {
        for (i in 1..50) {
            Text(
                text = "Item $i",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 24.dp)
                )
        }
    }
}

@Composable
fun ListLazy(){
    // LazyColumn is scrollable by default; don't need to maintain state
    LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(vertical = 45.dp, horizontal = 20.dp)
    ) {
        items(100){
            val x = it + 1
            val backgroundColor = if (it % 2 == 0) Color.Gray
            else{
                if (it % 2 == 0) Color.Yellow else Color.LightGray
            }
            Text(
                text =  " Item $x", // ORIG: text =  " Item $it"
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor)


            )
        }
    }
}

@Composable
fun ListLazy2(){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(vertical = 45.dp)
    ){
        itemsIndexed(
            listOf("This", "is", "Kotlin","Compose", "example")
        ) {index, string ->
            val backgroundColor = if (index % 2 == 0) Color.Gray
            else{
                if (index % 2 == 0) Color.Yellow else Color.LightGray
            }
            Text(
                text =  string,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .background(backgroundColor)

            )

        }
    }
}

@Composable
fun ListLazy3(){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ){
        itemsIndexed(
            listOf("This", "is", "Kotlin","Compose", "example")
        ) {index, string ->
            Text(
                text =  string,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
            )

        }
    }
}






// horizontalAlignment = Alignment.CenterVertically
// Spacer(modifier = Modifier.width(30.dp))
// Log.d("kibbutz", "The Kibbutz Startup");

