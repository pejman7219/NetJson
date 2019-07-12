package com.example.netjson.ObjectUser

import org.json.JSONObject

class UserObject {

    var name : String? = null
    var family :String? = null
    var email : String? = null
    var phene : Int? = 0

    fun dataParser(jparser:JSONObject):UserObject
    {
        name = jparser.optString("Name")
        family = jparser.optString("Family")
        email = jparser.optString("Email")
        phene = jparser.optInt("Phone")
        return this
    }
}