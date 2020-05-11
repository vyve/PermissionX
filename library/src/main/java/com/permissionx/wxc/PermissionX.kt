package com.permissionx.wxc

import androidx.appcompat.app.AppCompatActivity

/**
 * object  单例类
 * Created by 王新超 on 2020/5/11.
 */
object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(activity: AppCompatActivity,vararg permissions:String,callback: PermissionCallback){
        val fragmentManager = activity.supportFragmentManager

        val exitedFragment = fragmentManager.findFragmentByTag(TAG)

        val fragment = if (exitedFragment!=null){
            exitedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }

        fragment.requestNow(callback,*permissions)
    }
}