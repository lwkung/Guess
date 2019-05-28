package com.test.guess

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {

    private val secretNumber = SecretNumber()
    private val TAG: String = MaterialActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(toolbar)

        Log.e(TAG, "secret: ${secretNumber.secret}")

        fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("Replay game")
                .setMessage("Are you sure?")
                .setPositiveButton(getString(R.string.ok), { dialog, which ->
                    secretNumber.reset()
                    counter.setText(secretNumber.count.toString())
                    number.setText("")
                    Log.e(TAG, "secret: ${secretNumber.secret}")
                })
                .setNeutralButton("Cancel", null)
                .show()
        }

        counter.setText(secretNumber.count.toString())
    }

    fun check(view: View) {
        val n = number.text.toString().toInt()
        println("number: $n")
        Log.d(TAG, "number: $n")

        val diff = secretNumber.validate(n)
        /*var message = getString(R.string.yes_you_got_it)
        if (secretNumber.count < 3) {
            message = getString(R.string.excellent, secretNumber.secret)
        }
        if (diff < 0) {
            message = getString(R.string.bigger)
        } else if (diff > 0) {
            message = getString(R.string.smaller)
        }*/
        val message = when {
            diff < 0 -> getString(R.string.bigger)
            diff > 0 -> getString(R.string.smaller)
            diff == 0 && secretNumber.count < 3 -> getString(R.string.excellent, secretNumber.secret)
            else -> getString(R.string.yes_you_got_it)
        }

        counter.setText(secretNumber.count.toString())
        //Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok), null)
            .show()
    }

}
