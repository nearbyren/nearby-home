package ren.nearby.home_module.koin

import org.koin.dsl.module

/**
 * @author:
 * @created on: 2022/3/10 17:48
 * @description:
 */
object LibModule {
    val libModule = module {
        single { LibBean() }
    }
}