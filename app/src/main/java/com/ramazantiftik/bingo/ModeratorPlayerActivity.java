package com.ramazantiftik.bingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.ramazantiftik.bingo.databinding.ActivityModeratorPlayerBinding;

import java.util.ArrayList;
import java.util.Collections;

public class ModeratorPlayerActivity extends AppCompatActivity {

    private ActivityModeratorPlayerBinding binding;
    ArrayList<Integer> arrayList;
    ArrayList<Integer> arrayList2;
    int count=0;
    int tickCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityModeratorPlayerBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        Intent intent=getIntent();
        arrayList=new ArrayList<>(); // playerList
        arrayList2=new ArrayList<>(); // modList
        for(int i=1;i<=90;i++){
            arrayList2.add(i);
        }
        Collections.shuffle(arrayList2); //mixing
        randomNumbers();
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
            Intent intent=new Intent(ModeratorPlayerActivity.this,InterfaceActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void resetTick(View view){

        tickCount=0;

        binding.number1.setClickable(true);
        binding.number2.setClickable(true);
        binding.number3.setClickable(true);
        binding.number4.setClickable(true);
        binding.number5.setClickable(true);
        binding.number6.setClickable(true);
        binding.number7.setClickable(true);
        binding.number8.setClickable(true);
        binding.number9.setClickable(true);
        binding.number10.setClickable(true);
        binding.number11.setClickable(true);
        binding.number12.setClickable(true);
        binding.number13.setClickable(true);
        binding.number14.setClickable(true);
        binding.number15.setClickable(true);

        binding.number1.setBackgroundResource(R.drawable.elipse);
        binding.number2.setBackgroundResource(R.drawable.elipse);
        binding.number3.setBackgroundResource(R.drawable.elipse);
        binding.number4.setBackgroundResource(R.drawable.elipse);
        binding.number5.setBackgroundResource(R.drawable.elipse);
        binding.number6.setBackgroundResource(R.drawable.elipse);
        binding.number7.setBackgroundResource(R.drawable.elipse);
        binding.number8.setBackgroundResource(R.drawable.elipse);
        binding.number9.setBackgroundResource(R.drawable.elipse);
        binding.number10.setBackgroundResource(R.drawable.elipse);
        binding.number11.setBackgroundResource(R.drawable.elipse);
        binding.number12.setBackgroundResource(R.drawable.elipse);
        binding.number13.setBackgroundResource(R.drawable.elipse);
        binding.number14.setBackgroundResource(R.drawable.elipse);
        binding.number15.setBackgroundResource(R.drawable.elipse);

        Collections.shuffle(arrayList);

        String number1=String.valueOf(arrayList.get(0));
        String number2=String.valueOf(arrayList.get(1));
        String number3=String.valueOf(arrayList.get(2));
        String number4=String.valueOf(arrayList.get(3));
        String number5=String.valueOf(arrayList.get(4));
        String number6=String.valueOf(arrayList.get(5));
        String number7=String.valueOf(arrayList.get(6));
        String number8=String.valueOf(arrayList.get(7));
        String number9=String.valueOf(arrayList.get(8));
        String number10=String.valueOf(arrayList.get(9));
        String number11=String.valueOf(arrayList.get(10));
        String number12=String.valueOf(arrayList.get(11));
        String number13=String.valueOf(arrayList.get(12));
        String number14=String.valueOf(arrayList.get(13));
        String number15=String.valueOf(arrayList.get(14));

        binding.number1.setText(number1);
        binding.number2.setText(number2);
        binding.number3.setText(number3);
        binding.number4.setText(number4);
        binding.number5.setText(number5);
        binding.number6.setText(number6);
        binding.number7.setText(number7);
        binding.number8.setText(number8);
        binding.number9.setText(number9);
        binding.number10.setText(number10);
        binding.number11.setText(number11);
        binding.number12.setText(number12);
        binding.number13.setText(number13);
        binding.number14.setText(number14);
        binding.number15.setText(number15);

    }

    public void getTick(View view){
        String number=String.valueOf(arrayList2.get(count));
        binding.numberView.setText(number);
        count++;
        if(count==90){
            //game done
            binding.getButton.setClickable(false);
            Toast.makeText(ModeratorPlayerActivity.this, "Game Done", Toast.LENGTH_LONG).show();
        }
    }

    public void resetTick2(View view){
        count=0;
        Collections.shuffle(arrayList);
        binding.getButton.setClickable(true);
        Toast.makeText(ModeratorPlayerActivity.this, "Reseted...You can get another number", Toast.LENGTH_LONG).show();
    }

    public void tick(View view){
        //view.setVisibility(View.INVISIBLE);
        view.setClickable(false);
        view.setBackgroundResource(R.drawable.image);
        tickCount++;
        if(tickCount==15){
            MediaPlayer mediaPlayer=MediaPlayer.create(ModeratorPlayerActivity.this,R.raw.sound);
            mediaPlayer.start();
            Snackbar.make(binding.getRoot(),"BINGO!!! Well Done...",Snackbar.LENGTH_INDEFINITE).setAction("Game Over!", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ModeratorPlayerActivity.this,InterfaceActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }).show();
        }
    }

    public void randomNumbers(){

        for(int i=1;i<=90;i++){
            arrayList.add(i);
        }
        Collections.shuffle(arrayList); //mixing

        String number1=String.valueOf(arrayList.get(0));
        String number2=String.valueOf(arrayList.get(1));
        String number3=String.valueOf(arrayList.get(2));
        String number4=String.valueOf(arrayList.get(3));
        String number5=String.valueOf(arrayList.get(4));
        String number6=String.valueOf(arrayList.get(5));
        String number7=String.valueOf(arrayList.get(6));
        String number8=String.valueOf(arrayList.get(7));
        String number9=String.valueOf(arrayList.get(8));
        String number10=String.valueOf(arrayList.get(9));
        String number11=String.valueOf(arrayList.get(10));
        String number12=String.valueOf(arrayList.get(11));
        String number13=String.valueOf(arrayList.get(12));
        String number14=String.valueOf(arrayList.get(13));
        String number15=String.valueOf(arrayList.get(14));

        binding.number1.setText(number1);
        binding.number2.setText(number2);
        binding.number3.setText(number3);
        binding.number4.setText(number4);
        binding.number5.setText(number5);
        binding.number6.setText(number6);
        binding.number7.setText(number7);
        binding.number8.setText(number8);
        binding.number9.setText(number9);
        binding.number10.setText(number10);
        binding.number11.setText(number11);
        binding.number12.setText(number12);
        binding.number13.setText(number13);
        binding.number14.setText(number14);
        binding.number15.setText(number15);

    }

}