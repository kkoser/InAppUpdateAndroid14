package com.example.inappupdate14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.inappupdate14.ui.theme.InAppUpdate14Theme
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.InstallStatus

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appUpdateManager = AppUpdateManagerFactory.create(this)

        val listener = InstallStateUpdatedListener { state ->
            // (Optional) Provide a download progress bar.
            if (state.installStatus() == InstallStatus.DOWNLOADING) {
                val bytesDownloaded = state.bytesDownloaded()
                val totalBytesToDownload = state.totalBytesToDownload()
                // Show update progress bar.
            }
            // Log state or install the update.
        }

// Before starting an update, register a listener for updates.
        appUpdateManager.registerListener(listener)

        setContent {
            InAppUpdate14Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InAppUpdate14Theme {
        Greeting("Android")
    }
}
