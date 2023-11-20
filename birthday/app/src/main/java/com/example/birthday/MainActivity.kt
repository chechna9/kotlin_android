package com.example.birthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvAge: TextView = findViewById(R.id.tvAge)
        val tvDaysLeft: TextView = findViewById(R.id.tvDaysLeft)

        val myBirthDate = "2001-08-21"
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = Date()

        // Calcul de l'âge
        val birthDateTime = dateFormat.parse(myBirthDate)
        val ageInMillis = currentDate.time - birthDateTime.time
        val ageInYears = ageInMillis / (365.25 * 24 * 60 * 60 * 1000).toDouble()
        // Affichage de l'âge
        tvAge.text = "Âge : ${ageInYears.toInt()} ans"

        // Calcul des jours restants avant l'anniversaire suivant
        val nextBirthday = getNextBirthday(birthDateTime, currentDate)
        val daysLeft = calculateDaysUntil(nextBirthday)

        // Affichage des jours restants
        tvDaysLeft.text = "Jours restants avant l'anniversaire : $daysLeft jours"
    }

    private fun getNextBirthday(birthDate: Date, currentDate: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = birthDate

        // Définir l'année de l'anniversaire sur l'année actuelle
        calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR))

        // Si l'anniversaire est déjà passé cette année, ajouter une année
        if (calendar.time.before(currentDate)) {
            calendar.add(Calendar.YEAR, 1)
        }

        return calendar.time
    }

    private fun calculateDaysUntil(targetDate: Date): Long {
        val currentDate = Calendar.getInstance().time
        val difference = targetDate.time - currentDate.time
        return difference / (24 * 60 * 60 * 1000)
    }


}
