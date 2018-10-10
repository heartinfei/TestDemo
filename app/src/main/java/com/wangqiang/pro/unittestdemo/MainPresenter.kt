package com.wangqiang.pro.unittestdemo

/**
 *
 * @author 王强 on 2018/10/10 249346528@qq.com
 */
class MainPresenter(v: MainView) {
    private val mainView = v
    private val mainModel: MainModel = MainModel()

    fun login(name: String, psw: String) = mainView.onResult(mainModel.doLogin(name, psw))
}