package com.ramazantiftik.bingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ramazantiftik.bingo.databinding.ActivityModeratorBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ModeratorActivity extends AppCompatActivity {

    private ActivityModeratorBinding binding;
    ArrayList<Integer> arrayList;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityModeratorBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        Intent intent=getIntent();
        arrayList=new ArrayList<>();
        for(int i=1;i<=90;i++){
            arrayList.add(i);
        }
        Collections.shuffle(arrayList); //mixing

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.backToHome){
            Intent intent=new Intent(ModeratorActivity.this,InterfaceActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void resetTick(View view){
        count=0;
        Collections.shuffle(arrayList);
        binding.getTick.setClickable(true);
        Toast.makeText(ModeratorActivity.this, "Reseted...You can get another number", Toast.LENGTH_LONG).show();
    }

    public void getTick(View view){
        String number=String.valueOf(arrayList.get(count));
        binding.numberView.setText(number);
        count++;
        if(count==90){
            //game over
            binding.getTick.setClickable(false);
            Toast.makeText(ModeratorActivity.this, "Game Over", Toast.LENGTH_LONG).show();
        }
    }



}