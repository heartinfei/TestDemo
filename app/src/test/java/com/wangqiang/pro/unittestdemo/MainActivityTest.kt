package com.wangqiang.pro.unittestdemo

import android.app.Activity
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast

/**
 *
 * @author 王强 on 2018/10/15 249346528@qq.com
 */
@Config(sdk = [21])
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    private lateinit var mainActivity: Activity
    private lateinit var etName: EditText
    private lateinit var etPsw: EditText
    private lateinit var btn: Button
    @Before
    fun setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        etName = mainActivity.findViewById(R.id.editName)
        etPsw = mainActivity.findViewById(R.id.etPsw)
        btn = mainActivity.findViewById(R.id.button)
    }

    @Test
    fun testLoginSuccess() {
        etName.setText("admin")
        etPsw.setText("123456")
        btn.performClick()
        val exceptIntent = Intent(mainActivity, UserActivity::class.java)
        val actual = Shadows.shadowOf(RuntimeEnvironment.application).nextStartedActivity
        Assert.assertEquals(exceptIntent.component, actual.component)
    }

    @Test
    fun testLoginFail() {
        etName.setText("abc")
        etPsw.setText("123")
        Assert.assertNull(ShadowToast.getLatestToast())
        btn.performClick()
        Assert.assertNotNull(ShadowToast.getLatestToast())
    }

}