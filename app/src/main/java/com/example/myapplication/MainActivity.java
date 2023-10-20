package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ed_name;
    private TextView tv_text,tv_name,tv_winner,tv_mmora,tv_cmora;
    private Button btn_mora;

    private RadioButton btn_scissor,btn_stone,btn_paper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_test);
        tv_name = findViewById(R.id.tv_name);
        tv_winner = findViewById(R.id.tv_winner);
        tv_mmora = findViewById(R.id.tv_mmora);
        tv_cmora = findViewById(R.id.tv_cmora);
        btn_scissor = findViewById(R.id.btn_scissor);
        btn_stone = findViewById(R.id.btn_stone);
        btn_paper = findViewById(R.id.btn_paper);
        btn_mora = findViewById(R.id.btn_mora);

        btn_mora.setOnClickListener(view ->{

            if(ed_name.length()<1) tv_text.setText("輸入玩家姓名");
            else {
                tv_name.setText(String.format("名字\n%S",ed_name.getText().toString()));

                if(btn_scissor.isChecked()){
                    tv_mmora.setText("我方出拳\n剪刀");
                } else if (btn_stone.isChecked()) {
                    tv_mmora.setText("我方出拳\n石頭");
                }else  tv_mmora.setText("我方出拳\n布");

                int computer_rand = (int)(Math.random()*3);

                if(computer_rand == 0) tv_cmora.setText("我方出拳\n剪刀");
                else if (computer_rand == 1) {
                    tv_cmora.setText("我方出拳\n石頭");
                }
                else tv_cmora.setText("我方出拳\n步");

                if((btn_scissor.isChecked()&&computer_rand==2)||(btn_stone.isChecked()&&computer_rand==0)||(btn_paper.isChecked()&&computer_rand==1)){
                    tv_winner.setText("勝利者\n"+ed_name.getText().toString());
                    tv_text.setText("恭喜您獲勝");
                }else if((btn_scissor.isChecked()&&computer_rand==1)||(btn_stone.isChecked()&&computer_rand==2)||(btn_paper.isChecked()&&computer_rand==0)){
                    tv_winner.setText("勝利者\n電腦");
                    tv_text.setText("恭喜您輸了");
                }else {
                    tv_winner.setText("平手");
                    tv_text.setText("平局，再一次");
                }
            }
        });

    }
}