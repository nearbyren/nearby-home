package ren.nearby.home.net.model

import ren.nearby.home.net.exception.ResultException


sealed class NetResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : NetResult<T>()

    data class Error(val exception: ResultException) : NetResult<Nothing>()


}