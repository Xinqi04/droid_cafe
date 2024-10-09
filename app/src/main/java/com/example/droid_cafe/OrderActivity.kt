package com.example.droid_cafe

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    private lateinit var citySpinner: Spinner
    private lateinit var noteText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Inisialisasi Spinner dan EditText
        citySpinner = findViewById(R.id.city_spinner)
        noteText = findViewById(R.id.note_text)
    }

    // Method untuk menangani RadioButton yang dipilih
    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.id) {
            R.id.sameday -> if (checked) displayToast(getString(R.string.same_day_messenger_service))
            R.id.nextday -> if (checked) displayToast(getString(R.string.next_day_ground_delivery))
            R.id.pickup -> if (checked) displayToast(getString(R.string.pick_up))
        }
    }

    // Method untuk menampilkan Toast
    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    // Method untuk menangani tombol Submit atau proses lainnya
    fun onSubmitOrder(view: View) {
        // Ambil nilai dari Spinner (City)
        val selectedCity = citySpinner.selectedItem.toString()

        // Ambil nilai dari EditText (Note)
        val note = noteText.text.toString()

        // Tampilkan kota yang dipilih dan catatan tambahan dengan Toast
        val orderSummary = "City: $selectedCity\nNote: $note"
        displayToast(orderSummary)

        // Lakukan hal lain dengan data ini, misalnya menyimpannya atau mengirimkan ke server
    }
}
