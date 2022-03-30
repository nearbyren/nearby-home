package ren.nearby.home.koin

/**
 * @author:
 * @created on: 2022/3/10 14:04
 * @description:构造被注入的组件
 */
class MySimplePresenter(val repo: HelloRepository) {
    fun sayHello() = "${repo.giveHello()} from $this"
}