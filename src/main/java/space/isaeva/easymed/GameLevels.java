 package space.isaeva.easymed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button buttonBack = (Button)findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //back to menu
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });


        // кнопка для перехода на первый уровень - начало
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level1.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //empty
                }
            }
        });
        // кнопка для перехода на первый уровень - end




        // кнопка для перехода на 2 уровень - начало
        TextView textView2 = (TextView)findViewById(R.id.textView6);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //empty
                }
            }
        });
        // кнопка для перехода на первый уровень - end




        // кнопка для перехода на 3 уровень - начало
        TextView textView3 = (TextView)findViewById(R.id.textView11);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level3.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //empty
                }
            }
        });
        // кнопка для перехода на первый уровень - end





        // кнопка для перехода на 4 уровень - начало
        TextView textView4 = (TextView)findViewById(R.id.textView16);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level4.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //empty
                }
            }
        });
        // кнопка для перехода на первый уровень - end





        // кнопка для перехода на 5 уровень - начало
        TextView textView5 = (TextView)findViewById(R.id.textView17);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level5.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //empty
                }
            }
        });
        // кнопка для перехода на первый уровень - end




    }
    //системная кнопка назад - начало
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent); finish();
        }catch (Exception e){

        }
    }

    //системная кнопка назад - конец

}