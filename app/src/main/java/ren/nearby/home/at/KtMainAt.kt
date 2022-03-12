package ren.nearby.home.at

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import ren.nearby.home.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ren.nearby.home.vm.ModuleData
import ren.nearby.home.vm.MyViewModule
import ren.nearby.home_module.MainActivity
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
            Log.d("HOME", firstPresenter.sayHello())
            Log.d("HOME", libBean.toString())
            Log.d("HOME", moduleData.toString())
            start()
        }
        permission1.setOnClickListener {
            requestPermission1.launch(Manifest.permission.CAMERA)
        }
        permission2.setOnClickListener {
            requestPermission2.launch(arrayOf(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS))
        }

        l2.setOnClickListener {
            startActivity(Intent(KtMainAt@ this, MainActivity::class.java))
        }

    }

    fun start() {
        val intent = Intent(KtMainAt@ this, Kt2MainAt::class.java).apply {
            putExtra("name", "测试 registerForActivityResult")
        }
        myActivityLauncher.launch(intent)
    }

    private val requestPermission1 =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) Toast.makeText(KtMainAt@ this, " Permission is Granted", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(KtMainAt@ this, " Permission is denied", Toast.LENGTH_LONG).show()

        }
    private val requestPermission2 =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permission: Map<String, Boolean> ->
            permission.entries.forEach { maps ->
                Log.d("HOME", "key = ${maps.key} - value =  ${maps.value}")
            }

        }
    private val myActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                val result = activityResult.data?.getStringExtra("result")
                Toast.makeText(KtMainAt@ this, result, Toast.LENGTH_LONG).show()
                tv.text = result
            }
        }


}