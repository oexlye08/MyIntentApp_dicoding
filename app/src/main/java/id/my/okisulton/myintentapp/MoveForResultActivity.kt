package id.my.okisulton.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.my.okisulton.myintentapp.databinding.ActivityMoveForResultBinding

class MoveForResultActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    private lateinit var binding: ActivityMoveForResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setUpListener()
    }

    private fun setUpListener() {
        binding.btnChoose.setOnClickListener {
            if (binding.rgNumber.checkedRadioButtonId > 0) {
                var value = 0
                when (binding.rgNumber.checkedRadioButtonId) {
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }

                /*
                Intent ini digunakan untuk mengirimkan kembali ke activity induk
                Perhatikan bahwa kita mencantumkan RESULT_CODE ke dalam metode setResult
                 */
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
            Toast.makeText(this, "select first", Toast.LENGTH_SHORT).show()
        }
    }
}