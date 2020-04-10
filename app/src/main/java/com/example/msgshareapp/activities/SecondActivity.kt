package com.example.msgshareapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object{
        val TAG : String=SecondActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //safe call ?.
        //safe call with ?.let{ }
        val bundle:Bundle?=intent.extras
        bundle?.let{
            val show = bundle.getString(Constants.USER_MSG_KEY)
            showMsg.text=show.toString()
            showToast(showMsg.toString(),Toast.LENGTH_LONG)
        }

    }
}
