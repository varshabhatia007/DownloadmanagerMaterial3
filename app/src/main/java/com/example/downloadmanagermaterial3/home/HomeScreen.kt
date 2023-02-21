package com.example.downloadmanagermaterial3.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.downloadmanagermaterial3.R
import com.example.downloadmanagermaterial3.database.ImageUrl
import com.example.downloadmanagermaterial3.download.AndroidDownloader
import com.example.downloadmanagermaterial3.ui.component.VerticalSpacer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.app_name),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        val inputUrl = rememberSaveable { mutableStateOf("") }
        val context = LocalContext.current
        val downloader = AndroidDownloader(context)

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            TextFieldComponent(modifier = Modifier, inputUrl)
            VerticalSpacer(14)
            ButtonComponent(modifier = Modifier, inputUrl, downloader, homeViewModel)
            VerticalSpacer(14)
            ImageComponent(modifier = Modifier, inputUrl)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(modifier: Modifier, inputUrl: MutableState<String>) {
    TextField(
        value = inputUrl.value,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp, 20.dp, 8.dp, 20.dp),
        onValueChange = {
            inputUrl.value = it
        },
        trailingIcon = {
            when {
                inputUrl.value.isNotEmpty() -> {
                    IconButton(onClick = { inputUrl.value = "" }) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
                    }
                }
            }
        },
        placeholder = {
            Text(text = "Enter URL")
        },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            keyboardType = KeyboardType.Uri,
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun ButtonComponent(
    modifier: Modifier,
    inputUrl: MutableState<String>,
    downloader: AndroidDownloader,
    homeViewModel: HomeViewModel
) {
    Button(
        shape = RoundedCornerShape(8.dp),
        onClick = {
            if (inputUrl.value.isNotEmpty()) {
                downloader.downloadFile(inputUrl.value)
                homeViewModel.addImageUrl(ImageUrl(inputUrl.value))
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Download")
    }
}

@Composable
fun ImageComponent(modifier: Modifier, inputUrl: MutableState<String>) {
    AsyncImage(
        modifier = modifier.fillMaxSize(),
        model = ImageRequest.Builder(LocalContext.current)
            .data(inputUrl.value)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Inside
    )
}

