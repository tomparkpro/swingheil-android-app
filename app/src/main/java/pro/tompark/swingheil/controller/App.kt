package pro.tompark.swingheil.controller

import android.app.Application
import pro.tompark.swingheil.utility.SharedPrefs

/**
 * Created by TomPark on 2018. 5. 30.
 *
 * @author tom.hyunung.park@gmail.com
 * github : http://github.com/tomparkpro
 *
 */
class App : Application() {

    companion object {
        lateinit var prefs: SharedPrefs
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }
}