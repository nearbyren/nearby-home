package ren.nearby.home.at

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ren.nearby.home.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ren.nearby.home.vm.ModuleData
import ren.nearby.home.vm.MyViewModule
import ren.nearby.home_module.koin.LibBean

/**
 * @author:
 * @created on: 2022/3/10 13:58
 * @description:
 */
class KtMainAt : AppCompatActivity() {


    //注入方式
//    val firstPresenter: MySimplePresenter by inject()
    //注入方式
    val firstPresenter: MyViewModule by viewModel()


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
        button.setOnClickListener {
            Log.d("T", firstPresenter.sayHello())
            Log.d("T", libBean.toString())
            Log.d("T", moduleData.toString())
        }
    }
}