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
    private lateinit var errorAccounts: List<String>
    private lateinit var rightAccounts: List<String>

    @Before
    fun setUp() {
        errorAccounts = listOf(
                "!@#", "123",
                "123", "123",
                "admin", "1234",
                "用户", "123456")
        rightAccounts = listOf(
                "admin", "123456"
        )
        mainModel = MainModel()
    }

    @Test
    fun doLoginTest() {

        for (i in errorAccounts.indices step 2) {
            mainModel.doLogin(errorAccounts[i], errorAccounts[i + 1]).apply {
                Assert.assertFalse(this.state)
            }
        }

        for (i in rightAccounts.indices step 2) {
            mainModel.doLogin(rightAccounts[i], rightAccounts[i + 1]).apply {
                Assert.assertTrue(this.state)
            }
        }
    }


}