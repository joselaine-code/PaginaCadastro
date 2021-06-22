package br.com.joselaine.pagecadastro

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        val tv = findViewById<TextInputLayout>(R.id.tf_data)
        val campo = findViewById<TextInputEditText>(R.id.campo_data)
        val cal = Calendar.getInstance()
        val savedYear = cal.get(Calendar.YEAR)
        val savedMonth = cal.get(Calendar.MONTH)
        val savedDay = cal.get(Calendar.DAY_OF_MONTH)
        campo.keyListener = null

        campo.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    campo.setText(
                        "$dayOfMonth/${month + 1}/$year"
                    )
                },
                savedYear,
                savedMonth,
                savedDay
            )
            datePickerDialog.show()
        }

    }

}