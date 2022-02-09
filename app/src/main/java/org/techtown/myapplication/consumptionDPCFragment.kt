package org.techtown.myapplication

import android.content.ContentValues
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.dinuscxj.progressbar.CircleProgressBar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_consumption_detail.*
import java.util.*

// 데이 리포트
class consumptionDPCFragment : Fragment() {

    val database = Firebase.database

    lateinit var two_ago: TextView
    lateinit var one_ago: TextView
    lateinit var to_day: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_consumption_dpc, container, false)

        two_ago = view.findViewById(R.id.two_ago)
        one_ago = view.findViewById(R.id.one_mon)
        to_day = view.findViewById(R.id.to_mon)

        val instance = Calendar.getInstance()
        val date = instance.get(Calendar.DATE).toString()

        var a = 0
        var b = ""
        var c = ""

        a = date.toInt()
        b = (a - 1).toString()
        c = (a - 2).toString()

        to_day.text = date + "일"
        one_ago.text = b + "일"
        two_ago.text = c + "일"

        var mSolidProgressBar1 =
            view.findViewById<CircleProgressBar>(R.id.daily_1)
        var mSolidProgressBar2 =
            view.findViewById<CircleProgressBar>(R.id.daily_2)
        var mSolidProgressBar3 =
            view.findViewById<CircleProgressBar>(R.id.daily_3)

        mSolidProgressBar1.max = 100
        mSolidProgressBar2.max = 100
        mSolidProgressBar3.max = 100

        var graph_max1 = mSolidProgressBar1.max
        var graph_max2 = mSolidProgressBar2.max
        var graph_max3 = mSolidProgressBar3.max

        var y = "0"

        mSolidProgressBar1.progress = 20
        var graph_progress1 = mSolidProgressBar1.progress

        mSolidProgressBar2.progress = 57
        var graph_progress2 = mSolidProgressBar2.progress

        mSolidProgressBar3.progress = 75
        var graph_progress3 = mSolidProgressBar3.progress

        mSolidProgressBar1.setProgressFormatter { graph_progress1, graph_max1 ->
            val DEFAULT_PATTERN = "%dkw"
            String.format(
                DEFAULT_PATTERN,
                (graph_progress1.toFloat() / graph_max1.toFloat() * 100).toInt()
            )
        }
        mSolidProgressBar2.setProgressFormatter { graph_progress2, graph_max2 ->
            val DEFAULT_PATTERN = "%dkw"
            String.format(
                DEFAULT_PATTERN,
                (graph_progress2.toFloat() / graph_max2.toFloat() * 100).toInt()
            )
        }
        mSolidProgressBar3.setProgressFormatter { graph_progress3, graph_max3 ->
            val DEFAULT_PATTERN = "%dkw"
            String.format(
                DEFAULT_PATTERN,
                (graph_progress3.toFloat() / graph_max3.toFloat() * 100).toInt()
            )
        }


        mSolidProgressBar1.setProgressStartColor(Color.parseColor("#75A488"))
        mSolidProgressBar1.setProgressEndColor(Color.parseColor("#75A488"))
        mSolidProgressBar1.setProgressBackgroundColor(Color.parseColor("#CFDFD6"))
        mSolidProgressBar1.setProgressTextColor(Color.parseColor("#75A488"))
        mSolidProgressBar1.setProgressTextSize(60F)
        mSolidProgressBar1.setStyle(2) // LINE 0, SOLID 1, SOLID_LINE 2
        mSolidProgressBar1.setCap(Paint.Cap.ROUND)

        mSolidProgressBar2.setProgressStartColor(Color.parseColor("#75A488"))
        mSolidProgressBar2.setProgressEndColor(Color.parseColor("#75A488"))
        mSolidProgressBar2.setProgressBackgroundColor(Color.parseColor("#CFDFD6"))
        mSolidProgressBar2.setProgressTextColor(Color.parseColor("#75A488"))
        mSolidProgressBar2.setProgressTextSize(60F)
        mSolidProgressBar2.setStyle(2) // LINE 0, SOLID 1, SOLID_LINE 2
        mSolidProgressBar2.setCap(Paint.Cap.ROUND)

        mSolidProgressBar3.setProgressStartColor(Color.parseColor("#75A488"))
        mSolidProgressBar3.setProgressEndColor(Color.parseColor("#75A488"))
        mSolidProgressBar3.setProgressBackgroundColor(Color.parseColor("#CFDFD6"))
        mSolidProgressBar3.setProgressTextColor(Color.parseColor("#75A488"))
        mSolidProgressBar3.setProgressTextSize(60F)
        mSolidProgressBar3.setStyle(2) // LINE 0, SOLID 1, SOLID_LINE 2
        mSolidProgressBar3.setCap(Paint.Cap.ROUND)

        return view
    }
}