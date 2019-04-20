package com.lsm.databindingtest;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.lsm.databindingtest.databinding.ActivityAnimationBinding;

public class AnimationActivity extends AppCompatActivity {
    private ActivityAnimationBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_animation);

        binding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup viewGroup= (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(viewGroup);
                return true;
            }
        });
        binding.setPersenter(new Persenter());
    }
    public class Persenter{
        public void onCheckedChanged(View buttonView, boolean isChanged){
            binding.setShowImage(isChanged);
        }
    }
}
