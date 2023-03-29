package br.com.fundatec.fundatecheroesti21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.com.fundatec.fundatecheroesti21.presentation.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainViewModel()

        val etName = findViewById<EditText>(R.id.et_name)
        val btOk = findViewById<Button>(R.id.bt_ok)
        val btClear = findViewById<Button>(R.id.bt_clear)
        val tvHello = findViewById<TextView>(R.id.tv_hello)

        btOk.setOnClickListener {
            viewModel.validateName(etName.text)
        }

        btClear.setOnClickListener {
           viewModel.clear()
        }

        viewModel.publicName.observe(this) { name ->
            tvHello.text = getString(R.string.hello, name)
//            etName.setText(name)
        }

        viewModel.visibility.observe(this) { visibility ->
            tvHello.visibility = visibility
        }

        viewModel.showToast.observe(this) {
           Toast.makeText(this, "Preencha os campos!!!",
               Toast.LENGTH_LONG).show()
        }
    }
}