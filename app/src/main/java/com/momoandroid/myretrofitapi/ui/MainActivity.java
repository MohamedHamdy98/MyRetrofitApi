package com.momoandroid.myretrofitapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.momoandroid.myretrofitapi.R;
import com.momoandroid.myretrofitapi.adapter.AdapterRecyclerUsers;
import com.momoandroid.myretrofitapi.databinding.ActivityMainBinding;
import com.momoandroid.myretrofitapi.models.User;
import com.momoandroid.myretrofitapi.viewModel.ViewModelUser;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private AdapterRecyclerUsers adapterRecyclerUsers;
    private ViewModelUser viewModelUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModelUser = ViewModelProviders.of(this).get(ViewModelUser.class);
        viewModelUser.getDataUser();
        mainBinding.recyclerViewUsers.setHasFixedSize(true);
        adapterRecyclerUsers = new AdapterRecyclerUsers();
        mainBinding.recyclerViewUsers.setAdapter(adapterRecyclerUsers);
        viewModelUser.mutableLiveData.observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapterRecyclerUsers.setList(users);
            }
        });
    }
}