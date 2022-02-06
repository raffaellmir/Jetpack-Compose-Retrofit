package com.example.retrofit_project

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.retrofit_project.ui.theme.Retrofit_projectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Retrofit_projectTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {

                    val viewModel: PhotoViewModel by viewModels()
                    val photo = viewModel.photoState.value.photo
                    val isLoading = viewModel.photoState.value.isLoading

                    photo?.let {
                        Image(
                            painter = rememberImagePainter(
                                data = photo.url,
                                builder = { crossfade(true) }
                            ),
                            contentDescription = "Dog"
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = photo.status,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        
                    }

                    Button(
                        onClick = viewModel::getRandomDog,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Next Dog!")
                    }

                    Spacer(Modifier.height(8.dp))
                    if (isLoading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Retrofit_projectTheme {
        Greeting("Android")
    }
}