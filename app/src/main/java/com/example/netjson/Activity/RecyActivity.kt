package com.example.netjson.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.example.netjson.Adapter.AdapterUser
import com.example.netjson.Conection.MyConection
import com.example.netjson.R
import kotlinx.android.synthetic.main.activity_recy.*

class RecyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recy)
        getdata()
    }
    fun getdata()
    {
        var url = "https://api.myjson.com/bins/17754j"
        var params = HashMap<String,String>()
        var respons = Response.Listener<String> {
            var user = MyConection(this).parser(it)
            recyman.layoutManager = LinearLayoutManager(this)
            recyman.adapter = AdapterUser(user)
        }
        MyConection(this).apiRequst(url,params,respons)
    }
}
