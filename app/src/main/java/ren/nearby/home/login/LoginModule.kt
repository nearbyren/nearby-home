package ren.nearby.home.login

import org.koin.dsl.module

/**
 * @author:
 * @created on: 2022/3/29 19:17
 * @description:
 */
val loginRepoModule = module {
    single {
        LoginRepository(get())
    }
}
