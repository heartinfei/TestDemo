package com.wangqiang.pro.unittestdemo

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 *
 * @author 王强 on 2018/10/10 249346528@qq.com
 */
class MainModelTest {
    private lateinit var mainModel: MainModel
    //用于验证用户名的合法校验
    private lateinit var errorCheckAccounts: List<String>
    //用于验证非法登陆账户
    private lateinit var errorLoginAccounts: List<String>
    //用于验证合法登陆账户
    private lateinit var rightLoginAccounts: List<String>

    @Before
    fun setUp() {
        errorCheckAccounts = listOf(
                "!@#", "123",
                "123", "123",
                "admin2", "admin",
                "用户", "123456"
        )

        errorLoginAccounts = listOf(
                "123", "123",
                "admin", "1234",
                "用户", "123456")

        rightLoginAccounts = listOf(
                "admin", "123456"
        )
        mainModel = MainModel()
    }

    @Test
    fun doLoginTest() {
        for (i in errorCheckAccounts.indices step 2) {
            mainModel.doLogin(errorCheckAccounts[i], errorCheckAccounts[i + 1]).apply {
                Assert.assertFalse(this.state)
            }
        }

        for (i in errorLoginAccounts.indices step 2) {
            mainModel.doLogin(errorLoginAccounts[i], errorLoginAccounts[i + 1]).apply {
                Assert.assertFalse(this.state)
            }
        }

        for (i in rightLoginAccounts.indices step 2) {
            mainModel.doLogin(rightLoginAccounts[i], rightLoginAccounts[i + 1]).apply {
                Assert.assertTrue(this.state)
            }
        }
    }
}