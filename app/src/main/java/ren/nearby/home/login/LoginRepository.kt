package ren.nearby.home.login

import android.util.Log
import com.orhanobut.logger.Logger
import ren.nearby.home.net.model.NetResult
import ren.nearby.home.net.net.BaseRepository
import ren.nearby.home.net.net.RetrofitClient

/**
 * @author:
 * @created on: 2022/3/29 19:18
 * @description:
 */
class LoginRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun login(username: String, password: String): NetResult<User> {



        return callRequest(call = {
            requestLogin(username, password)
        })
    }

    private suspend fun requestLogin(username: String, password: String): NetResult<User> =
        handleResponse(
            service.create(RequestCenter::class.java).login(username, password),
            {
                Logger.d("success")
            },
            {
                Logger.d("error")
            }
        )

}