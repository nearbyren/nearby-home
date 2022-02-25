package ren.nearby.home_module

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger
import ren.nearby.common_module.BaseActivityKot
import ren.nearby.share_export.ShareServiceUtil
import ren.nearby.share_export.router.ShareRouterTable


/**
 * @author:
 * @created on: 2022/2/24 11:28
 * @description:
 */
class MainActivity : BaseActivityKot() {


    override fun initView() {
        super.initView()
        Toast.makeText(MainActivity@this,"1",Toast.LENGTH_LONG).show()
        Logger.d("share share_export initView")
        ShareServiceUtil.navigateShareWx()
        ShareServiceUtil.shareWxResult()
    }

}