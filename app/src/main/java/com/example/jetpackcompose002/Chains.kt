package com.example.jetpackcompose002

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun ConstrintClainExa() {
    ConstraintLayout(Modifier.fillMaxSize()) {

        ConstraintLayout(Modifier.fillMaxSize()) {
            val (boxRed, boxBlue, boxBlack) = createRefs()
            Box(
                Modifier
                    .size(50.dp)
                    .background(color = Color.Blue)
                    .constrainAs(boxBlue) {

                        start.linkTo(parent.start)
                        end.linkTo(boxBlack.start)
                    })

            Box(
                Modifier
                    .size(50.dp)
                    .background(color = Color.Black)
                    .constrainAs(boxBlack) {

                        start.linkTo(boxBlue.end)
                        end.linkTo(boxRed.start)
                    })

            Box(
                Modifier
                    .size(50.dp)
                    .background(color = Color.Red)
                    .constrainAs(boxRed) {

                        start.linkTo(boxBlack.end)
                        end.linkTo(parent.end)
                    })

            // tambien hay un  createVerticalChain
            createHorizontalChain(boxRed, boxBlue, boxBlack, chainStyle = ChainStyle.SpreadInside
            //Spread
        // ChainStyle.Packed
        )
        }
    }
}