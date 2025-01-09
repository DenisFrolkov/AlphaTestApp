package com.alpha.feature_history.presentation.screen

import android.content.ActivityNotFoundException
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alpha.feature_history.presentation.utils.UiState
import com.alpha.feature_history.presentation.viewmodel.HistoryViewModel

@Composable
fun HistoryScreen(
    navController: NavController,
    historyViewModel: HistoryViewModel
) {
    val context = LocalContext.current
    val listBinInfo = historyViewModel.binHistoryInfo.collectAsState().value
    var expandedItems = remember { mutableStateMapOf<String, Boolean>() }

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize(Alignment.CenterStart)
                ) {
                    Image(
                        imageVector = Icons.Default.ArrowBack,
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary),
                        contentDescription = "Назад"
                    )
                }
                Text(
                    text = "История запросов",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth(.75f)
                        .wrapContentSize(Alignment.Center)
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.surface,
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (listBinInfo) {
                is UiState.Error -> {
                    item {
                        Text(
                            listBinInfo.message,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }

                UiState.Loading -> {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.TopCenter),
                            color = MaterialTheme.colorScheme.primary,
                            strokeWidth = 2.dp
                        )
                    }
                }

                is UiState.Success -> {
                    if (listBinInfo.data.isNotEmpty()) {
                        items(listBinInfo.data) { bin ->

                            val isExpanded = expandedItems[bin.bin] ?: false
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.secondaryContainer,
                                        shape = if (isExpanded) MaterialTheme.shapes.extraLarge.copy(
                                            bottomEnd = CornerSize(0.dp),
                                            bottomStart = CornerSize(0.dp)
                                        ) else MaterialTheme.shapes.extraLarge
                                    )
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null
                                    ) {
                                        expandedItems[bin.bin!!] = !isExpanded
                                    }
                            ) {
                                Text(
                                    text = bin.bin.toString(),
                                    fontSize = 36.sp,
                                    color = MaterialTheme.colorScheme.tertiary,
                                    modifier = Modifier
                                        .fillMaxWidth(.75f)
                                        .wrapContentSize(Alignment.Center)
                                )
                                IconButton(
                                    onClick = {
                                        expandedItems[bin.bin!!] = !isExpanded
                                    },
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .wrapContentSize(Alignment.CenterStart)
                                ) {
                                    Image(
                                        imageVector = if (isExpanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.tertiary),
                                        contentDescription = "Отображение"
                                    )
                                }
                            }

                            if (isExpanded) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp)
                                        .background(
                                            color = MaterialTheme.colorScheme.secondaryContainer,
                                            shape = MaterialTheme.shapes.small.copy(
                                                topStart = CornerSize(0.dp),
                                                topEnd = CornerSize(0.dp)
                                            )
                                        )
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceAround,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column() {
                                            if (bin.scheme.isNotBlank()) {
                                                Column {
                                                    Text(
                                                        text = "SCHEME / NETWORK",
                                                        color = MaterialTheme.colorScheme.secondary,
                                                        fontSize = 10.sp
                                                    )
                                                    Text(
                                                        text = bin.scheme,
                                                        color = MaterialTheme.colorScheme.primary,
                                                        fontSize = 14.sp
                                                    )
                                                }
                                                Spacer(modifier = Modifier.height(4.dp))
                                            }
                                            if (bin.brand.isNotBlank()) {
                                                Column {
                                                    Text(
                                                        text = "BRAND",
                                                        color = MaterialTheme.colorScheme.secondary,
                                                        fontSize = 10.sp
                                                    )
                                                    Text(
                                                        text = bin.brand,
                                                        color = MaterialTheme.colorScheme.primary,
                                                        fontSize = 14.sp
                                                    )
                                                }
                                                Spacer(modifier = Modifier.height(4.dp))
                                            }
                                            if (bin.number?.length != null && bin.number != null) {
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
                                                                text = bin.number!!.length.toString(),
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
                                                            bin.number?.luhn?.let {
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
                                            if (bin.type.isNotBlank()) {
                                                Column {
                                                    Text(
                                                        text = "TYPE",
                                                        color = MaterialTheme.colorScheme.secondary,
                                                        fontSize = 10.sp
                                                    )
                                                    Text(
                                                        text = bin.type,
                                                        color = MaterialTheme.colorScheme.primary,
                                                        fontSize = 14.sp
                                                    )
                                                }
                                                Spacer(modifier = Modifier.height(4.dp))
                                            }
                                            if (bin.prepaid != null) {
                                                Column {
                                                    Text(
                                                        text = "PREPAID",
                                                        color = MaterialTheme.colorScheme.secondary,
                                                        fontSize = 10.sp
                                                    )
                                                    bin.prepaid?.let {
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
                                            if (bin.country != null) {
                                                Spacer(modifier = Modifier.height(4.dp))
                                                Column(
                                                    modifier = Modifier.clickable(
                                                        interactionSource = remember { MutableInteractionSource() },
                                                        indication = null
                                                    ) {
                                                        if (bin.country?.latitude != null && bin.country?.longitude != null) {
                                                            val fallbackIntent = Intent(
                                                                Intent.ACTION_VIEW,
                                                                Uri.parse(
                                                                    "geo:${bin.country?.latitude},${bin.country?.longitude}?q=${bin.country?.latitude},${bin.country?.longitude}(${
                                                                        Uri.encode(bin.country?.name)
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
                                                    bin.country?.name?.let {
                                                        Text(
                                                            text = it,
                                                            color = MaterialTheme.colorScheme.primary,
                                                            fontSize = 14.sp
                                                        )
                                                    }
                                                    if (bin.country?.latitude != null && bin.country?.longitude != null) {
                                                        Row() {
                                                            Row {
                                                                Text(
                                                                    text = "latitude: ",
                                                                    color = MaterialTheme.colorScheme.secondary,
                                                                    fontSize = 8.sp
                                                                )
                                                                Text(
                                                                    text = bin.country?.latitude.toString(),
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
                                                                    text = bin.country?.longitude.toString(),
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
                                    if (bin.bank != null) {
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
                                            bin.bank!!.name?.let {
                                                Text(
                                                    text = it,
                                                    color = MaterialTheme.colorScheme.primary,
                                                    fontSize = 14.sp
                                                )
                                            }
                                            bin.bank!!.url?.let {
                                                Text(
                                                    text = it,
                                                    color = MaterialTheme.colorScheme.primary,
                                                    fontSize = 12.sp,
                                                    modifier = Modifier.clickable(
                                                        interactionSource = remember { MutableInteractionSource() },
                                                        indication = null
                                                    ) {
                                                        val intent = Intent(
                                                            Intent.ACTION_VIEW,
                                                            Uri.parse("http://${it}")
                                                        )
                                                        context.startActivity(intent)
                                                    }
                                                )
                                            }
                                            bin.bank!!.phone?.let {
                                                Text(
                                                    text = it,
                                                    color = MaterialTheme.colorScheme.primary,
                                                    fontSize = 12.sp,
                                                    modifier = Modifier.clickable(
                                                        interactionSource = remember { MutableInteractionSource() },
                                                        indication = null
                                                    ) {
                                                        val intent = Intent(
                                                            Intent.ACTION_DIAL,
                                                            Uri.parse("tel:$it")
                                                        )
                                                        context.startActivity(intent)
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }
        }
    }
}