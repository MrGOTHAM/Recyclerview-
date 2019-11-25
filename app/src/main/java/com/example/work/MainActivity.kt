package com.example.work

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.work.adapters.GridViewAdapter
import com.example.work.adapters.RecyclerViewAdater
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TYPE_1 = 1
        const val TYPE_2 = 2
        const val TYPE_3 = 3
        const val TYPE_4 = 4
        const val TYPE_5 = 5
        var changeView = false
    }

    var gridViewAdapter:GridViewAdapter ?= null
    var adapter:RecyclerViewAdater? = null

    private var map = mutableMapOf<Int, String>()
    var mData = arrayListOf(mutableMapOf<Int, String>())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()


    }

    @SuppressLint("WrongConstant")
    fun initView() {

//        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        list_view.layoutManager = manager
//        val adapter = RecyclerViewAdater()
//        adapter.setData(mData, this)
//        list_view.adapter = adapter
//        Log.i("mData的数据：：：：：：：：：：：：", mData.toString())
//        adapter.setHeader("这是表头啊啊啊啊啊啊！", this)
//        adapter.addEnd()
        if_change_view.setOnClickListener {
            Toast.makeText(this, "将要切换布局！", Toast.LENGTH_SHORT).show()
            if (changeView) {
                changeView = false
                val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                list_view.layoutManager = manager

                adapter = RecyclerViewAdater()
                adapter!!.setData(mData, this)
                list_view.adapter = adapter
                adapter?.setHeader("这是表头啊啊啊啊啊啊！", this)
                adapter?.addEnd()
                adapter?.notifyDataSetChanged()
                if_hide_header.setOnClickListener {
                    adapter?.changeToNoHeader()
                }

            } else if (changeView == false) {
                changeView = true
                val manager = GridLayoutManager(this, 3)
                list_view.layoutManager = manager

                gridViewAdapter =GridViewAdapter()
                gridViewAdapter?.setData(mData, this)
                list_view.adapter = gridViewAdapter
                gridViewAdapter?.setHeader("这是表头啊啊啊啊啊啊！", this)
                gridViewAdapter?.addEnd()
                gridViewAdapter?.notifyDataSetChanged()
                if_hide_header.setOnClickListener {
                    gridViewAdapter?.changeToNoHeader()
                }

            }
            if (changeView){
                adapter?.setOnKotlinItemClickListener(object : RecyclerViewAdater.IKotlinClickListener {
                    override fun onItemClickListener(position: Int) {

                        Toast.makeText(applicationContext, mData[position][TYPE_5].toString(), Toast.LENGTH_SHORT).show()
                    }

                })
            }else{

            }

        }


    }

    private fun initData() {

        mData.clear()
        for (i in 0..10) {
            map = mutableMapOf()
            map[TYPE_1] = "first"
            map[TYPE_2] = "安 ${i + 1}"
            map[TYPE_3] = "超 ${i + 1}"
            map[TYPE_4] = "广 ${i + 1}"
            map[TYPE_5] = "模块 ${i + 1}"
            mData.add(map)
        }

        for (i in 0..10) {
            map = mutableMapOf()
            map[TYPE_1] = "second"
            map[TYPE_2] = "1 ${i + 1}"
            map[TYPE_3] = "2 ${i + 1}"
            map[TYPE_4] = "3 ${i + 1}"
            map[TYPE_5] = "模块 ${i + 1}"
            mData.add(map)
        }

        for (i in 0..10) {
            map = mutableMapOf()
            map[TYPE_1] = "third"
            map[TYPE_2] = "4 ${i + 1}"
            map[TYPE_3] = "5 ${i + 1}"
            map[TYPE_4] = "6 ${i + 1}"
            map[TYPE_5] = "模块 ${i + 1}"
            mData.add(map)
        }
    }
}
