package ren.nearby.home.koin

/**
 * @author:
 * @created on: 2022/3/10 14:02
 * @description:构造被注入的组件
 */
interface HelloRepository {
    fun giveHello(): String
}