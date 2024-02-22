package fr.fdj.app.presentation.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.animation.circular.CircularRevealPlugin
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.placeholder.PlaceholderPlugin
import com.skydoves.landscapist.placeholder.thumbnail.ThumbnailPlugin
import fr.fdj.app.R
import fr.fdj.app.domain.model.Team

@Composable
fun TeamItem(team: Team) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp, start = 16.dp, bottom = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            GlideImage(
                imageModel = { team.badgeUrl },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center
                ),
                component = rememberImageComponent {
                    +CircularRevealPlugin(
                        duration = 350
                    )
                    +PlaceholderPlugin.Loading(
                        painterResource(
                            id = R.drawable.badge_placeholder
                        )
                    )
                    +ThumbnailPlugin(IntSize(30 ,30))
                },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = team.name,
                textAlign = TextAlign.Center,
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun TeamItemPreview() {
    TeamItem(
        team = Team(
            id = "1",
            name = "Team 1",
            sport = "Sport 1",
            league = "League 1",
            nameAlt = "Team 1",
            badgeUrl = "",
        )
    )
}
