package com.proway.appav.AppPreferences



import android.content.Context
import androidx.core.content.edit

class AppPreferences(context: Context) {
    private val NAME_PREFERENCE = "app-data-preference"
    val base = context.getSharedPreferences(NAME_PREFERENCE, Context.MODE_PRIVATE)

    fun<T> setValue(key: Keys, value: T){
        when(value){
            is String -> base.edit {
                putString(key.name, value)
                commit()
            }
            is Int -> base.edit {
                putInt(key.name, value)
                commit()
            }
            is Boolean -> base.edit{
                putBoolean(key.name, value)
                commit()
            }
        }
    }
}
enum class Keys(name: String){
    Notifications_PUSH("key_push"),
    Notifications_Email("key_Email"),

}