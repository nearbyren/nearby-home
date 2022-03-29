package ren.nearby.home.net.net


import com.orhanobut.logger.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import ren.nearby.home.net.exception.DealException
import ren.nearby.home.net.exception.ResultException
import ren.nearby.home.net.model.BaseModel
import ren.nearby.home.net.model.NetResult

open class BaseRepository {

    suspend fun <T : Any> callRequest(call: suspend () -> NetResult<T>): NetResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            Logger.d(e.message)
            //这里统一处理异常
            e.printStackTrace()
            NetResult.Error(DealException.handlerException(e))
        }
    }

    suspend fun <T : Any> handleResponse(
        response: BaseModel<T>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): NetResult<T> {
        // val respone = service.create(RequestCenter::class.java).login(username, password)
        return coroutineScope {
            if (response.errorCode == -1) {
                errorBlock?.let { it() }
                NetResult.Error(
                    ResultException(response.errorCode.toString(), response.errorMsg)
                )
            } else {
                successBlock?.let { it() }
                NetResult.Success(response.data)
            }
        }
    }


}