package com.example.msgshareapp
/* define all functions and use as many as times you want */

import android.app.Activity
import android.content.Context
import android.widget.Toast


fun Context.showToast(msg:String,duration:Int=Toast.LENGTH_SHORT){           //Context is the superclass of all activities
    Toast.makeText(this,msg,duration ).show()

}