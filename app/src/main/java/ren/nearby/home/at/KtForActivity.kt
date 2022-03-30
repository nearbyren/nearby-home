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
import kotlinx.android.synthetic.main.activity_for.*

/**
 * @author:
 * @created on: 2022/3/10 13:58
 * @description:
 */
class KtForActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for)

        permission1.setOnClickListener {
            requestPermission1.launch(Manifest.permission.CAMERA)
        }
        permission2.setOnClickListener {
            requestPermission2.launch(arrayOf(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS))
        }

        start_for.setOnClickListener {
            start()
        }


    }

    fun start() {
        val intent = Intent(KtMainAt@ this, KtForToActivity::class.java).apply {
            putExtra("name", "测试 registerForActivityResult")
        }
        myActivityLauncher.launch(intent)
    }


    private val requestPermission1 =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                tv.text = " Permission is Granted"
                Toast.makeText(KtMainAt@ this, " Permission is Granted", Toast.LENGTH_LONG).show()

            } else {
                tv.text = " Permission is denied"
                Toast.makeText(KtMainAt@ this, " Permission is denied", Toast.LENGTH_LONG).show()
            }


        }
    private val requestPermission2 =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permission: Map<String, Boolean> ->
            var sb = StringBuffer()
            permission.entries.forEach { maps ->
                sb.append("key = ${maps.key} - value =  ${maps.value}")
                sb.append("\n")
            }
            tv.text = sb.toString()

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