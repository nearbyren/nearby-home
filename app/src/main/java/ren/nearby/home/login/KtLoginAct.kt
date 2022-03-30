package ren.nearby.home.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.orhanobut.logger.Logger
import ren.nearby.home.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import ren.nearby.home.login.LoginViewModel
import ren.nearby.home.vm.ModuleData
import ren.nearby.home.vm.MyViewModule
import ren.nearby.home_module.koin.LibBean

/**
 * @author:
 * @created on: 2022/3/10 13:58
 * @description:
 */
class KtLoginAct : AppCompatActivity() {

    //    lateinit var mViewModel: T
//    val clazz = this.javaClass.kotlin.supertypes[0].arguments[0].type!!.classifier!! as KClass<T>
//     mViewModel = getViewModel<T>(clazz) //koin 注入
    val login: LoginViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        net.setOnClickListener {
            login?.let {
                login.login("595954727", "595954727").observe(this, Observer { us ->
                    Logger.d("login ...........")
                    tv.text = "${tv.text} , ${us.username}"
                })
            }
        }

    }
}