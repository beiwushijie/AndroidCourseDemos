package com.example.firstdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.firstdemo.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    //    定义证书变量
    private var leftNum = 0
    private var rightNum = 0
    private var score = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) 使用binding就不能用了
//        初始化
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun refresh() {
        leftNum = Random.nextInt(until = 100)
        rightNum = Random.nextInt(until = 100)
        while (rightNum == leftNum) {
            rightNum = Random.nextInt(until = 100)
        }
//        引入binding需要重写下面
        binding.buttonLeft.text = "$leftNum"
        findViewById<Button>(R.id.button_left).text = "$leftNum"
        findViewById<Button>(R.id.button_right).text = "$rightNum"
        binding.textViewScore.text = getString(R.string.app_score, score)
//        findViewById<TextView>(R.id.textView_score).text = getString(R.string.app_score, score)
    }

    fun leftButtonClick(view: View) {
        check(true)
    }

    fun rightButtonClick(view: View) {
        check(false)
    }

    private fun check(isLeft: Boolean) {
        if (isLeft && leftNum > rightNum || !isLeft && leftNum < rightNum) score++
        else score--
        refresh()
    }
}