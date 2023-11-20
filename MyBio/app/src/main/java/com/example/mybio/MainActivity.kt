package com.example.mybio

import android.media.audiofx.DynamicsProcessing.Config
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.content.res.Configuration


class MainActivity : AppCompatActivity() {
    private val mujahidin = arrayOf(
        Moujahed(
            "مصطفى بن بولعيد",
            "Mustafa Ben Boulaid",
            R.drawable.benboulaid,
            R.string.benbolaid_bio_fr,
            R.string.benbolaid_bio_ar
        ),
        Moujahed(
            "العقيد عميروش",
            "Amirouche",
            R.drawable.amirouche,
            R.string.amirouche_bio_fr,
            R.string.amirouche_bio_ar,
        ),
        Moujahed(
            "العربي بن مهيدي",
            "Larbi Ben Mhidi",
            R.drawable.benmhidi,
            R.string.benmhidi_bio_fr,
            R.string.benmhidi_bio_ar,
        ),
    )
    private lateinit var name: TextView
    private lateinit var img: ImageView
    private lateinit var bio: TextView
    private lateinit var btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        referencing the view elements
        name = findViewById(R.id.tvName)
        img = findViewById(R.id.img)
        bio = findViewById(R.id.tvBio)
        btn = findViewById(R.id.btnRand)
        val systemLanguage = resources.configuration.locales[0].language
        random(isLatin(systemLanguage))
        btn.setOnClickListener { random(isLatin(systemLanguage)) }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val systemLanguage = resources.configuration.locales[0].language
        random(isLatin(systemLanguage))
        btn.setOnClickListener { random(isLatin(systemLanguage)) }
    }
    private fun isLatin(language: String): Boolean {
        return !language.equals("ar", ignoreCase = true)
    }

    fun random(showLatin: Boolean = true) {
        bindData(mujahidin.random(), showLatin)
    }

    fun bindData(moujahed: Moujahed, showLatin: Boolean = true) {
        img.setImageResource(moujahed.imgUrl)
        when (showLatin) {
            true -> {
                name.setText(moujahed.frName)
                bio.setText(getString(moujahed.frBio))
            }

            false -> {
                name.setText(moujahed.arName)
                bio.setText(getString(moujahed.arBio))
            }
        }
    }
}