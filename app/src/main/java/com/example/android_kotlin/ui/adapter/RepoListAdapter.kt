package com.example.android_kotlin.ui.adapter

import android.content.Context
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin.R
import com.example.android_kotlin.model.Repo
import com.example.android_kotlin.ui.mainTab.repo.TabRepoFragment

import java.util.ArrayList

class RepoListAdapter(private val repoList: List<Repo>,
                      private val clickRepository: OnClickRepository)
    : RecyclerView.Adapter<RepoListAdapter.ViewHolder>(){

    private val TAG = "Repo_List_Adapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = repoList[position]
        holder.bind(repo,clickRepository)
    }

    fun getRepoItem(position: Int): Repo {
        return repoList[position]
    }

    override fun getItemCount(): Int {
        return repoList.size
    }


    fun addItemList(repoList:ArrayList<Repo>){
        Log.d(TAG, "현재 addItemList")

        // 리스트의 항목이 추가될 일이 없어서 우선은 메서드만 생성한 상태
        // 리스트를 추가하는 코드 필요
        notifyDataSetChanged()
    }


    inner class ViewHolder(v: View)
        : RecyclerView.ViewHolder(v){

        val repoName by lazy { v.findViewById(R.id.repoName) as TextView }
        val repoCard by lazy { v.findViewById(R.id.repoCard) as CardView }
        val repoLanguage by lazy { v.findViewById(R.id.repoLanguage) as TextView }

        fun bind (repo : Repo, clickRepository: OnClickRepository) {
            repoName.text = repo.nameRepo
            repoLanguage.text = repo.language
            repoCard.setOnClickListener { clickRepository.onClickRepoItem(repo)}
        }

    }



    // 아이템 추가,수정,삭제
    /*    public ArrayList<RepoListAdapter> deleteItem(int position){
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
