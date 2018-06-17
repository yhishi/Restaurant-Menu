package com.yoshiki.hishikawa.restaurantmenu

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // コンテキストメニューを表示するビューの登録
        registerForContextMenu(imageView)
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

        // コンテキストメニューが表示される時（登録されたビューが長押しされた時）の処理
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
    }

    // コンテキストメニューが選択された時の処理
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            // SMSで予約
            R.id.sms -> {
                val number = "999-9999-9999"
                val uri = Uri.parse("sms:$number")
                var intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                startActivity(intent)
                return true
            }
            // メールで予約
            R.id.mail -> {
                val email = "nobody@example.com"
                val subject = "予約問い合わせ"
                val text = "以下の通り予約希望します。"
                val uri = Uri.parse("mailto:")
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.apply {
                    data = uri
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                    putExtra(Intent.EXTRA_TEXT, text)
                }
                // 暗黙インテントを処理するためのアプリがインストール済みかチェック
                if(intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
            // 文字列の共有
            R.id.share -> {
                val text = "美味しいレストランを紹介します。"
                val intent = Intent(Intent.ACTION_SEND)
                intent.apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, text)
                }
                // 毎回アプリ選択画面を表示
                val chooser = Intent.createChooser(intent, null)
                if(intent.resolveActivity(packageManager) != null) {
                    startActivity(chooser)
                }
                return true
            }
            // ウェブサイトを開く
            R.id.browse -> {
                val url = "http://www.yahoo.co.jp/"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                if(intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}
