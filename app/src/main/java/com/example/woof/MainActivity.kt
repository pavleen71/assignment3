@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.woof.ui.theme.WoofTheme
import com.example.woofapp.data.fitnessTips

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WoofTheme {
                FitnessTipsScreen()
            }
        }
    }
}

@Composable
fun FitnessTipsScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("30 Days of Wellness", style = MaterialTheme.typography.titleLarge) }


            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(fitnessTips) { tip ->
                    FitnessTipCard(tip)
                }
            }
        }
    }
}

@Composable
fun FitnessTipCard(tip: com.example.woofapp.data.tips) {
    var expanded by remember { mutableStateOf(false) }
    var isHovered by remember { mutableStateOf(false) }
    var isPressed by remember { mutableStateOf(false) }

    // Animate background color based on expanded state
    val cardColor by animateColorAsState(
        targetValue = when {
            isPressed -> Color(0xFFB39DDB) // Pressed color (darker)
            expanded -> Color(0xFFD1C4E9) // Highlighted color when expanded
            isHovered -> Color(0xFFEDE7F6) // Slightly dark when hovered
            else -> Color(0xFFF5F5DC) // Default color
        }
    )

    // Scale effect for hover
    val scale by animateFloatAsState(targetValue = if (isHovered) 1.03f else 1f)

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale)
            .animateContentSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        try {
                            awaitRelease()
                        } finally {
                            isPressed = false
                        }
                    },
                    onTap = { expanded = !expanded } // Toggle expanded state
                )
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Day ${tip.day}",
                style = MaterialTheme.typography.labelMedium,
                color = Color.Gray
            )
            Text(
                text = stringResource(id = tip.tip),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = tip.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Text(
                    text = stringResource(id = tip.explain),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show Less" else "Show More")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFitnessTipsScreen() {
    WoofTheme {
        FitnessTipsScreen()
    }
}
