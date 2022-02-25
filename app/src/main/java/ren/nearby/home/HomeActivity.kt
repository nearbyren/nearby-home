package ren.nearby.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ren.nearby.home_module.MainActivity

/**
 * @author: lr
 * @created on: 2022/2/25 9:28 下午
 * @description:
 */
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(HomeActivity@ this, MainActivity::class.java))

    }
}