package ren.nearby.home.at

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ren.nearby.home.R
import kotlinx.android.synthetic.main.activity_for_to.*

/**
 * @author:
 * @created on: 2022/3/10 13:58
 * @description:
 */
class KtForToActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_to)
        set_result.setOnClickListener {
            val intent = Intent().apply {
                putExtra("result", "hello 我是返回的result")
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        }


}