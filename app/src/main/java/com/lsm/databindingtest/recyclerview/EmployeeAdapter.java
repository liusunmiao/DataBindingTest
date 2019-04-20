package com.lsm.databindingtest.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsm.databindingtest.BR;
import com.lsm.databindingtest.R;
import com.lsm.databindingtest.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mListener;
    private List<Worker> mWorkList;

    public interface OnItemClickListener {
        void onItemClickListener(Worker worker);
    }

    public EmployeeAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mWorkList = new ArrayList<>();
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_work_on, viewGroup, false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder bindingViewHolder, int i) {
        final Worker item = mWorkList.get(i);
        ViewDataBinding binding = bindingViewHolder.getBinding();
        binding.setVariable(BR.item, item);
        binding.executePendingBindings();
        bindingViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClickListener(item);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return mWorkList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public void addAll(List<Worker> workers) {
        mWorkList.addAll(workers);
    }

    Random mRandom = new Random(System.currentTimeMillis());

    public void add(Worker worker) {
        int position = mRandom.nextInt(mWorkList.size() +1);
        mWorkList.add(position,worker);
        notifyItemInserted(mWorkList.size());
    }

    public void remove() {
        if (mWorkList.size() == 0) {
            return;
        }
        int position = mRandom.nextInt(mWorkList.size());
        mWorkList.remove(position);
        notifyItemRemoved(position);
    }
}
