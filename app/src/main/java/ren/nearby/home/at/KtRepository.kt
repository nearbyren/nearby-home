package ren.nearby.home.at

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ren.nearby.home.R
import kotlinx.android.synthetic.main.activity_repository.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import ren.nearby.home.koin.HelloRepository
import ren.nearby.home.vm.*
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


    val girl: Girl by inject()

    val person: Person by inject()


//    val person1: Person by inject(named("single"))

    val person2: Person by inject(named("double"))

    //.构造参数从外面传入,通过声明函数创建
    val person3: Person by inject() {
        //通过parametersOf()传递参数
        parametersOf(girl)
    }

    //创建scope方式一,创建Scope时传入一个id，这个id就是来实现获取对应类的
    val scope = getKoin().createScope("my_scope_id", named("my_scope"))

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
            tv_content.text =
                "${myViewModule.sayHello()}, ${libBean}, ${moduleData} , ${girl.speak()} , ${person.speak()} , , ${person2.speak()} , ${person3.speak()}"
        }
        btn_scope.setOnClickListener {
            /**
             * @see ren.nearby.home.at.KtForToActivity.onCreate
             */
            val scopeDate = scope.get<ScopeData>()
            val str = scopeDate?.let { scopeDate.toString() } ?: "null"
            tv_content.text = "${str} "



            startActivity(Intent(KtRepository@ this, KtForToActivity::class.java))

        }


    }
}