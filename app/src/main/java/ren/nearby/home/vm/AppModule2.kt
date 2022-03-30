package ren.nearby.home.vm

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ren.nearby.home.koin.HelloRepository
import ren.nearby.home.koin.HelloRepositoryImp
import ren.nearby.home.login.LoginRepository
import ren.nearby.home.login.LoginViewModel
import ren.nearby.home.net.net.RetrofitClient

/**
 * @author:
 * @created on: 2022/3/10 14:05
 * @description: 将需要注入的写入 module
 */
/**
 * module 类似dagger2中的 @Module
 * single 单例模式
 * factory 每次创建新的实例
 * get()
 */
val appModule2 = module {

    //以单例模式声明将这个组件定义绑定到HelloRepository
    single<HelloRepository> {
        HelloRepositoryImp()
    }
    /*********************网络注入模块************/

    //构建网络请求
    single {
        RetrofitClient.instance
    }
    //将网络请求注入
    single {
        LoginRepository(get())
    }
    //将网络请求注入业务层
    factory {
        LoginViewModel(get())
    }
    /*********************网络注入模块************/

    // Simple Presenter Factory
    factory {
        MyViewModule(get())
    }

    //lib module
    factory {
        ModuleData(get())
    }

    single {
        Girl("luxi")
    }
    factory {
        Person(get())
    }

    //通过限定符标记构造方法--qualifier
    //传递了两个参数
    factory(named("double")) {
        Person(get(), get() )
    }
    //传递了一个参数
    factory(named("single")) { (girl: Girl) ->
        Person(girl)
    }

    /**
     * @see ren.nearby.home.at.KtRepository.onCreate
     */
    scope(named("my_scope")) {
        scoped {
            ScopeData()
        }
    }
}

