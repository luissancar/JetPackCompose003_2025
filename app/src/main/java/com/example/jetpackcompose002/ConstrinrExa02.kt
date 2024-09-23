package com.example.jetpackcompose002

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable

fun ConstrinrExa02() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.5f)  //10%
        val StartGuide = createGuidelineFromStart(0.3f)  //10%
        Box(
            Modifier
                .size(125.dp)
                .background(color = Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGuide)
                    start.linkTo(StartGuide)
                })

    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun ConstraintBarr() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxBlack) = createRefs()
        val barrier = createEndBarrier(boxBlue, boxBlack)
        Box(
            Modifier
                .size(125.dp)
                .background(color = Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(parent.start, margin = 16.dp)

                })

        Box(
            Modifier
                .size(235.dp)
                .background(color = Color.Black)
                .constrainAs(boxBlack) {
                    top.linkTo((boxBlue.bottom))
                    start.linkTo(parent.start, margin = 32.dp)

                })

        Box(
            Modifier
                .size(50.dp)
                .background(color = Color.Red)
                .constrainAs(boxRed){
                   start.linkTo(barrier)


        })
    }

}
















