package com.bignerdranch.android.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.bignerdranch.android.firstcomposeproject.ui.theme.InstagramCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

            test(viewModel = viewModel)
//            FirstComposeProjectTheme() {
//                Box(modifier = Modifier
//                    .fillMaxSize()
//                    .background(MaterialTheme.colors.background)) {
//                    InstagramCard(viewModel)
//                }
//            }
        }
    }
}

@Composable
private fun test(viewModel: MainViewModel) {
    FirstComposeProjectTheme() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {

            LazyColumn() {
                item {
                    Text(text = "Title")
                }
                item{
                    Image(painter = painterResource(id = R.drawable.ic_instagramm),
                        contentDescription = null)
                }
                items(10){
                    InstagramCard(viewModel)
                }
                item{
                    Image(painter = painterResource(id = R.drawable.ic_instagramm),
                        contentDescription = null)
                }
                items(100000) {
                    InstagramCard(viewModel)
                }

            }
        }
    }
} 