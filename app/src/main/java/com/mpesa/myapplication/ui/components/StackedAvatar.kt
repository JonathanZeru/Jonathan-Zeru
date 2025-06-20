import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage

@Composable
fun StackedAvatars(imageUrls: List<String>) {
    Row (
        modifier = Modifier.height(48.dp)
    ) {
        imageUrls.take(5).forEachIndexed { index, imageUrl ->
            Box(
                modifier = Modifier
                    .zIndex((imageUrls.size - index).toFloat())
                    .offset(x = (-index * 12).dp)
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Bank Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )
            }
        }
    }
}
