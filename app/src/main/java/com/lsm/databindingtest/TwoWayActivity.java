package com.lsm.databindingtest;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lsm.databindingtest.databinding.ActivityTwoWayBinding;

public class TwoWayActivity extends AppCompatActivity {
    private ActivityTwoWayBinding binding;
    private FormModel formmodel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_two_way);

        formmodel=new FormModel("111","222");
        binding.setFormmodel(formmodel);
        binding.setCommitFrom(new CommitFrom());
        formmodel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                //监听发送改变

            }
        });
    }
    public class CommitFrom{
        public void commitFrom(View view){
            Toast.makeText(TwoWayActivity.this,formmodel.getUserName()+"----"+formmodel.getPassWord(),Toast.LENGTH_LONG).show();
        }
    }
}
