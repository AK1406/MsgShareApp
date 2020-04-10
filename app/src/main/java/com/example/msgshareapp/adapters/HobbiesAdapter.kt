package com.example.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.provider.Settings.Global.getString
import android.provider.Settings.Secure.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.msgshareapp.models.Hobby
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context,private val hobbies:List<Hobby>):RecyclerView.Adapter<HobbiesAdapter.MyHolderView>() {

    companion object{
        val TAG : String= HobbiesAdapter::class.java.simpleName
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderView {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
      return  MyHolderView(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyHolderView, position: Int) {
        val hobby=hobbies[position]
        holder.setData(hobby,position)
    }
    inner class MyHolderView(itemView:View):RecyclerView.ViewHolder(itemView){
        private var currentHobby: Hobby?=null
        private var currentPosition :Int =0
        init{
            itemView.setOnClickListener{
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + "Clicked !")
                }

            }
            itemView.imgShare.setOnClickListener {
                currentHobby?.let{
                    val msg: String = "My Hobby is "+currentHobby!!.title
                    val intent= Intent()                                                                       //implicit intent
                    intent.action= Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,msg)
                    intent.type="text/plain"
                    context.startActivity(Intent.createChooser(intent,"Share to : "))
                }

            }
        }
        fun setData(hobby: Hobby?, pos:Int){
            hobby?.let {
                itemView.txtTitle.text = hobby!!.title
            }
            currentHobby=hobby
            currentPosition=pos

        }

    }


}