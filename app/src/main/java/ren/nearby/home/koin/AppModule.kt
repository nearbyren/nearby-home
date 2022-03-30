package ren.nearby.home.koin

import org.koin.dsl.module

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
 *
 * 方法名	    描述	                                        使用
 * single	    生成单一对象	                                    by inject()
 * factory	    每次都会生成新的对象	                            by inject()
 * viewModel	用来创建ViewModel实例，默认生成的都是新对象	        by viewModel(),通过get<T>()来获取的ViewModel是不同的对象
 * fragment	    用来创建fragment	                                by inject()

 */
val appModule = module {
    //构建 HelloRepository 单例
    single<HelloRepository> { HelloRepositoryImp() }

    // Simple Presenter Factory
    factory { MySimplePresenter(get()) }
}

