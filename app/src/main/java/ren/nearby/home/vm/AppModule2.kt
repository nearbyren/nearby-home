package ren.nearby.home.vm

import org.koin.dsl.module
import ren.nearby.home.koin.HelloRepository
import ren.nearby.home.koin.HelloRepositoryImp

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
    //构建 HelloRepository 单例
    single<HelloRepository> {
        HelloRepositoryImp()
    }

    // Simple Presenter Factory
    factory {
        MyViewModule(get())
    }

    //lib module
    factory {
        ModuleData(get())
    }
}

