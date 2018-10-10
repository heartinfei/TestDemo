package com.wangqiang.pro.unittestdemo

/**
 *
 * @author 王强 on 2018/10/10 249346528@qq.com
 */
class MainModel {
    private val charRegex: Regex = Regex("[a-zA-Z]")

    /**
     * 合法校验，只允许输入小写字母
     * @name 用户名
     * @return true 验证通过
     */
    private fun checkUserName(name: String): Boolean = name.toCharArray().map {
        it.toString()
    }.filter {
        var r = !it.matches(charRegex)
        return@filter r
    }.toList().isEmpty()

    /**
     * 模拟登陆，
     * 用户名：admin
     * 密码：123456
     */
    fun doLogin(name: String, psw: String): LoginResult {
        return if (checkUserName(name)) {
            if (name == "admin" && psw == "123456") {
                LoginResult(true, "Success")
            } else {
                LoginResult(false, "Fail")
            }
        } else {
            return LoginResult(false, "User name is not valid.")
        }
    }
}
