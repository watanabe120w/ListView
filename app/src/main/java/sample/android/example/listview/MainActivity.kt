package sample.android.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //リスト表示するタイムゾーンの一覧
        val timeZones = TimeZone.getAvailableIDs()

        //リストをレイアウトから探す
        val listView = findViewById<ListView>(R.id.timeZoneList)

        //アダプタ作成
        val adapter = ArrayAdapter<String>(this,
            R.layout.list_time_zone_row,
            R.id.timeZone,
            timeZones)

        //リストにアダプターをセット

        listView.adapter = adapter

        //リストタップ時の動作
        listView.setOnItemClickListener { parent, view, position, id ->

            //アダプターから、押された位置のタイムゾーン取得
            val timeZone = adapter.getItem(position)

            //Toast表示
            Toast.makeText(this,timeZone,Toast.LENGTH_SHORT).show()
        }
    }
}
