package id.my.okisulton.myintentapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.my.okisulton.myintentapp.databinding.ActivityMoveWithDataBinding

class MoveWithDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoveWithDataBinding

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        binding.tvDataReceived.text = "Nama : $name, Your age : $age"
    }
}