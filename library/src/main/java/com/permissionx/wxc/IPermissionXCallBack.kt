package com.permissionx.wxc

/**
 * Created by 王新超 on 2020/5/11.
 */
interface IPermissionXCallBack {
    /**
     * @param granted 是否所有权限已通过
     * @param deniedList 用户已经拒绝的权限列表
     */
    fun callBack(granted: Boolean,deniedList:List<String>)
}