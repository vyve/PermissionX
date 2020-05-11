package com.permissionx.wxc

/**
 * Created by 王新超 on 2020/5/11.
 */
interface IPermissionXCallBack {
    fun callBack(granted: Boolean,deniedList:List<String>)
}