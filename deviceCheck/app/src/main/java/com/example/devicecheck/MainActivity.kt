package com.example.devicecheck

import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.StatFs
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deviceNameTextView: TextView = findViewById(R.id.deviceNameTextView)
        val osVersionTextView: TextView = findViewById(R.id.osVersionTextView)
        val ramTextView: TextView = findViewById(R.id.ramTextView)
        val storageTextView: TextView = findViewById(R.id.storageTextView)
        val sdCardTextView: TextView = findViewById(R.id.sdCardTextView)

        // Device Name
        val deviceName = Build.MODEL
        deviceNameTextView.text = "Device Name: $deviceName"

        // OS Version
        val osVersion = Build.VERSION.RELEASE
        osVersionTextView.text = "OS Version: $osVersion"

        // RAM
        val totalMemory = Runtime.getRuntime().totalMemory()
        ramTextView.text = "RAM: ${(totalMemory / (1024 * 1024)).toString()} MB"

        // Internal Storage
        val statFs = StatFs(Environment.getDataDirectory().path)
        val blockSize = statFs.blockSizeLong
        val availableBlocks = statFs.availableBlocksLong
        val totalSize = blockSize * availableBlocks
        storageTextView.text = "Storage: ${(totalSize / (1024 * 1024)).toString()} MB"

        // SD Card
        val sdCardAvailable = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
        sdCardTextView.text = "SD Card: ${if (sdCardAvailable) "Available" else "Not Available"}"
    }
}
