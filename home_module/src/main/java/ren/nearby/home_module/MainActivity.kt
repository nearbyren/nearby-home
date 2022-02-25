package ren.nearby.home_module

import android.widget.Toast
import com.orhanobut.logger.Logger
import ren.nearby.common_module.BaseActivityKot
import ren.nearby.share_export.ShareServiceUtil


/**
 * @author:
 * @created on: 2022/2/24 11:28
 * @description:
 */
class MainActivity : BaseActivityKot() {


    override fun initView() {
        super.initView()

        Logger.d("share share_export initView")
        ShareServiceUtil.navigateShareWx()

        Toast.makeText(
            MainActivity@ this,
            "分享 结果    =  ${ShareServiceUtil.shareWxResult()}",
            Toast.LENGTH_LONG
        ).show()
    }

}