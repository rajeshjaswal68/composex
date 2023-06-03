package `in`.digitalgears.composex

import `in`.digitalgears.composex.myUI.*
import `in`.digitalgears.composex.ui.theme.ComposexTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposexTheme {
                /*
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Rajesh")
                    Log.d("Paaji", "Here I am!")
                }
            } */

                Logger.setTag("MyTag-Kermit")
                Logger.v { "Hello, this is Kermit logging " }
                Logger.d { "Hello, this is Kermit logging "}
                Logger.i { "Hello, this is Kermit logging " }
                Logger.w { "Hello, this is Kermit logging "}
                Logger.e { "Hello, this is Kermit logging "}
                Logger.a { "Hello, this is Kermit logging "}

                //ComposeOne()
                ImagesCard()
                //ColorBox(Modifier.fillMaxSize())
                //SkullFold()  // Scaffold, Textfields, Buttons & Showing Snackbars
                //ListColumn()
                //ListLazy()
                //ListLazy2() // itemsIndexed & LazyRow
                //ListLazy3() // itemsIndexed
                //MyCanvas()
                //MySump()
                //myNavigation()





            }
        }
    }

}

@Composable
fun ImagesCard(){
    val painter = painterResource(id = R.drawable.sunrise)
    val description = "the land of the rising sun!"
    val title = "the land of the rising sun"
    Box(
        modifier = Modifier
            .fillMaxSize(0.9f)
            .padding(16.dp)
    ) {
        ImageCard(
            painter = painter,
            contentDescription = description,
            title = title
        )
    }
}