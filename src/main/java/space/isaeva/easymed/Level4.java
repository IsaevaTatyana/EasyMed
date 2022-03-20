package space.isaeva.easymed;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level4 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogend;

    public int numQuest;    // Переменная для определения номера вопроса
    public int numforAnsw;  // Переменная, для подтягивания ответов на вопрос
    public int numCorrAnsw; //Переменная с правильным ответом на вопрос
    Array3 array = new Array3();  // Создали новый объект из класса Array
    Random random = new Random();   // Объект для генерации случайных чисел
    public int count = 0;   //Счетчик правильных ответов

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //create text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level4); // установили текст

        // Путь к вопросу
        final TextView text_question = findViewById(R.id.text_question);

        //Путь к первому ответу
        final TextView text_answer1 = findViewById(R.id.text_answer1);
        //Путь к первому ответу
        final TextView text_answer2 = findViewById(R.id.text_answer2);
        //Путь к первому ответу
        final TextView text_answer3 = findViewById(R.id.text_answer3);
        //Путь к первому ответу
        final TextView text_answer4 = findViewById(R.id.text_answer4);

        //Путь к картинке верно-неверно
        final ImageView image_right_up = (ImageView) findViewById(R.id.image_right_up);

//        final ImageView image_left_up = (ImageView) findViewById(R.id.image_left_up);
//        //скругление углов левой картинки
//        image_left_up.setClipToOutline(true);
//
//        final ImageView image_right_up = (ImageView) findViewById(R.id.image_right_up);
//        //скругление углов правой картинки
//        image_right_up.setClipToOutline(true);
//
//        final ImageView image_left_down = (ImageView) findViewById(R.id.image_left_down);
//        //скругление углов левой картинки
//        image_left_down.setClipToOutline(true);
//
//        final ImageView image_right_down = (ImageView) findViewById(R.id.image_right_down);
//        //скругление углов правой картинки
//        image_right_down.setClipToOutline(true);

        //на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //вызов диалогового окна
        dialog = new Dialog(this); //create new window
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //delete title
        dialog.setContentView(R.layout.previewdialog4);//путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалог. окна
        dialog.setCancelable(false);//нельзя закрыть обычной кнопкой

        //кнопка закрывает диалоговое окно
        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pushing
                try {
                    //back to level chose
                    Intent intent = new Intent(Level4.this, GameLevels.class);
                    startActivity(intent);
                    finish();


                } catch (Exception e) {

                }
                dialog.dismiss(); //close dialog window
            }
        });


        //button "continue"
        Button btncontinue = (Button) dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); //close dialog window
            }
        });


        dialog.show();

        //___________________________________________________________________________________________

        //вызов диалогового окна в конце
        dialogend = new Dialog(this); //create new window
        dialogend.requestWindowFeature(Window.FEATURE_NO_TITLE); //delete tytle
        dialogend.setContentView(R.layout.dialogend4);//путь к макету диалогового окна
        dialogend.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалог. окна
        dialogend.setCancelable(false);//нельзя закрыть обычной кнопкой

        //кнопка закрывает диалоговое окно
        TextView btnclose2 = (TextView) dialogend.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pushing
                try {
                    //back to level chose
                    Intent intent = new Intent(Level4.this, GameLevels.class);
                    startActivity(intent);
                    finish();


                } catch (Exception e) {

                }
                dialogend.dismiss(); //close dialog window
            }
        });


        //button "continue"
        Button btncontinue2 = (Button) dialogend.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level4.this, Level5.class);
                    // здесь вместо Level1.class потом создать Level2.class
                    startActivity(intent);
                    finish();

                } catch (Exception e) {
                }
                dialogend.dismiss(); //close dialog window
            }
        });
        //вставить dialog.show(); где будет выход из уровня

        //_____________________________________________________________________________

        //button Back
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level4.this, GameLevels.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {
                }
            }
        });

        // Массив прогресса игры - начало
        final int [] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
        };
        // Массив прогресса игры - начало

        //Подключение анимации - начало
        final Animation a = AnimationUtils.loadAnimation(Level4.this, R.anim.alpha);
        //Подключение анимации - конец

        numQuest = random.nextInt(10);  // Генерируем случайное число от 0 до 9
        numforAnsw = numQuest * 4;  //Генерируем случайное число для ответов на заданный вопрос
        text_question.setText(array.questions_anat[numQuest]); //Подтягиваем вопрос из массива
        // Подтягиваем из массива ответы на вопрос
        text_answer1.setText(array.answs_anat[numforAnsw]);
        text_answer2.setText(array.answs_anat[numforAnsw + 1]);
        text_answer3.setText(array.answs_anat[numforAnsw + 2]);
        text_answer4.setText(array.answs_anat[numforAnsw + 3]);
        numCorrAnsw = numQuest;     //номер верного ответа

        //Обработка кнопки ответа 1
        text_answer1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    text_answer2.setEnabled(false);
                    text_answer3.setEnabled(false);
                    text_answer4.setEnabled(false);
                    if (array.answs_anat[numforAnsw]==array.correct_answs_anat[numCorrAnsw]) {
                        image_right_up.setImageResource(R.drawable.img_true);
                    } else {
                        image_right_up.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (array.answs_anat[numforAnsw]==array.correct_answs_anat[numCorrAnsw]) {
                        if (count < 10) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_bestgreen);
                        }
                    } else {
                        if (count>0) {
                            if (count==1){
                                count=0;
                            }
                            else {
                                count=count-2;
                            }
                        }
                        for (int i = 0; i < 9; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_bestgreen);
                        }
                    }
                    if (count==10){
                        //EXIT LEVEL
                        dialogend.show();
                    } else {
                        numQuest = random.nextInt(10);  // Генерируем случайное число от 0 до 9
                        numforAnsw = numQuest * 4;  //Генерируем случайное число для ответов на заданный вопрос
                        text_question.setText(array.questions_anat[numQuest]); //Подтягиваем вопрос из массива
                        // Подтягиваем из массива ответы на вопрос
                        text_answer1.setText(array.answs_anat[numforAnsw]);
                        text_answer2.setText(array.answs_anat[numforAnsw + 1]);
                        text_answer3.setText(array.answs_anat[numforAnsw + 2]);
                        text_answer4.setText(array.answs_anat[numforAnsw + 3]);
                        numCorrAnsw = numQuest;     //номер верного ответа

                        image_right_up.setImageResource(R.drawable.img);
                        image_right_up.startAnimation(a);

                        text_answer2.setEnabled(true);
                        text_answer3.setEnabled(true);
                        text_answer4.setEnabled(true);
                    }
                }
                return true;
            }
        });
        // Конец первого ответа

        //Обработка кнопки ответа 2
        text_answer2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    text_answer1.setEnabled(false);
                    text_answer3.setEnabled(false);
                    text_answer4.setEnabled(false);
                    if (array.answs_anat[numforAnsw + 1]==array.correct_answs_anat[numCorrAnsw]) {
                        image_right_up.setImageResource(R.drawable.img_true);
                    } else {
                        image_right_up.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (array.answs_anat[numforAnsw + 1]==array.correct_answs_anat[numCorrAnsw]) {
                        if (count < 10) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_bestgreen);
                        }
                    } else {
                        if (count>0) {
                            if (count==1){
                                count=0;
                            }
                            else {
                                count=count-2;
                            }
                        }
                        for (int i = 0; i < 9; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_bestgreen);
                        }
                    }
                    if (count==10){
                        //EXIT LEVEL
                        dialogend.show();
                    } else {
                        numQuest = random.nextInt(10);  // Генерируем случайное число от 0 до 9
                        numforAnsw = numQuest * 4;  //Генерируем случайное число для ответов на заданный вопрос
                        text_question.setText(array.questions_anat[numQuest]); //Подтягиваем вопрос из массива
                        // Подтягиваем из массива ответы на вопрос
                        text_answer1.setText(array.answs_anat[numforAnsw]);
                        text_answer2.setText(array.answs_anat[numforAnsw + 1]);
                        text_answer3.setText(array.answs_anat[numforAnsw + 2]);
                        text_answer4.setText(array.answs_anat[numforAnsw + 3]);
                        numCorrAnsw = numQuest;     //номер верного ответа

                        image_right_up.setImageResource(R.drawable.img);
                        image_right_up.startAnimation(a);

                        text_answer1.setEnabled(true);
                        text_answer3.setEnabled(true);
                        text_answer4.setEnabled(true);
                    }
                }
                return true;
            }
        });
        // Конец второго ответа

        //Обработка кнопки ответа 3
        text_answer3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    text_answer1.setEnabled(false);
                    text_answer2.setEnabled(false);
                    text_answer4.setEnabled(false);
                    if (array.answs_anat[numforAnsw + 2]==array.correct_answs_anat[numCorrAnsw]) {
                        image_right_up.setImageResource(R.drawable.img_true);
                    } else {
                        image_right_up.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (array.answs_anat[numforAnsw + 2]==array.correct_answs_anat[numCorrAnsw]) {
                        if (count < 10) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_bestgreen);
                        }
                    } else {
                        if (count>0) {
                            if (count==1){
                                count=0;
                            }
                            else {
                                count=count-2;
                            }
                        }
                        for (int i = 0; i < 9; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_bestgreen);
                        }
                    }
                    if (count==10){
                        //EXIT LEVEL
                        dialogend.show();
                    } else {
                        numQuest = random.nextInt(10);  // Генерируем случайное число от 0 до 9
                        numforAnsw = numQuest * 4;  //Генерируем случайное число для ответов на заданный вопрос
                        text_question.setText(array.questions_anat[numQuest]); //Подтягиваем вопрос из массива
                        // Подтягиваем из массива ответы на вопрос
                        text_answer1.setText(array.answs_anat[numforAnsw]);
                        text_answer2.setText(array.answs_anat[numforAnsw + 1]);
                        text_answer3.setText(array.answs_anat[numforAnsw + 2]);
                        text_answer4.setText(array.answs_anat[numforAnsw + 3]);
                        numCorrAnsw = numQuest;     //номер верного ответа

                        image_right_up.setImageResource(R.drawable.img);
                        image_right_up.startAnimation(a);

                        text_answer1.setEnabled(true);
                        text_answer2.setEnabled(true);
                        text_answer4.setEnabled(true);
                    }
                }
                return true;
            }
        });
        // Конец третьего ответа

        //Обработка кнопки ответа 4
        text_answer4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    text_answer1.setEnabled(false);
                    text_answer2.setEnabled(false);
                    text_answer3.setEnabled(false);
                    if (array.answs_anat[numforAnsw + 3]==array.correct_answs_anat[numCorrAnsw]) {
                        image_right_up.setImageResource(R.drawable.img_true);
                    } else {
                        image_right_up.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (array.answs_anat[numforAnsw + 3]==array.correct_answs_anat[numCorrAnsw]) {
                        if (count < 10) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_bestgreen);
                        }
                    } else {
                        if (count>0) {
                            if (count==1){
                                count=0;
                            }
                            else {
                                count=count-2;
                            }
                        }
                        for (int i = 0; i < 9; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_bestgreen);
                        }
                    }
                    if (count==10){
                        //EXIT LEVEL
                        dialogend.show();
                    } else {
                        numQuest = random.nextInt(10);  // Генерируем случайное число от 0 до 9
                        numforAnsw = numQuest * 4;  //Генерируем случайное число для ответов на заданный вопрос
                        text_question.setText(array.questions_anat[numQuest]); //Подтягиваем вопрос из массива
                        // Подтягиваем из массива ответы на вопрос
                        text_answer1.setText(array.answs_anat[numforAnsw]);
                        text_answer2.setText(array.answs_anat[numforAnsw + 1]);
                        text_answer3.setText(array.answs_anat[numforAnsw + 2]);
                        text_answer4.setText(array.answs_anat[numforAnsw + 3]);
                        numCorrAnsw = numQuest;     //номер верного ответа

                        image_right_up.setImageResource(R.drawable.img);
                        image_right_up.startAnimation(a);

                        text_answer1.setEnabled(true);
                        text_answer2.setEnabled(true);
                        text_answer3.setEnabled(true);
                    }
                }
                return true;
            }
        });
        // Конец четвертого ответа

    }

    @Override  //системная кнопка назад
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level4.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

}
