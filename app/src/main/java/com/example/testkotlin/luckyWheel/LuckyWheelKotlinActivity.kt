package com.example.testkotlin.luckyWheel

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.bluehomestudio.luckywheel.WheelItem
import com.example.testkotlin.R
import com.example.testkotlin.databinding.ActivityLuckyWheelKotlinBinding
import java.util.*

class LuckyWheelKotlinActivity : AppCompatActivity() {

    lateinit var binding: ActivityLuckyWheelKotlinBinding

    //https://www.youtube.com/watch?v=r8haL7agB_E

    var wheelItemList: MutableList<WheelItem> = ArrayList()
    var points: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLuckyWheelKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val wheelItem1 = WheelItem(
            ResourcesCompat.getColor(resources, R.color.colorAccent, null),
            BitmapFactory.decodeResource(resources, R.drawable.setting), "0"
        )

        val wheelItem2 = WheelItem(
            ResourcesCompat.getColor(resources, R.color.colorPrimary, null),
            BitmapFactory.decodeResource(resources, R.drawable.setting), "1 0"
        )

        val wheelItem3 = WheelItem(
            ResourcesCompat.getColor(resources, R.color.colorAccent, null),
            BitmapFactory.decodeResource(resources, R.drawable.setting), "2 0"
        )

        val wheelItem4 = WheelItem(
            ResourcesCompat.getColor(resources, R.color.colorPrimary, null),
            BitmapFactory.decodeResource(resources, R.drawable.setting), "3 0"
        )

        val wheelItem5 = WheelItem(
            ResourcesCompat.getColor(resources, R.color.colorAccent, null),
            BitmapFactory.decodeResource(resources, R.drawable.setting), "4 0"
        )

        val wheelItem6 = WheelItem(
            ResourcesCompat.getColor(resources, R.color.colorPrimary, null),
            BitmapFactory.decodeResource(resources, R.drawable.setting), "5 0"
        )



        wheelItemList.add(wheelItem1)
        wheelItemList.add(wheelItem2)
        wheelItemList.add(wheelItem3)
        wheelItemList.add(wheelItem4)
        wheelItemList.add(wheelItem5)
        wheelItemList.add(wheelItem6)


        binding.luckyWheel.addWheelItems(wheelItemList)


        binding.luckyWheel.setLuckyWheelReachTheTarget {

            var oo = points
            var ee = oo
            val itemSelected = wheelItemList[points!!.toInt() - 1]
            val point_amount = itemSelected.text
            Toast.makeText(this@LuckyWheelKotlinActivity, point_amount , Toast.LENGTH_SHORT).show()
        }


        binding.btnPlay.setOnClickListener {
            val random = Random()
            points = random.nextInt(6).toString()    // number 6  is the length of wheelItemList
            if (points == "0") {
                points = 1.toString()
            }
            binding.luckyWheel.rotateWheelTo(points!!.toInt())
        }

    }
}