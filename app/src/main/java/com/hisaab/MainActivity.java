package com.hisaab;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText etAmount;
    private RadioButton rbMani;
    private RadioButton rbPani;
    private RadioButton rbLali;
    private RadioButton rbSani;
    private CheckBox cbManinder;
    private CheckBox cbPawan;
    private CheckBox cbLalit;
    private CheckBox cbSandeep;
    int count = 0;
    int amount= 0;
    private Button bSave;
    private boolean isManinderSelected = false, isPawanSelected = false, isLalitSelected = false, isSandeepSelected = false;
    private boolean isManiSelected = false, isPaniSelected = false, isLaliSelected = false, isSaniSelected = false;
    private int rupee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = (EditText) findViewById(R.id.etAmount);
        rbMani = (RadioButton) findViewById(R.id.rbMani);
        rbPani = (RadioButton) findViewById(R.id.rbPani);
        rbLali = (RadioButton) findViewById(R.id.rbLali);
        rbSani = (RadioButton) findViewById(R.id.rbSani);
        cbManinder = (CheckBox) findViewById(R.id.cbManinder);
        cbPawan = (CheckBox) findViewById(R.id.cbPawan);
        cbLalit = (CheckBox) findViewById(R.id.cbLalit);
        cbSandeep = (CheckBox) findViewById(R.id.cbSandeep);
        bSave = (Button) findViewById(R.id.bAdd);




        cbManinder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isManinderSelected = isChecked;
            }
        });
        cbLalit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isLalitSelected = isChecked;
            }
        });
        cbSandeep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isSandeepSelected = isChecked;
            }
        });
        cbPawan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isPawanSelected = isChecked;
            }
        });

        rbPani.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isPaniSelected = isChecked;
            }
        });
        rbMani.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isManiSelected = isChecked;
            }
        });
        rbLali.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isLaliSelected = isChecked;
            }
        });
        rbSani.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isSaniSelected = isChecked;
            }
        });



    }

    public void save(View v) {
        Intent intent = new Intent(MainActivity.this, PayableActivity.class);
        String entry = balance();
        intent.putExtra("data", entry);
        intent.putExtra("isFromMainAct", true);
        perhead();


        if (isManiSelected || isPaniSelected || isLaliSelected || isSaniSelected ) {

            if (count > 1) {

                if (isManiSelected) {
                    if (amount != 0) {
                        if (isPawanSelected) {
                            intent.putExtra("mp", rupee);
                        }
                        if (isLalitSelected) {
                            intent.putExtra("ml", rupee);
                        }
                        if (isSandeepSelected) {
                            intent.putExtra("ms", rupee);
                        }

                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Amount must not be Zero", Toast.LENGTH_SHORT).show();
                    }


                } else if (isLaliSelected) {
                    if (amount != 0) {
                        if (isSandeepSelected) {
                            rupee = rupee - 2 * rupee;
                            intent.putExtra("ls", rupee);
                            rupee = -rupee;
                        }
                        if (isManinderSelected) {
                            rupee = rupee - 2 * rupee;
                            intent.putExtra("lm", rupee);
                            rupee = -rupee;
                        }

                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Amount must not be Zero", Toast.LENGTH_SHORT).show();
                    }

                } else if (isSaniSelected) {
                    if (amount != 0) {
                        if (isPawanSelected) {
                            intent.putExtra("sp", rupee);
                        }
                        if (isLalitSelected) {
                            intent.putExtra("sl", rupee);
                        }
                        if (isManinderSelected) {
                            rupee = rupee - 2 * rupee;
                            intent.putExtra("sm", rupee);
                        }

                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Amount must not be Zero", Toast.LENGTH_SHORT).show();
                    }

                } else if (isPaniSelected) {
                    if (amount != 0) {
                        if (isSandeepSelected) {
                            rupee = rupee - 2 * rupee;
                            intent.putExtra("ps", rupee);
                            rupee = -rupee;
                        }
                        if (isManinderSelected) {
                            rupee = rupee - 2 * rupee;
                            intent.putExtra("pm", rupee);
                            rupee = -rupee;

                        }
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Amount must not be Zero", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        else {
            Toast.makeText(this, "Payer is not selected", Toast.LENGTH_SHORT).show();
        }
    }






    private void perhead() {
        if (isManinderSelected == true) {
            count = count + 1;
        }
        if (isPawanSelected == true) {
            count = count + 1;
        }

        if (isSandeepSelected == true) {
            count = count + 1;
        }
        if (isLalitSelected == true) {
            count = count + 1;
        }if(isManinderSelected==false && isPawanSelected==false && isLalitSelected==false && isSandeepSelected==false) {
            Toast.makeText(this,"Payed to is not selected",Toast.LENGTH_SHORT).show();
            count=1;
        }

         amount = Integer.parseInt(etAmount.getText().toString());


        rupee = amount / count;
    }


    public String balance(){
        String paid_via = null;
        String paid2m="";
        String paid2p="";
        String paid2l="";
        String paid2s="";


        if(isManiSelected){

            paid_via= "M ";

            if(isManinderSelected){
                paid2m = " M";
            }if(isPawanSelected){
                paid2p = "P";
            }
            if(isLalitSelected) {
                paid2l = "L";
            }
            if(isSandeepSelected) {
                paid2s = "S";
            }

        }else if(isPaniSelected){

            paid_via= "P ";

            if(isManinderSelected){
                paid2m = " M";
            }if(isPawanSelected){
                paid2p = "P";
            }
            if(isLalitSelected) {
                paid2l = "L";
            }
            if(isSandeepSelected) {
                paid2s = "S";
            }

        }else if(isLaliSelected){

            paid_via= "L ";

            if(isManinderSelected){
                paid2m = " M";
            }if(isPawanSelected){
                paid2p = "P";
            }
            if(isLalitSelected) {
                paid2l = "L";
            }
            if(isSandeepSelected) {
                paid2s = "S";
            }

        }else if(isSaniSelected){

            paid_via= "S ";

            if(isManinderSelected){
                paid2m = " M";
            }if(isPawanSelected){
                paid2p = "P";
            }
            if(isLalitSelected) {
                paid2l = "L";
            }
            if(isSandeepSelected) {
                paid2s = "S";
            }

        }
        int amount = Integer.parseInt(etAmount.getText().toString());
        return paid_via +" "+ amount+" "+ paid2m + paid2p + paid2l +paid2s;
    }



}

