package com.permissionx.wxc

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 * Created by 王新超 on 2020/5/11.
 */

//typealias 用于给任意类型置顶一个别名
typealias PermissionCallback = (Boolean, List<String>) -> Unit

class InvisibleFragment : Fragment() {

    private var callback: PermissionCallback? = null

    //vararg 关键字用于接收可变长度的permissions参数列表
    fun requestNow(cb: PermissionCallback, vararg permissions: String) {
        callback = cb
        requestPermissions(permissions, 1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {
            //记录所有被用户拒绝的权限
            val deniedList = ArrayList<String>()
            for ((index, result) in grantResults.withIndex()) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    deniedList.add(permissions[index])
                }
            }
            //标识是否所有申请的权限均已被授权
            val allGranted = deniedList.isEmpty()
            //callback 对运行时权限的申请结果进行回调
            callback?.let {
                it(allGranted, deniedList)
            }
        }
    }
}