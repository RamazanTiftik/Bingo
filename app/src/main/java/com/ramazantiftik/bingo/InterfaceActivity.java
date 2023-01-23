package com.ramazantiftik.bingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ramazantiftik.bingo.databinding.ActivityMainBinding;

public class InterfaceActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        Intent intent=getIntent();
    }

    public void playerTick(View view){
        Intent intent=new Intent(InterfaceActivity.this,BingoActivity.class);
        startActivity(intent);
    }

    public void moderatorTick(View view){
        Intent intent=new Intent(InterfaceActivity.this,ModeratorActivity.class);
        startActivity(intent);
    }

    public void moderatorPlayerTick(View view){
        Intent intent=new Intent(InterfaceActivity.this,ModeratorPlayerActivity.class);
        startActivity(intent);
    }

}