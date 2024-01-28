package com.example.fournisseurcontenu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.fournisseurcontenu.models.Contact
import android.provider.ContactsContract
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fournisseurcontenu.adapters.ContactAdapter


class MainActivity : AppCompatActivity() {
    lateinit var getBtn: Button
    lateinit var emailBtn: Button
    lateinit var permBtn: Button
    lateinit var emailET: EditText
    lateinit var recyclerView: RecyclerView
    val contactsList = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emailBtn = findViewById(R.id.emailBtn)

        getBtn = findViewById(R.id.fetchContactsBtn)
        permBtn = findViewById(R.id.reqPermBtn)
        emailET = findViewById(R.id.emailEt)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        emailBtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailET.text))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Devoir TDM")
            intent.putExtra(Intent.EXTRA_TEXT, "Azul Felawn")

            startActivity(Intent.createChooser(intent, "Choisir une application pour envoyer l'email"))
        }
        permBtn.setOnClickListener {
            // Permission is not granted, request it
            PermissionUtils.requestReadContactsPermission(this)
        }
        if (PermissionUtils.isReadContactsPermissionGranted(this)) {
            // Permission is granted, proceed with fetching contacts
            getBtn.setOnClickListener {
                getContacts()

            }
        } else {
            // Permission is not granted, request it
            PermissionUtils.requestReadContactsPermission(this)
        }


    }

    private fun getContacts() {
        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )

        cursor?.use {
            while (it.moveToNext() ) {
                val id = it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID))
                val name =
                    it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val phoneNumber =
                    it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                val contact = Contact(id, name, phoneNumber)
                contactsList.add(contact)
            }

        }
        val adapter = ContactAdapter(contactsList)
        recyclerView.adapter = adapter
    }
}