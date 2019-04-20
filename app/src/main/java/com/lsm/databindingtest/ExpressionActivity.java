package com.lsm.databindingtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lsm.databindingtest.databinding.ActivityExpressionBinding;

public class ExpressionActivity extends AppCompatActivity {
    private ActivityExpressionBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_expression);
        Employee employee=new Employee("111","3333");
        employee.setAvatar("http://img.tupianzj.com/uploads/allimg/160728/9-160HP91408.jpg");
        binding.setEmployee(employee);
    }
}
