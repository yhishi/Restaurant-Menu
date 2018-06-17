package com.yoshiki.hishikawa.restaurantmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // オプションメニュー初期化
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // メニュー表示（MenuInflaterクラスのインスタンス作成して、inflateメソッドでメニュー設定）
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // オプションメニュー選択時の処理
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.top -> {
                imageView.setImageResource(R.drawable.toppage)
                return true
            }
            R.id.lunch01 -> {
                imageView.setImageResource(R.drawable.lunch01)
                return true
            }
            R.id.lunch02 -> {
                imageView.setImageResource(R.drawable.lunch02)
                return true
            }
            R.id.dinner01 -> {
                imageView.setImageResource(R.drawable.dinner01)
                return true
            }
            R.id.dinner02 -> {
                imageView.setImageResource(R.drawable.dinner02)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
