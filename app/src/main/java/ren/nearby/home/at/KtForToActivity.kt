package ren.nearby.home.at

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ren.nearby.home.R
import kotlinx.android.synthetic.main.activity_for_to.*
import kotlinx.android.synthetic.main.activity_repository.*
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named
import ren.nearby.home.vm.ScopeData

/**
 * @author:
 * @created on: 2022/3/10 13:58
 * @description:
 */
class KtForToActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_to)

        /**
         * @see ren.nearby.home.at.KtRepository.scope
         */
        val scope = getKoin().getScopeOrNull("my_scope_id")//创建scope方式一
        val scopeData = scope?.get<ScopeData>()//获取作用域下的类
        tv.text = "scope data ${scopeData.toString()}"




        set_result.setOnClickListener {
            val intent = Intent().apply {
                putExtra("result", "hello 我是返回的result")
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


}