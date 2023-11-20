package com.example.j2_ressource1

import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Obtenez des références aux vues
        val modeText: TextView = findViewById(R.id.modeText)
        val buttonGroup1: LinearLayout = findViewById(R.id.buttonGroup1)
        val buttonGroup2: LinearLayout = findViewById(R.id.buttonGroup2)
        val greetingText: TextView = findViewById(R.id.greetingText)
        val imageView: ImageView = findViewById(R.id.imageView)

        // Détecter le changement de mode
        updateMode(resources.configuration)

        // Détecter le changement de configuration
        resources.configuration.orientation


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Mettre à jour l'interface utilisateur en cas de changement de configuration
        updateMode(newConfig)
    }

    private fun updateMode(config: Configuration) {
        // Mettre à jour le texte du mode
        val modeText: TextView = findViewById(R.id.modeText)
        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            modeText.text = "Portrait Mode"
        } else {
            modeText.text = "Landscape Mode"
        }

        // Mettre à jour la couleur des boutons en fonction du mode
        val buttonGroup1: LinearLayout = findViewById(R.id.buttonGroup1)
        val buttonGroup2: LinearLayout = findViewById(R.id.buttonGroup2)
        var group1Color: Int
        var group2Color: Int

        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            group1Color = Color.BLUE
            group2Color = Color.RED


        } else {
            group2Color = Color.BLUE
            group1Color = Color.RED
        }
        buttonGroup1.setBackgroundColor(group1Color)
        buttonGroup2.setBackgroundColor(group2Color)

        // Mettre à jour le texte de salutation en fonction de la langue actuelle
        val greetingText: TextView = findViewById(R.id.greetingText)
        val greeting = if (config.locale.language == "fr") {
            "Bonjour tout le monde"
        } else {
            "Hello World!"
        }
        greetingText.text = greeting

        // Mettre à jour l'image en fonction de la taille de l'écran
        val imageView: ImageView = findViewById(R.id.imageView)
        when (config.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) {
            Configuration.SCREENLAYOUT_SIZE_SMALL -> imageView.setImageResource(R.drawable.mouse)
            Configuration.SCREENLAYOUT_SIZE_NORMAL -> imageView.setImageResource(R.drawable.dog)
            Configuration.SCREENLAYOUT_SIZE_LARGE -> imageView.setImageResource(R.drawable.fil)
        }
    }
}
