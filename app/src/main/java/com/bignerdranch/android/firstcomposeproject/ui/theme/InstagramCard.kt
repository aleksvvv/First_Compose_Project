package com.bignerdranch.android.firstcomposeproject.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.firstcomposeproject.MainViewModel
import com.bignerdranch.android.firstcomposeproject.R


@Composable
fun InstagramCard(
    viewModel: MainViewModel
) {
    val isFollowed =
        viewModel.isFollowing.observeAsState(false)

    Card(
        modifier = Modifier.padding(8.dp),
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id =
                        R.drawable.ic_instagramm
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(70.dp)
                        .background(Color.White)
                        .padding(9.dp)
                        .size(50.dp)
                )
                TwoText(title = "Posts", count = "6.950")
                TwoText(title = "Followers", count = "436M")
                TwoText(title = "Following", count = "76")
            }
            Text(
                text = "Instagram",
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive
            )
            Text(
                text = "#YoursToMake",
            )
            Text(
                text = "www.facebook.com/lll",
            )
            FollowButton(isFollowed = isFollowed.value) {
                viewModel.ChangeFollow()
            }
        }
    }
}

@Composable
private fun FollowButton(
    isFollowed: Boolean,
    clickListener: () -> Unit
) {
    Button(
        onClick = {
            clickListener()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if(isFollowed) {
                MaterialTheme.colors.primary.copy(alpha = 0.3f)
            } else {
                MaterialTheme.colors.primary
            }
        )
    )
     {
        val text = if (isFollowed) {
            "Unfollow"
        } else {
            "Follow"
        }
        Text(text = text)

    }
}

@Composable
private fun TwoText(title: String, count: String) {
    Column(
        modifier = Modifier
            .height(70.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}