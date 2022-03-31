package ren.nearby.home.at

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger
import ren.nearby.home.R
import kotlinx.android.synthetic.main.activity_global_scope.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author:
 * @created on: 2022/3/30 20:19
 * @description:
 */
class KtGlobalScopeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_scope)
        test1.setOnClickListener {
            GlobalScope.launch {
                val launchJob = launch {
                    Logger.d("GlobalScope - > 1  launch 启动一个协程")
                }
                Logger.d("GlobalScope - > 2 launchJob ${launchJob}")

                val asyncJob = async {
                    Logger.d("GlobalScope - > 3 async 启动一个协程")
                    "GlobalScope - > 我是async返回的数据"
                }
                Logger.d("GlobalScope - > 4 asyncJob.await ${asyncJob.await()}")
                Logger.d("GlobalScope - > 5 asyncJob ${asyncJob}")

            }

        }

        test2.setOnClickListener {
            start()
        }
    }
    fun  start(){
        val runBlockingJob = runBlocking {
            Logger.d("GlobalScope - > 1 runBlocking 启动一个协程")
        }
        Logger.d("GlobalScope - > 2 runBlockingJob ${runBlockingJob}")
        val launchJob = GlobalScope.launch {
            Logger.d("GlobalScope - > 3 launch 启动一个协程")
        }
        Logger.d("GlobalScope - > 4 launchJob ${launchJob}")
        val asyncJob = GlobalScope.async {
            Logger.d("GlobalScope - > 5 async 启动一个协程")
            "我是async返回值"
        }
        Logger.d("GlobalScope - > 6 asyncJob ${asyncJob}")
    }

}