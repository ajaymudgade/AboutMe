package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Ajay")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        findViewById<Button>(R.id.doneButton).setOnClickListener { addNickName(it) }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener { addNickName(it) }

    }

    private fun addNickName(view: View) {
//        Method 1

//        val editText = findViewById<EditText>(R.id.nick_name_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_textview)
//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

//        Method 2

//        binding.nicknameTextview.text = binding.nickNameEdit.text
//        binding.nickNameEdit.visibility = View.GONE
//        binding.doneButton.visibility = View.GONE
//        binding.nicknameTextview.visibility = View.VISIBLE

//        Method 3

        binding.apply {
//            nicknameTextview.text = nickNameEdit.text
            myName?.nickname = nickNameEdit.text.toString()
            invalidateAll()
            nickNameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameTextview.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}