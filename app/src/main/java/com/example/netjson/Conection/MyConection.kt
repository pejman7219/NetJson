package com.example.netjson.Conection

import android.content.Context
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.netjson.ObjectUser.UserObject
import org.json.JSONException
import org.json.JSONObject

class MyConection (var context: Context){

    fun apiRequst(url : String,params:HashMap<String,String>,response : Response.Listener<String>)
    {
        var strRequst = object : StringRequest(Request.Method.GET,url,response,Response.ErrorListener {

        }){
            override fun getParams(): MutableMap<String, String> {
                return params
            }
        }
        try {
            var que = Volley.newRequestQueue(context)
            strRequst.retryPolicy = DefaultRetryPolicy(
                3000,0,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

            que.add(strRequst)

        }catch (e : JSONException)
        {

        }
    }
    fun parser(strresponse : String):ArrayList<UserObject>
    {
        var result = ArrayList<UserObject>()
        var jobject = JSONObject(strresponse)
        var status = jobject.optString("ststus")
        if (status == "ok")
        {
            var jarray = jobject.getJSONArray("data")
            for (i in 0 until jarray.length())
            {
                var user = UserObject().dataParser(jarray.getJSONObject(i))
                result.add(user)
            }
        }else
        {

        }
        return result
    }
}