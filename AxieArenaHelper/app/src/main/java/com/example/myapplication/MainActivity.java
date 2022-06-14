package com.example.myapplication;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;
import android.support.constraint.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout AnaMenu,
                     NewGameMenu,
                     ExistingGameMenu;

    Button  NewGame, ExistingGame, EndTurn, Reset,
            kartAt_me, kartAt_op;

    TextView Energy_Op, Cards_Op,
             Energy_Me, Cards_Me;

    ImageButton CardPlus_Op, CardMinus_Op,
                CardPlus_Me, CardMinus_Me,
                EnergyPlus_Op, EnergyMinus_Op,
                EnergyPlus_Me, EnergyMinus_Me,
                steal_op, steal_me;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnaMenu = findViewById(R.id.AnaMenu);
        //ExistingGameMenu.findViewById(R.id.);
        NewGameMenu = findViewById(R.id.NewGameMenu);

        Reset = findViewById(R.id.Reset);
        NewGame = findViewById(R.id.NewGame);
        EndTurn = findViewById(R.id.endTurn);
        ExistingGame = findViewById(R.id.existingGame);

        steal_op = findViewById(R.id.steal_op);
        steal_me = findViewById(R.id.steal_me);
        kartAt_me = findViewById(R.id.kartAt_me);
        kartAt_op = findViewById(R.id.kartAt_op);

        Cards_Me = findViewById(R.id.Cards_Me);
        Cards_Op = findViewById(R.id.Cards_Op);
        Energy_Me = findViewById(R.id.Energy_Me);
        Energy_Op = findViewById(R.id.Energy_Op);

        CardPlus_Op = findViewById(R.id.CardPlus_OP);
        CardPlus_Me = findViewById(R.id.CardPlus_Me);
        CardMinus_Me = findViewById(R.id.CardMinus_Me);
        CardMinus_Op = findViewById(R.id.CardMinus_OP);
        EnergyPlus_Op = findViewById(R.id.EnergyPlus_OP);
        EnergyPlus_Me = findViewById(R.id.EnergyPlus_Me);
        EnergyMinus_Op = findViewById(R.id.EnergyMinus_OP);
        EnergyMinus_Me = findViewById(R.id.EnergyMinus_Me);

        AnaMenu.setVisibility(View.GONE);
        NewGameMenu.setVisibility(View.VISIBLE);
        NewGame();
        //AnaMenu();

    }

    protected void AnaMenu(){

        NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnaMenu.setVisibility(View.GONE);
                Energy_Op.setText("3");
                Energy_Me.setText("3");
                Cards_Op.setText("6");
                Cards_Me.setText("6");
                NewGame.setVisibility(View.VISIBLE);
                NewGame();
            }
        });

    }

    int _energy_op = 3, _card_op = 6,
        _energy_me = 3, _card_me = 6;

    protected void NewGame() {

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _energy_op = 3; _card_op = 6;
                _energy_me = 3; _card_me = 6;
                Energy_Me.setText(_energy_me+"");
                Energy_Op.setText(_energy_op+"");
                Cards_Me.setText(_card_me+"");
                Cards_Op.setText(_card_op+"");
            }
        });

        EndTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _energy_op += 2; _card_op += 3;
                _energy_me += 2; _card_me += 3;
                if(_energy_op>=10){_energy_op = 10;}
                if(_energy_me>=10){_energy_me = 10;}
                if(_card_op>=24){_card_op = 24;}
                if(_card_me>=24){_card_me = 24;}
                Energy_Me.setText(_energy_me+"");
                Energy_Op.setText(_energy_op+"");
                Cards_Me.setText(_card_me+"");
                Cards_Op.setText(_card_op+"");
            }
        });

        kartAt_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _card_me -= 1;
                _energy_me -= 1;
                Energy_Me.setText(_energy_me+"");
                Cards_Me.setText(_card_me+"");
            }
        });

        kartAt_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _card_op -= 1;
                _energy_op -= 1;
                Energy_Op.setText(_energy_op+"");
                Cards_Op.setText(_card_op+"");
            }
        });

        steal_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _card_me -= 1;
                _energy_me -= 1;
                if(_energy_op>0){ _energy_me += 1; _energy_op -= 1; }
                Energy_Me.setText(_energy_me+"");
                Energy_Op.setText(_energy_op+"");
                Cards_Me.setText(_card_me+"");
            }
        });

        steal_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 _card_op -= 1;
                _energy_op -= 1;
                if(_energy_me>0){ _energy_op += 1; _energy_me -= 1; }
                Energy_Me.setText(_energy_me+"");
                Energy_Op.setText(_energy_op+"");
                Cards_Op.setText(_card_op+"");
            }
        });

        EnergyPlus_Me.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                _energy_me += 1;
                if(_energy_me>=10){_energy_me = 10;}
                Energy_Me.setText(_energy_me+"");
            }
        });

        EnergyPlus_Op.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                _energy_op += 1;
                if(_energy_op>=10){_energy_op = 10;}
                Energy_Op.setText(_energy_op+"");
            }
        });

        EnergyMinus_Me.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                _energy_me -= 1;
                if(_energy_me<=0){_energy_me = 0;}
                Energy_Me.setText(_energy_me+"");
            }
        });

        EnergyMinus_Op.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                _energy_op -= 1;
                if(_energy_op<=0){_energy_op = 0;}
                Energy_Op.setText(_energy_op+"");
            }
        });

        CardPlus_Me.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                _card_me += 1;
                if(_card_me>=24){_card_me = 24;}
                Cards_Me.setText(_card_me+"");
            }
        });

        CardPlus_Op.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                _card_op += 1;
                 if(_card_op>=24){_card_op = 24;}
                Cards_Op.setText(_card_op+"");
            }
        });

        CardMinus_Me.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                _card_me -= 1;
                if(_card_me<=0){_card_me = 0;}
                Cards_Me.setText(_card_me+"");
            }
        });

        CardMinus_Op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _card_op -= 1;
                if(_card_op<=0){_card_op = 0;}
                Cards_Op.setText(_card_op+"");
            }
        });

    }

}