package com.lsm.databindingtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.lsm.databindingtest.databinding.ActivityRecyclerviewBinding;
import com.lsm.databindingtest.recyclerview.EmployeeAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private ActivityRecyclerviewBinding binding;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new EmployeeAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new EmployeeAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(Worker worker) {
                Toast.makeText(RecyclerViewActivity.this, worker.getFirstName() + "--" + worker.getLastName(), Toast.LENGTH_LONG).show();
            }
        });
        binding.setControllrecyclerview(new ControllRecyclerView());
        List<Worker> demoList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker("Zhai", "Mark");
            demoList.add(worker);
        }
        adapter.addAll(demoList);
    }

    public class ControllRecyclerView {
        public void addItem(View view) {
            Worker worker = new Worker("1111", "11111");
            adapter.add(worker);
        }

        public void removeItem(View view) {
            adapter.remove();
        }
    }
}
