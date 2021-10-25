package id.my.okisulton.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.my.okisulton.myintentapp.databinding.ActivityMoveWithDataBinding
import id.my.okisulton.myintentapp.databinding.ActivityMoveWithObjectBinding

class MoveWithObjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoveWithObjectBinding

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name : ${person.name.toString()}, \nEmail : ${person.email.toString()}, \nAge: ${person.age.toString()}, \nLocation : ${person.city.toString()}"

        binding.tvObjectReceived.text = text

    }
}