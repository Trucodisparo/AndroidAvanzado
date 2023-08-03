package com.keepcoding.androidsuperpoderes.presentation.heroList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.TestDataBuilder
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.keepcoding.androidsuperpoderes.components.StarComponent

@Composable
fun ShowHero(
    hero: HeroModel,
    index: Int,
    onClick: (() -> Unit)? = null
){

    var starred by remember{
        mutableStateOf(false)
    }
/*
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(if(index % 2 != 0) Color(240,240,240) else Color.White)
        .clickable { onClick?.invoke() },
    ) {*/
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp, 1.dp)
            .clickable { onClick?.invoke() },
            elevation = 2.dp,
            shape = RoundedCornerShape(2.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(if(index % 2 != 0) Color(245,215,66) else Color(247,232,158))
                .clickable { onClick?.invoke() },
            ) {
            Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .size(75.dp)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(hero.photoUrl)
                            .crossfade(true)
                            .build(),
                        "HeroPic",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clip(CircleShape).fillMaxSize(),
                        placeholder = painterResource(id = com.google.android.material.R.drawable.ic_clock_black_24dp),
                        error = painterResource(id = com.google.android.material.R.drawable.ic_mtrl_checked_circle)
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .height(100.dp)
                        .padding(paddingValues = PaddingValues(horizontal = 8.dp, vertical = 8.dp))
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(hero.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AndroidView(
                                modifier = Modifier.clickable {
                                    starred = !starred
                                }.size(24.dp),
                                factory = { context ->
                                    StarComponent(context).apply {
                                        checked = starred
                                    }
                                },
                                update = {
                                    it.checked = starred
                                }
                            )
                        }
                    }
                    Text(
                        hero.description,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(PaddingValues(0.dp, 0.dp, 20.dp, 0.dp,))
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ShowHeroPreview(){
    ShowHero(TestDataBuilder()
        .withName("HeroTest")
        .withPhotoUrl("http://i.annihil.us/u/prod/marvel/i/mg/b/c0/553a9abceb412/portrait_incredible.jpg")
        .withDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut augue sollicitudin, gravida felis a, maximus dolor. In suscipit ante ex, non tristique nunc accumsan nec. Fusce vitae aliquam lorem. Ut mattis iaculis luctus. Morbi in molestie metus, non ultrices leo. Nullam luctus tortor eget ligula auctor dignissim. Ut in maximus est. In hac habitasse platea dictumst. Proin sed nunc eget lacus volutpat molestie. Pellentesque nec lobortis ex. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec metus enim, volutpat eget varius ac, molestie non libero. Nullam dictum porta semper. Etiam dignissim porta viverra. Maecenas congue gravida felis, sed malesuada tortor venenatis sit amet. Morbi at iaculis mauris.")
        .buildSingle(), 0, {}
    )
}