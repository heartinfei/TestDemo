package com.wangqiang.pro.unittestdemo

/**
 *
 * @author 王强 on 2018/10/10 249346528@qq.com
 */
interface MainView {
    fun onResult(result: LoginResult)
}

data class LoginResult(val state: Boolean, val msg: String)