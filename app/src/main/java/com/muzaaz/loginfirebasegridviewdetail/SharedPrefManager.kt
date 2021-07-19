package com.muzaaz.loginfirebasegridviewdetail

import android.content.SharedPreferences

class SharedPrefManager {
    companion object {
        val SP_APP = "spLoginFirebase"
        val SP_SUDAH_LOGIN = "spSudahLogin"

        lateinit var sp : SharedPreferences
        lateinit var spEditor: SharedPreferences.Editor
    }

    fun saveSPBoolean (keySp: String, value: Boolean) {
        spEditor.putBoolean(keySp, value)
        spEditor.commit()
    }

    fun getSPSudahLogin(): Boolean? {
        return sp.getBoolean(SP_SUDAH_LOGIN, false)
    }
}