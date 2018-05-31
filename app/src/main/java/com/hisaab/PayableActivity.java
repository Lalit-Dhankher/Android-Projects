 package com.hisaab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


 public class PayableActivity extends AppCompatActivity {

    public TextView p2m;
    public TextView p2s;
    public TextView s2m;
    public Button bAdd;
    int m=0;int n=0;int o=0, count=0;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;
    private List<String> list;
     private boolean isFromMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        list = new ArrayList<>();

        setContentView(R.layout.activity_payable);
        p2m = (TextView) findViewById(R.id.textView4);
        p2s = (TextView) findViewById(R.id.textView5);
        s2m = (TextView) findViewById(R.id.textView6);
        bAdd = (Button) findViewById(R.id.bAdd);
        RecyclerView entries = (RecyclerView) findViewById(R.id.entries);
        entries.setLayoutManager(new LinearLayoutManager(this));
        String newentry = intent.getStringExtra("data");
        isFromMainActivity = intent.getBooleanExtra("isFromMainAct",false);


        Log.d( "onCreate: ", String.valueOf(isFromMainActivity));
        if (isFromMainActivity){
            editor.putInt("count" , prefs.getInt("count",0)+1).commit();

            editor.putString(String.valueOf(prefs.getInt("count",0)), newentry).commit();
        }

        for(int i=prefs.getInt("count",0); i>=1; i--){
            Log.d("ss", String.valueOf(i));
            list.add(prefs.getString(String.valueOf(i),"lalit"));
        }

        entries.setAdapter(new EntriesAdapter(list,this));

        m = prefs.getInt("p2m", 0);
        n = prefs.getInt("p2s", 0);
        o = prefs.getInt("s2m", 0);

        int mp = intent.getIntExtra("mp", 0);
        int ml = intent.getIntExtra("ml", 0);
        int ms = intent.getIntExtra("ms", 0);
        int ls = intent.getIntExtra("ls", 0);
        int lm = intent.getIntExtra("lm", 0);
        int sp = intent.getIntExtra("sp", 0);
        int sl = intent.getIntExtra("sl", 0);
        int sm = intent.getIntExtra("sm", 0);
        int ps = intent.getIntExtra("ps", 0);
        int pm = intent.getIntExtra("pm", 0);


        s2m.setText(String.valueOf(ms+o));
        if (ml > 0) {
            int mlp = mp + ml;
            p2m.setText(String.valueOf(mlp+m));
        }else {
            p2m.setText(String.valueOf(mp+m));

        }
        p2s.setText(String.valueOf(ls+n));

        if(ls!=0||lm!=0) {

            p2s.setText(String.valueOf(ls+n));
            p2m.setText(String.valueOf(lm+m));
        }
        if(sp!=0||sl!=0||sm!=0) {

            p2s.setText(String.valueOf(sp+n));

            if (sl > 0) {
                int spl = sp + sl;
                p2s.setText(String.valueOf(spl+n));
            } else {
                p2s.setText(String.valueOf(sp+n));
            }
            s2m.setText(String.valueOf(sm+o));
        }
        if(ps!=0||pm!=0) {
            p2s.setText(String.valueOf(ps+n));
            p2m.setText(String.valueOf(pm+m));
                        }


            m=Integer.parseInt(p2m.getText().toString());
             n=Integer.parseInt(p2s.getText().toString());
             o=Integer.parseInt(s2m .getText().toString());


        editor.putInt("p2m",m);
        editor.putInt("p2s",n);
        editor.putInt("s2m",o);
        editor.apply();

    }


    public void newdata(View v){
        Intent intent = new Intent(PayableActivity.this, MainActivity.class);
        startActivity(intent);


    }

}
