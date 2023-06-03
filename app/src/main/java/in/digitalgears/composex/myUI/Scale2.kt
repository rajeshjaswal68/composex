package `in`.digitalgears.composex.myUI

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyScale2() {
    Canvas(
        modifier = Modifier
            .padding(horizontal = 25.dp, vertical = 50.dp)
            .size(100.dp, 600.dp)
    ) {
        drawRect(
            color = Color.LightGray,
            size = size,
            style = Stroke(
                width = 5f
            )
        )
        for (i in 0..600 step 60){
            val foot = "$i"
            Log.d("foot", "$foot");
            drawLine(
                color = Color.Red,
                start = Offset(50.dp.toPx(), foot.toFloat().dp.toPx()),
                end = Offset(100.dp.toPx(), foot.toFloat().dp.toPx()),
                strokeWidth = 5f
            )
        }

        for (j in 0..540 step 60){
            val halfY = 30
            val halfFoot = j + halfY
            Log.d("foot", "$halfFoot");
            drawLine(
                color = Color.Red,
                start = Offset(70.dp.toPx(), halfFoot.toFloat().dp.toPx()),
                end = Offset(100.dp.toPx(), halfFoot.toFloat().dp.toPx()),
                strokeWidth = 3f
            )
        }
    }

    Canvas(
        modifier = Modifier
            .padding(horizontal = 150.dp, vertical = 50.dp)
            .size(50.dp, 300.dp)
    ) {
        drawRect(
            color = Color.LightGray,
            size = size,
            style = Stroke(
                width = 3f
            )
        )
        for (i in 0..300 step 30){
            val foot = "$i"
            Log.d("foot", "$foot");
            drawLine(
                color = Color.LightGray,
                start = Offset(25.dp.toPx(), foot.toFloat().dp.toPx()),
                end = Offset(50.dp.toPx(), foot.toFloat().dp.toPx()),
                strokeWidth = 5f
            )
        }
        var a = 0
        for (j in 0..270 step 30){
            val half = 15
            val halfFoot = j + half
            Log.d("foot", "$halfFoot");
            drawLine(
                color = Color.LightGray,
                start = Offset(37.dp.toPx(), halfFoot.toFloat().dp.toPx()),
                end = Offset(50.dp.toPx(), halfFoot.toFloat().dp.toPx()),
                strokeWidth = 3f
            )
        }
    }
}

