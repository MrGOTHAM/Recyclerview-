package com.example.work.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.work.MainActivity
import com.example.work.MainActivity.Companion.TYPE_1
import com.example.work.MainActivity.Companion.TYPE_2
import com.example.work.MainActivity.Companion.TYPE_3
import com.example.work.MainActivity.Companion.TYPE_4
import com.example.work.R
import com.example.work.holders.*

class RecyclerViewAdater : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    companion object {
        const val ITEM__1 = 0
        const val ITEM__2 = 1
        const val ITEM__3 = 3
        const val HEADER = -1
        const val END = -2
        const val TAG = "this"
    }
    private var needHeader:Boolean = false
    private var myPosition = 0
    private var mContext: Context? = null
    private var itemClickListener: IKotlinClickListener? = null


    private var mDataList = arrayListOf(mutableMapOf<Int, String>())
    private var mHeader: ArrayList<String> = arrayListOf()
    private var mEnd: ArrayList<String> = arrayListOf()




    override fun getItemViewType(position: Int): Int {
        if (needHeader) {

            myPosition = position - mHeader.size
        } else if (!needHeader) {
            myPosition = position
        }

        if (myPosition < 0) {
            return HEADER
        } else if (position == itemCount - 1) {
            return END
        }
        return when {
            mDataList[myPosition][TYPE_1] == "second" -> ITEM__2
            mDataList[myPosition][TYPE_1] == "third" -> ITEM__3
            mDataList[myPosition][TYPE_1] == "first" -> ITEM__1
            else -> -10
        }
    }

    override fun getItemCount(): Int {
        return if (needHeader) {
            mDataList.size + mHeader.size + mEnd.size
        } else {
            mDataList.size + mEnd.size
        }


    }
    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View? = null

        return when (viewType) {
            HEADER -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.holder_header, null, false)
                HolderHeader(view)
            }
            END -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.holder_end, null, false)
                HolderEnd(view)
            }
            ITEM__1 -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.holder_views, null, false)
                HolderOne(view)
            }
            ITEM__2 -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.holder_views, null, false)
                HolderOne(view)
            }
            ITEM__3 -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.holder_views, null, false)
                HolderOne(view)
            }
            else -> {
                HolderOne(view!!)

            }
        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.i(TAG, "执行次数$position")
        when {
            position < mHeader.size && needHeader -> (holder as HolderHeader).textHeader?.text = mHeader[position]

            position == itemCount - mEnd.size -> (holder as HolderEnd).textEnd?.text = mEnd[0]

            mDataList[myPosition][TYPE_1] == "third" -> (holder as HolderOne).textThree?.text =
                mDataList[myPosition][TYPE_2]


            mDataList[myPosition][TYPE_1] == "first" -> {
                (holder as HolderOne).textOne?.text = mDataList[myPosition][TYPE_2]
                (holder ).textTwo?.text = mDataList[myPosition][TYPE_3]
                (holder ).textThree?.text = mDataList[myPosition][TYPE_4]

            }


            mDataList[myPosition][TYPE_1] == "second" -> (holder as HolderOne).textTwo?.text =
                mDataList[myPosition][TYPE_2]
        }
        if ( myPosition >= 0 && myPosition < mDataList.size && needHeader) {
            holder.itemView.setOnClickListener {

                itemClickListener!!.onItemClickListener(position - mHeader.size)

            }
        } else if (!needHeader && myPosition < mDataList.size) {
            holder.itemView.setOnClickListener {
                itemClickListener!!.onItemClickListener(position)
            }
        }
    }
    fun setData(dataList: ArrayList<MutableMap<Int, String>>, context: Context) {
        this.mContext = context
        mDataList.clear()
        this.mDataList = dataList

        notifyDataSetChanged()
    }

    fun setHeader(headerName: String, context: Context) {
        this.mContext = context
        mHeader.clear()
        mHeader.add("新加的头")
        mHeader.add(headerName)
        notifyDataSetChanged()

    }

    fun addEnd() {
        mEnd.clear()
        mEnd.add("这是末尾啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊")
        notifyDataSetChanged()
    }

    fun changeToNoHeader() {
        needHeader = false

        notifyDataSetChanged()
    }

    interface IKotlinClickListener {
        fun onItemClickListener(position: Int)
    }

    fun setOnKotlinItemClickListener(itemClickListener: IKotlinClickListener) {
        this.itemClickListener = itemClickListener
    }
}