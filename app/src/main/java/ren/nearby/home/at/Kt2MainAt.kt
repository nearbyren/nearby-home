package ren.nearby.home.at

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
class Kt2MainAt : AppCompatActivity() {


    //注入方式
//    val firstPresenter: MySimplePresenter by inject()
    //注入方式
    val firstPresenter: MyViewModule by viewModel()

    val login: LoginViewModel by viewModel()

    val libBean by inject<LibBean>()

    val moduleData by inject<ModuleData>()

    /***
     *     // 更多方式
     *     // non lazy
     *     val firstPresenter: MySimplePresenter = get()
     *     // lazy inject
     *     private val homePresenter by inject<HomePresenter>()
     *     // non lazy
     *     private val homePresenter = get<HomePresenter>()
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intent?.let {
            val st = intent.getStringExtra("name")
            Log.d("HOME", "输出  - > ${st}")
            tv.text = st
        }
        button.setOnClickListener {
            Log.d("HOME", firstPresenter.sayHello())
            Log.d("HOME", libBean.toString())
            Log.d("HOME", moduleData.toString())
            val intent = Intent().apply {
                putExtra("result", "hello 我是返回的result")
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        net.setOnClickListener {
            login?.let {
                login.login("11", "11").observe(this, Observer { us ->
                        Logger.d("login ...........")
                })
            }
        }

    }
}