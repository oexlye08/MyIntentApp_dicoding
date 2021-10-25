package id.my.okisulton.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import id.my.okisulton.myintentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            binding.tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMoveActivity.setOnClickListener(this)
        binding.btnMoveActivityData.setOnClickListener(this)
        binding.btnMoveActivityObject.setOnClickListener(this)
        binding.btnDialNumber.setOnClickListener(this)
        binding.btnMoveForResult.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_move_activity -> {
                startActivity(Intent(this, MoveActivity::class.java))
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Oki Sulton")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 24)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_activity_object -> {
                val person = Person(
                    name = "Oki Sulton",
                    age = 24,
                    email = "okisulton@mail.com",
                    city = "Temanggung"
                )

                val moveWithObject = Intent(this, MoveWithObjectActivity::class.java)
                moveWithObject.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObject)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "081234567890"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}