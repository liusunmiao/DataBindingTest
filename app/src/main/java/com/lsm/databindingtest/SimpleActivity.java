package com.lsm.databindingtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lsm.databindingtest.databinding.ActivitySimpleBinding;

public class SimpleActivity extends AppCompatActivity {
    private ActivitySimpleBinding binding;
    private Employee employee = new Employee("Zhai", "Mark");
    private Worker worker = new Worker("1111", "2222");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple);
        //通过直接赋值
//        binding.firstName.setText(employee.getFirstName());
//        binding.lastName.setText(employee.getLastName());

//        binding.setEmployee(employee);
        binding.setVariable(BR.employee, employee);
        binding.setEventlistener(new EventListener());
        //viewStub
        binding.viewStub.getViewStub().inflate();

        binding.setWorker(worker);

    }

    public class EventListener {
        public void onTextChanged(CharSequence s, int start, int befor, int count) {
            employee.setFirstName(s.toString());
            binding.setEmployee(employee);
        }

        public void clickFirst(View view) {
            worker.setFirstName("55555");
            worker.setLastName("7777777");
            Toast.makeText(SimpleActivity.this, "点击了并刷新worker对象的值", Toast.LENGTH_LONG).show();
        }

        public void onClickListenerBinding(Employee employee) {
            employee.setLastName("999999");
            Toast.makeText(SimpleActivity.this, employee.getLastName(), Toast.LENGTH_LONG).show();

        }

        public boolean onLongClick(View view) {
            Toast.makeText(SimpleActivity.this, "长按了", Toast.LENGTH_LONG).show();
            return false;
        }
        public void btnClick(View view){
            Toast.makeText(SimpleActivity.this, "监听器方式", Toast.LENGTH_LONG).show();
        }
    }
}
