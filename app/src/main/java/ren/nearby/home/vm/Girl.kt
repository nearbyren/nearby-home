package ren.nearby.home.vm

import com.orhanobut.logger.Logger

/**
 * @author:
 * @created on: 2022/3/30 14:42
 * @description:
 */
class Girl(val name: String) {
    fun speak() {
        Logger.d("!!!", "哦是大美女" + this)
    }
}