package com.example.android_kotlin.ui.adapter

import android.content.Context
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_kotlin.R
import com.example.android_kotlin.model.Pet

import java.util.ArrayList

class PetListAdapter(var context: Context) : RecyclerView.Adapter<PetListAdapter.ViewHolder>(){

    var petList: ArrayList<Pet> = ArrayList()
    private val TAG = "Pet_List_Adapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        Log.d(TAG, "현재 onCreateViewHolder")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(petList.size>0)
        holder.bind(petList[position],context)
    }

    fun getPetItem(position: Int): Pet {
        return petList[position]
    }

    override fun getItemCount(): Int {
        return petList.size
    }


    fun addItemList(petList:ArrayList<Pet>){
        Log.d(TAG, "현재 addItemList")
        this.petList.addAll(petList)
        notifyDataSetChanged()
    }


    inner class ViewHolder(v: View)
        : RecyclerView.ViewHolder(v){

        val petImage = v.findViewById<ImageView>(R.id.itemPetImage)
        val petName = v.findViewById<TextView>(R.id.itemPetName)
        val petDes = v.findViewById<TextView>(R.id.itemPetDes)

        fun bind (pet : Pet, context: Context) {
            Log.d(TAG, "현재 ViewHolder Bind()")
            if (pet.petImage!= "") {
                Glide.with(context).load(pet.petImage).centerCrop().thumbnail(0.1f).into(petImage)
            }
            else {
                // 이미지가 없을 경우
                // 아직 생각한 이미지 없을 경우 처리 방법이 없음

            }
            petName?.text = pet.petName
            petDes?.text = pet.petDes
        }

    }



    // 아이템 추가,수정,삭제
    /*    public ArrayList<PetListAdapter> deleteItem(int position){
        qnaBoardItems.remove(position);
        notifyItemRemoved(position);
        return qnaBoardItems;
    }
    public ArrayList<QnaBoardItem> deleteItem(QnaBoardItem qnaBoardItem){
        for (int a=0; a<qnaBoardItems.size(); a++){
            if(qnaBoardItems.get(a).getPostNo() == qnaBoardItem.getPostNo()) {
                int position = a;
                qnaBoardItems.remove(position);
                notifyItemRemoved(position);
            }
        }
        *//*qnaBoardItems.remove(position);
        notifyItemRemoved(position);*//*
        return qnaBoardItems;
    }

    public ArrayList<QnaBoardItem> modifyItem(QnaBoardItem qnaBoardItem, int position){
        qnaBoardItems.set(position,qnaBoardItem);
        notifyItemChanged(position,qnaBoardItem);
        return qnaBoardItems;
    }

    public ArrayList<QnaBoardItem> modifyItem(QnaBoardItem modifiedQnaBoardItem){
        for (int a=0; a<qnaBoardItems.size(); a++) {
            if(qnaBoardItems.get(a).getPostNo() == modifiedQnaBoardItem.getPostNo()) {
                int position = a;
                qnaBoardItems.set(position, modifiedQnaBoardItem);
                notifyItemChanged(position, modifiedQnaBoardItem);
            }
        }
        return qnaBoardItems;
    }

    public ArrayList<QnaBoardItem> addItem(QnaBoardItem qnaBoardItem){
       // qnaBoardItems.add(qnaBoardItem); 에러코드 해당 소스코드로 실행 시 배열의 마지막 위치에 추가가 되면서 아이템 위치들이 꼬임
        qnaBoardItems.add(0,qnaBoardItem);
        notifyItemInserted(0);
        //notifyItemInserted(0);
        return qnaBoardItems;
    }*/


}
