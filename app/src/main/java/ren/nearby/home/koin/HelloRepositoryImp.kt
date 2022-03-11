package ren.nearby.home.koin

/**
 * @author:
 * @created on: 2022/3/10 14:03
 * @description:构造被注入的组件
 */
class HelloRepositoryImp() : HelloRepository {
    override fun giveHello() = "hello koin"
}