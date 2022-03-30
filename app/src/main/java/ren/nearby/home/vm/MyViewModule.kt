package ren.nearby.home.vm

import androidx.lifecycle.ViewModel
import ren.nearby.home.koin.HelloRepository

/**
 * @author:
 * @created on: 2022/3/10 16:55
 * @description:viewModel模式
 */
class MyViewModule(val repo: HelloRepository) : ViewModel() {

    fun sayHello() = "${repo.giveHello()} from $this"
}