package com.project.recycler.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.recycler.R;

import java.util.ArrayList;
import java.util.Locale;

public class mRecyclerAdapter extends RecyclerView.Adapter<mRecyclerViewHolder> {

//    데이터를 책임질 변수
    private ArrayList<Integer> itemList = new ArrayList<>();

//    뷰홀더 생성 및 어뎁터에 박제!
    @NonNull
    @Override
    public mRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        mRecyclerViewHolder vh = new mRecyclerViewHolder(v);
        return vh;
    }

//    아이템마다 기능 및 데이터 할당
    @Override
    public void onBindViewHolder(@NonNull mRecyclerViewHolder holder, int position) {
        holder.Title.setText(String.format(Locale.getDefault(),"[ %02d ] 번째 아이템", itemList.get(position)));
    }

//    아이템 리스트의 갯수
    @Override
    public int getItemCount() {
        return itemList.size();
    }

//    리스트 자체 변경
    public void setItemList(ArrayList<Integer> list) {
        itemList = list;
    }

//    아이템 추가 및 삭제
    public void addItem(int item) {
        itemList.add(item);
    }
    public void removeItem(int position) {
        itemList.remove(position);
    }
}

//    아이템 하나마다 각각의 뷰홀더를 가짐
class mRecyclerViewHolder extends RecyclerView.ViewHolder {
//    뷰홀더에서 변수 지정

//    타이틀
    public TextView Title;

//    여기서 itemView 변수로 아이템 View를 가져와서 변수에 지정함
    public mRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        Title = (TextView) itemView.findViewById(R.id.itemTitle);
    }
}