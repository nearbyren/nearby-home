package ren.nearby.home

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author: lr
 * @created on: 2022/2/25 9:54 下午
 * @description:
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ARouter.openDebug()
        ARouter.openDebug()
        ARouter.init(this)
    }

}