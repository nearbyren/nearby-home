package ren.nearby.home.login

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ren.nearby.home.net.model.NetResult

/**
 * @author:
 * @created on: 2022/3/29 19:28
 * @description:
 */
class LoginViewModel(private val loginRepo: LoginRepository) : ViewModel() {


    private val loginLiveData = MutableLiveData<User>()

    fun login(username: String, password: String): MutableLiveData<User> {
        viewModelScope.launch {
            val user = loginRepo.login(username, password)
            if (user is NetResult.Success) {
                loginLiveData.postValue(user.data)
            } else if (user is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    user.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }

        }

        return loginLiveData
    }

}