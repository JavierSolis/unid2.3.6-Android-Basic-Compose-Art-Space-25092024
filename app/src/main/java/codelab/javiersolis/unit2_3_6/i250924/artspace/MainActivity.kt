package codelab.javiersolis.unit2_3_6.i250924.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import codelab.javiersolis.unit2_3_6.i250924.artspace.ui.theme.CodeLabArtSpaceTheme
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.bumptech.glide.load.engine.DiskCacheStrategy

data class ImageData(
    val uriImg: String,
    val uriDescription: String,
    val title: String,
    val author: String,
    val dateCreated: String
)

// Ejemplo de lista con datos
val imageDataList = listOf(
    ImageData(
        uriImg = "https://random.imagecdn.app/500/700",
        uriDescription = "random description",
        title = "Titulo 1",
        author = "Author 1",
        dateCreated = "1900"
    ),
    ImageData(
        uriImg = "https://random.imagecdn.app/800/851",
        uriDescription = "random description 2",
        title = "Titulo 2",
        author = "Author 2",
        dateCreated = "1950"
    ),
    ImageData(
        uriImg = "https://random.imagecdn.app/800/852",
        uriDescription = "random description 3",
        title = "Titulo 3",
        author = "Author 3",
        dateCreated = "2000"
    )
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) { innerPadding ->
                    SpaceArtApp(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

        }
    }
}

@Composable
fun SpaceArtApp(name: String, modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var imageData by remember { mutableStateOf(imageDataList[currentIndex]) }

    Column (modifier = modifier){
        //image
        SpaceImage(
            modifier = Modifier.weight(1f),
            uriImg = imageData.uriImg,
            uriDescription = imageData.uriDescription
        )
        //title
        SpaceTitle(
            modifier = Modifier,
            title = imageData.title,
            author = imageData.author,
            dateCreated = imageData.dateCreated
        )
        //buttons
        SpaceButtons(
            modifier = Modifier,
            onPreviewClick = {
                currentIndex--
                if(currentIndex<0){
                    currentIndex=imageDataList.size-1
                }
                imageData = imageDataList[currentIndex]
            },
            onNextClick = {
                currentIndex++
                if(currentIndex>=imageDataList.size){
                    currentIndex=0
                }
                imageData = imageDataList[currentIndex]
            }
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SpaceImage(
    modifier: Modifier,
    uriImg : String,
    uriDescription: String
) {
    Surface (modifier = modifier
        .fillMaxWidth()
    ) {

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp // Controla la elevación (sombra)
            ),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                , // Simula un margen exterior
        ) {
            GlideImage(
                model = "uriImg,
                contentDescription = uriDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                loading = placeholder(resourceId = R.drawable.palceholder),

            ){
                it.diskCacheStrategy(DiskCacheStrategy.NONE)
            }
            /*
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.example),
                contentDescription = "Foto principal"
            )
            */
        }
    }
}

@Composable
fun SpaceTitle(
    modifier: Modifier,
    title:String,
    author:String,
    dateCreated:String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .background(colorResource(id = R.color.title_background))
    ) {
        Column (modifier = Modifier.padding(15.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Row {
                Text(
                    text = "by $author",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "($dateCreated)",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

    }
}

@Composable
fun SpaceButtons(
    modifier: Modifier,
    onPreviewClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(modifier=modifier) {
        Button(
            modifier = Modifier.padding(15.dp),
            onClick = { onPreviewClick() }) {
            Text(text = stringResource(id =R.string.btn_preview ))
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .weight(1f))
        Button(
            modifier = Modifier.padding(15.dp),
            onClick = { onNextClick() }) {
            Text(text = stringResource(id =R.string.btn_next ))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpaceArtAppPreview() {
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) { innerPadding ->
        SpaceArtApp(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}