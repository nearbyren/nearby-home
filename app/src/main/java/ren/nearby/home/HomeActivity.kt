package ren.nearby.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import ren.nearby.home.at.KtForActivity
import ren.nearby.home.at.KtRepository
import ren.nearby.home.login.KtLoginAct

/**
 * @author: lr
 * @created on: 2022/2/25 9:28 下午
 * @description:
 */
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        start_repository.setOnClickListener {
            startActivity(Intent(HomeActivity@ this, KtRepository::class.java))
        }
        start_for.setOnClickListener {
            startActivity(Intent(HomeActivity@ this, KtForActivity::class.java))
        }
        start_login.setOnClickListener {
            startActivity(Intent(HomeActivity@ this, KtLoginAct::class.java))
        }
    }
}