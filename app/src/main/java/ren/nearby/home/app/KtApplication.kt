package ren.nearby.home.app

import android.app.Application
import org.koin.core.context.startKoin
import ren.nearby.home.vm.appModule2
import ren.nearby.home_module.koin.LibModule

/**
 * @author:
 * @created on: 2022/3/10 14:26
 * @description:
 */
class KtApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //初始化koin
        startKoin {
//            androidLogger()
//            androidContext(this@KtApplication)
//            modules(appModule)
            modules(appModule2, LibModule.libModule)
        }
    }
}