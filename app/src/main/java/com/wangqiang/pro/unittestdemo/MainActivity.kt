package com.wangqiang.pro.unittestdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/**
 *
 * @author 王强 on 2018/10/10 249346528@qq.com
 */
class MainActivity : MainView, AppCompatActivity() {
    private val mainPresenter: MainPresenter = MainPresenter(this)

    private val btnLogin: Button by lazy {
        findViewById<Button>(R.id.button)
    }

    private val etName: EditText by lazy {
        findViewById<EditText>(R.id.editName)
    }

    private val etPsw: EditText by lazy {
        findViewById<EditText>(R.id.etPsw)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            mainPresenter.login(etName.text.toString(), etPsw.text.toString())
        }
    }

    override fun onResult(result: LoginResult) {
        startActivity(Intent(this@MainActivity, UserActivity::class.java))
        if (result.state) {
            startActivity(Intent(this@MainActivity, UserActivity::class.java))
        } else {
            Toast.makeText(this@MainActivity, result.msg, Toast.LENGTH_LONG).show()
        }

    }
}

