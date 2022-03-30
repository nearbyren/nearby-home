package ren.nearby.home.at

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ren.nearby.home.R
import kotlinx.android.synthetic.main.activity_repository.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ren.nearby.home.koin.HelloRepository
import ren.nearby.home.vm.ModuleData
import ren.nearby.home.vm.MyViewModule
import ren.nearby.home_module.koin.LibBean

/**
 * @author:
 * @created on: 2022/3/10 13:58
 * @description:
 */
class KtRepository : AppCompatActivity() {


//    private val repository: HelloRepository by inject()

    private val mRepository: HelloRepository = get()


    val myViewModule: MyViewModule by viewModel()

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
        setContentView(R.layout.activity_repository)
        btn_inject_get.setOnClickListener {
            tv_content.text = mRepository.giveHello()
        }
        btn_view_model.setOnClickListener {
            tv_content.text = "${myViewModule.sayHello()}, ${libBean}, ${moduleData}"
        }
    }
}