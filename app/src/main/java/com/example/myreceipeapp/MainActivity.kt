package com.example.myreceipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myreceipeapp.ui.theme.MyReceipeAppTheme
import com.example.myreceipeapp.ui.theme.ReceipeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyReceipeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   ReceipeScreen(modifier = Modifier.fillMaxSize().padding(innerPadding).padding(14.dp))
                }
            }
        }
    }
}

