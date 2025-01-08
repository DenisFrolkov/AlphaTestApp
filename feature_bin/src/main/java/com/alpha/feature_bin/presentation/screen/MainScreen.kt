package com.alpha.feature_bin.presentation.screen

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alpha.feature_bin.R
import com.alpha.feature_bin.presentation.utils.UiState
import com.alpha.feature_bin.presentation.viewmodel.MainViewModel

@SuppressLint("WrongConstant")
@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel
) {

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val bin = mainViewModel.binInfo.collectAsState().value
    var textValue by remember { mutableStateOf("") }
    var clickSearch by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        contentColor = MaterialTheme.colorScheme.surface,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("history_screen")
                },
                shape = MaterialTheme.shapes.extraLarge,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    painter = painterResource(R.drawable.history_icon),
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(30.dp),
                    contentDescription = "Поиск"
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.surface,
        content = { paddingValue ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValue)
                    .wrapContentSize(Alignment.Center)
            ) {
                TextField(
                    value = textValue,
                    onValueChange = { textValue = it },
                    label = { Text(text = "Введите BIN") },
                    shape = MaterialTheme.shapes.small,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                clickSearch = true
                                keyboardController?.hide()
                                mainViewModel.fetchBinInfo(textValue)
                            }) {
                            Image(
                                imageVector = Icons.Default.Search,
                                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary),
                                contentDescription = "Поиск"
                            )
                        }
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        clickSearch = true
                        keyboardController?.hide()
                        mainViewModel.fetchBinInfo(textValue)
                    }),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                        unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                )
                if (clickSearch) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                shape = MaterialTheme.shapes.small.copy(
                                    topStart = CornerSize(0.dp),
                                    topEnd = CornerSize(0.dp)
                                )
                            )
                            .padding(8.dp)
                    ) {
                        when (bin) {
                            is UiState.Error -> {
                                Text(
                                    bin.message,
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }

                            UiState.Loading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentSize(Alignment.Center),
                                    color = MaterialTheme.colorScheme.primary,
                                    strokeWidth = 2.dp
                                )
                            }

                            is UiState.Success -> {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceAround,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column() {
                                        if (bin.data.scheme.isNotBlank()) {
                                            Column {
                                                Text(
                                                    text = "SCHEME / NETWORK",
                                                    color = MaterialTheme.colorScheme.secondary,
                                                    fontSize = 10.sp
                                                )
                                                Text(
                                                    text = bin.data.scheme,
                                                    color = MaterialTheme.colorScheme.primary,
                                                    fontSize = 14.sp
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                        }
                                        if (bin.data.brand.isNotBlank()) {
                                            Column {
                                                Text(
                                                    text = "BRAND",
                                                    color = MaterialTheme.colorScheme.secondary,
                                                    fontSize = 10.sp
                                                )
                                                Text(
                                                    text = bin.data.brand,
                                                    color = MaterialTheme.colorScheme.primary,
                                                    fontSize = 14.sp
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                        }
                                        if (bin.data.number?.length != null && bin.data.number != null) {
                                            Column {
                                                Text(
                                                    text = "CARD NUMBER",
                                                    color = MaterialTheme.colorScheme.secondary,
                                                    fontSize = 10.sp
                                                )
                                                Row() {
                                                    Column {
                                                        Text(
                                                            text = "LENGTH",
                                                            color = MaterialTheme.colorScheme.secondary,
                                                            fontSize = 8.sp
                                                        )
                                                        Text(
                                                            text = bin.data.number!!.length.toString(),
                                                            color = MaterialTheme.colorScheme.primary,
                                                            fontSize = 12.sp
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.width(8.dp))
                                                    Column {
                                                        Text(
                                                            text = "LUNC",
                                                            color = MaterialTheme.colorScheme.secondary,
                                                            fontSize = 8.sp
                                                        )
                                                        bin.data.number?.luhn?.let {
                                                            Checkbox(
                                                                checked = it,
                                                                onCheckedChange = null,
                                                                colors = CheckboxDefaults.colors(
                                                                    checkmarkColor = MaterialTheme.colorScheme.primary,
                                                                    uncheckedColor = MaterialTheme.colorScheme.surface
                                                                ),
                                                                interactionSource = remember { MutableInteractionSource() },
                                                                enabled = false
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    Column() {
                                        if (bin.data.type.isNotBlank()) {
                                            Column {
                                                Text(
                                                    text = "TYPE",
                                                    color = MaterialTheme.colorScheme.secondary,
                                                    fontSize = 10.sp
                                                )
                                                Text(
                                                    text = bin.data.type,
                                                    color = MaterialTheme.colorScheme.primary,
                                                    fontSize = 14.sp
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                        }
                                        if (bin.data.prepaid != null) {
                                            Column {
                                                Text(
                                                    text = "PREPAID",
                                                    color = MaterialTheme.colorScheme.secondary,
                                                    fontSize = 10.sp
                                                )
                                                bin.data.prepaid?.let {
                                                    Checkbox(
                                                        checked = it,
                                                        onCheckedChange = null,
                                                        colors = CheckboxDefaults.colors(
                                                            checkmarkColor = MaterialTheme.colorScheme.primary,
                                                            uncheckedColor = MaterialTheme.colorScheme.surface
                                                        ),
                                                        interactionSource = remember { MutableInteractionSource() },
                                                        enabled = false
                                                    )
                                                }
                                            }
                                        }
                                        if (bin.data.country != null) {
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Column(
                                                modifier = Modifier.clickable(
                                                    interactionSource = remember { MutableInteractionSource() },
                                                    indication = null
                                                ) {
                                                    if (bin.data.country?.latitude != null && bin.data.country?.longitude != null) {
                                                        val fallbackIntent = Intent(
                                                            Intent.ACTION_VIEW,
                                                            Uri.parse(
                                                                "geo:${bin.data.country?.latitude},${bin.data.country?.longitude}?q=${bin.data.country?.latitude},${bin.data.country?.longitude}(${
                                                                    Uri.encode(bin.data.country?.name)
                                                                })"
                                                            )
                                                        )
                                                        context.startActivity(fallbackIntent)
                                                    }
                                                }) {
                                                Text(
                                                    text = "COUNTRY",
                                                    color = MaterialTheme.colorScheme.secondary,
                                                    fontSize = 10.sp
                                                )
                                                bin.data.country?.name?.let {
                                                    Text(
                                                        text = it,
                                                        color = MaterialTheme.colorScheme.primary,
                                                        fontSize = 14.sp
                                                    )
                                                }
                                                if (bin.data.country?.latitude != null && bin.data.country?.longitude != null) {
                                                    Row() {
                                                        Row {
                                                            Text(
                                                                text = "latitude: ",
                                                                color = MaterialTheme.colorScheme.secondary,
                                                                fontSize = 8.sp
                                                            )
                                                            Text(
                                                                text = bin.data.country?.latitude.toString(),
                                                                color = MaterialTheme.colorScheme.primary,
                                                                fontSize = 10.sp
                                                            )
                                                        }
                                                        Spacer(modifier = Modifier.width(10.dp))
                                                        Row {
                                                            Text(
                                                                text = "longitude: ",
                                                                color = MaterialTheme.colorScheme.secondary,
                                                                fontSize = 8.sp
                                                            )
                                                            Text(
                                                                text = bin.data.country?.longitude.toString(),
                                                                color = MaterialTheme.colorScheme.primary,
                                                                fontSize = 10.sp
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (bin.data.bank != null) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .wrapContentSize(Alignment.Center)
                                    ) {
                                        Text(
                                            text = "BANK",
                                            color = MaterialTheme.colorScheme.secondary,
                                            fontSize = 10.sp
                                        )
                                        bin.data.bank!!.name?.let {
                                            Text(
                                                text = it,
                                                color = MaterialTheme.colorScheme.primary,
                                                fontSize = 14.sp
                                            )
                                        }
                                        bin.data.bank!!.url?.let {
                                            Text(
                                                text = it,
                                                color = MaterialTheme.colorScheme.primary,
                                                fontSize = 12.sp
                                            )
                                        }
                                        bin.data.bank!!.phone?.let {
                                            Text(
                                                text = it,
                                                color = MaterialTheme.colorScheme.primary,
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
