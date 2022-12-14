package org.techtown.myapplication

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.ListFragment
import com.example.main.MySharedPreferences
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_mypage.*

// 메인 화면
class mainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var database : FirebaseDatabase
    lateinit var databaseReference: DatabaseReference

    lateinit var toolbar_text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // default 화면
        setContentView(R.layout.activity_main)

        // 처음으로 보이는 프래그먼트 홈 화면으로 설정하기
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, homeFragment())
        transaction.commit()

        var point = findViewById<TextView>(R.id.point)

        // 커스텀 툴바 사용
        toolbar_text = findViewById(R.id.toolbar_text)
        setSupportActionBar(findViewById(R.id.toolBar))

        supportActionBar!!.setDisplayShowTitleEnabled(false) // 툴바에 SDT 제목 보이기

        // 하단바 사용
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu) // 작성한 아이콘
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId) {
//            R.id.action_sidemenu -> {
//
//
//            }
        }
        return super.onOptionsItemSelected(item)
    }
    
    // 하단바 페이지 바꾸기
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

            R.id.action_home -> {
                toolbar_text.text = "어플 이름"

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, homeFragment())
                transaction.commit()
                return true
            }
            R.id.action_consumption -> {
                toolbar_text.text = "소비 전력"

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, consumptionFragment())
                transaction.commit()
                return true
            }
            R.id.action_trade -> {
                toolbar_text.text = "거래"

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, tradeFragment())
                transaction.commit()
                return true
            }

            R.id.action_distribution -> {
                toolbar_text.text = "마이페이지"

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, mypageFragment())
                transaction.commit()
                return true
            }

            R.id.action_resource_management -> {
                toolbar_text.text = "자원 관리"

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, resourceFragment())
                transaction.commit()
                return true
            }
        }
        return false
    }
}