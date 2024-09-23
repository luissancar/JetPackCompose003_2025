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
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Preview
fun ConstaintLayoyt01(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxBlue,boxBlack,boxYellow) = createRefs()

        Box(Modifier.size(125.dp).background(color = Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
           end.linkTo(parent.end)
        })
        Box(Modifier.size(125.dp).background(color = Color.Blue).constrainAs(boxBlue){
            bottom.linkTo(boxRed.top)
            start.linkTo(boxRed.end)
        })

        Box(Modifier.size(125.dp).background(color = Color.Black).constrainAs(boxBlack){
            bottom.linkTo(boxYellow.top)
            start.linkTo(boxYellow.end)
        })
        Box(Modifier.size(125.dp).background(color = Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
        })
    }
}