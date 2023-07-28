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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.keepcoding.androidsuperpoderes.R
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.TestDataBuilder

@Composable
fun ShowHero(
    hero: HeroModel,
    onClick: (() -> Unit)? = null
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onClick?.invoke() },

    ) {
        Box(modifier = Modifier
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
        Column(horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth().height(100.dp).padding(paddingValues = PaddingValues(horizontal = 8.dp))){
            Text(hero.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(hero.description, maxLines = 4, overflow = TextOverflow.Ellipsis, fontSize = 12.sp, lineHeight = 12.sp)
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
        .buildSingle(), {}
    )
}