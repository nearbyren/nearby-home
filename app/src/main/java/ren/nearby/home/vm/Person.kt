package ren.nearby.home.vm

import com.orhanobut.logger.Logger

/**
 * @author:
 * @created on: 2022/3/30 14:42
 * @description:
 */
class Person(val girl: Girl, val girl2: Girl? = null) {
    fun speak() {
        Logger.d("我的女朋友是${girl.name}")
    }
}
