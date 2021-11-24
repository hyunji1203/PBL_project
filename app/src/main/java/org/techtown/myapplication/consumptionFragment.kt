package org.techtown.myapplication

import android.content.ContentValues
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.techtown.myapplication.databinding.FragmentConsumptionMainBinding


class consumptionFragment : Fragment() {

    val db = Firebase.firestore

    private var _binding: FragmentConsumptionMainBinding? = null
    private val binding get() = _binding!!

    lateinit var btn_back: ImageView
    lateinit var btn_forward: ImageView

    lateinit var c_middle : TextView
    lateinit var c_measure : TextView

    lateinit var main_month: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_consumption_main, container, false)

        btn_back = view.findViewById(R.id.btn_back)
        btn_forward = view.findViewById(R.id.btn_forward)

        c_middle = view.findViewById(R.id.c_middle)
        c_measure = view.findViewById(R.id.c_measure)

        main_month = view.findViewById(R.id.main_month)

        var n = 0

        //특정 데이터 값 갖고 오기!
        db.collection("users").whereEqualTo("name", "가구1").get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    var x = document["measure"] as Number
                    var y = document["middle"] as Number
                    c_measure.text = x.toString() + "kw"
                    c_middle.text = "평균 " + y.toString() + "KW"
                }
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
            }

        btn_forward.setOnClickListener {
            if (n == 0 || n == 1) {
                n++
            }

            when (n) {
                0 -> {
                    main_month.text = "가구1"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구1").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                }
                1 -> {
                    main_month.text = "가구2"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구2").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                }
                2 -> {
                    main_month.text = "가구3"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구3").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                }
            }
        }
        btn_back.setOnClickListener {
            if (n == 2 || n == 1) {
                n--
            }


            when (n) {
                0 -> {
                    main_month.text = "가구1"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구1").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                }
                1 -> {
                    main_month.text = "가구2"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구2").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                }
                2 -> {
                    main_month.text = "가구3"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구3").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                }
            }
        }


        main_month.setOnClickListener {
            var main_name = main_month.text

            _binding = FragmentConsumptionMainBinding.inflate(inflater, container, false)

            var intent = Intent(view.context, consumptionDetailActivity::class.java)
            intent.putExtra("name", main_name)
            startActivity(intent)
        }

        return view

        /*var measure = ""

        //특정 데이터 값 갖고 오기!
        db.collection("users").whereEqualTo("name", main_name).get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    var x = document["measure"] as Number
                    measure = x.toString()
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }*/

        /*val db = Firebase.firestore

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)

        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

        val user2 = hashMapOf(
            "first" to "Alan",
            "last" to "Turing",
            "born" to 1999
        )

        db.collection("users")
            .add(user2)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

        db.collection("users").get().addOnSuccessListener { result ->
            for (document in result) {
                Log.d(TAG, "${document.id} => ${document.data}")

                user(document["born"] as Number, document["first"] as String, document["last"] as String)
                var y = document["first"] as String
                textView2.text = y
            }
        }.addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }

        db.collection("users").get().addOnSuccessListener { result ->

            for (document in result) {  // 가져온 문서들은 result에 들어감
                //val item = user(document["born"] as Int, document["first"] as String, document["last"] as String)
                var x = document["born"] as Number
                textView3.text = x.toString()
            }
        }.addOnFailureListener { exception ->
            // 실패할 경우
            Log.w(TAG, "Error getting documents.", exception)
        }*/
    }
}