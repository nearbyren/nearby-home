package ren.nearby.home.app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import org.koin.core.context.startKoin
import ren.nearby.home.BuildConfig
import ren.nearby.home.login.BaseContext
import ren.nearby.home.vm.appModule2
import ren.nearby.home_module.koin.LibModule
import timber.log.Timber

/**
 * @author:
 * @created on: 2022/3/10 14:26
 * @description:
 */
class HomeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        val formatStrategy: FormatStrategy = PrettyFormatStrategy
                .newBuilder()
                .showThreadInfo(true) //（可选）是否显示线程信息。 默认值为true
                //                .methodCount(5)// （可选）要显示的方法行数。 默认2
                //                .methodOffset(7) // （可选）设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
                //                .logStrategy() //（可选）更改要打印的日志策略。 默认LogCat
                .tag("Home") //（可选）每个日志的全局标记。
                .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
        BaseContext.instance.init(this)
        //初始化koin
        startKoin {
//            androidLogger()
//            androidContext(this@KtApplication)
//            modules(appModule)
            modules(appModule2, LibModule.libModule)
        }
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}