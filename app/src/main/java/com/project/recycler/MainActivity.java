package com.project.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.recycler.Adapter.mRecyclerAdapter;

import java.util.ArrayList;

/**
* 프로젝트 시작하기 전에 App단의 Build.gradle 에서
* implementation "androidx.recyclerview:recyclerview:1.1.0"
* 를 먼저 해야함
* */

public class MainActivity extends AppCompatActivity {

    private mRecyclerAdapter adapter;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        뷰 초기화
        initView();

//        어뎁터 아이템 추가
        adapter.setItemList(generateItem(10));

//        이런식으로 추가
//        adapter.addItem(11);
//        및 제거가능
//        adapter.removeItem(11);

//        리스트에 추후 아이템을 추가하면 해당 메소드를 호출하여 데이터변경을 알림
//        adapter.notifyDataSetChanged();

    }

    private void initView() {
//        어뎁터랑 어댑터의 레이아웃의 형태를 책임지는 레이아웃매니저 생성
        adapter = new mRecyclerAdapter();
//        LayoutManager.Vertical = 세로
//        LayoutManager.Horizontal = 가로
//        그뒤에 false 는 true로바꾸면 거꾸로됨
        lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

//        리사이클러뷰 초기화 및 어뎁터와 레이아웃매니저 할당
        recyclerView = findViewById(R.id.itemRecyclerView);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }

//    더미아이템 생성
    private ArrayList<Integer> generateItem(int amount) {
        ArrayList<Integer> tempList = new ArrayList<>();

        for (int i=0; i<amount; i++) {
            tempList.add(i);
        }

        return tempList;
    }
}