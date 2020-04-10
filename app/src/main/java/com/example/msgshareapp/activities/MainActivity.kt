package com.example.msgshareapp.activities


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG : String=MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        shareToActivity.setOnClickListener {
            Log.i(TAG,"MainActivity is called !")
            val msg: String = message.text.toString()
            val intent = Intent(this, SecondActivity::class.java)                      //explicit intent
            intent.putExtra(Constants.USER_MSG_KEY,msg)
            startActivity(intent)

        }
        shareToApp.setOnClickListener{
            val msg: String = message.text.toString()
            val intent=Intent()                                                                       //implicit intent
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,msg)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share to : "))
        }
        recyclerAndCardView.setOnClickListener{
            val intent=Intent(this,
                HobbiesActivity::class.java)
            startActivity(intent)
        }

    }
}