package ren.nearby.home_module

import kotlinx.android.synthetic.main.home_activity_main.*
import ren.nearby.common_module.BaseActivityKot
import ren.nearby.share_export.ShareServiceUtil
import ren.nearby.share_export.TEstss


/**
 * @author:
 * @created on: 2022/2/24 11:28
 * @description:
 */
class MainActivity : BaseActivityKot() {


    override fun getLayoutResKot(): Int {
        return R.layout.home_activity_main
    }

    override fun initView() {
        super.initView()
        home_tv.text = "我是module"
        home_share.setOnClickListener {
            ShareServiceUtil.shareWxResult()
        }
        TEstss.t5()
        TEstss.t7()
        TEstss.t8()
    }
}