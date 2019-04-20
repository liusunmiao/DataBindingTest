package com.lsm.databindingtest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lsm.databindingtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setClickevent(new ClickEvent());
    }
    public class ClickEvent{
        public void toSimpleActivity(View view){
            startActivity(new Intent(MainActivity.this,SimpleActivity.class));
        }
        public void toListActivity(View view){
            startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
        }
        public void toAttrsActivity(View view){
            startActivity(new Intent(MainActivity.this,ExpressionActivity.class));
        }
        public void toTwoWayActivity(View view){
            startActivity(new Intent(MainActivity.this,TwoWayActivity.class));
        }
        public void toAnimationActivity(View view){
            startActivity(new Intent(MainActivity.this,AnimationActivity.class));
        }
    }
}
