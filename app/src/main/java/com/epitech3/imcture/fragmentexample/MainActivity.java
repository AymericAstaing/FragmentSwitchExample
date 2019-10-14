package com.epitech3.imcture.fragmentexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentA f1;
    FragmentB f2;
    FrameLayout fragment_container;
    FragmentManager fm;
    Button f1_btn, f2_btn;
    private final int F1 = 0;
    private final int F2 = 1;

    public int FRAGMENT_CURSOR = F1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create_fragment_instances(); // on créé les instances des fragments
        init_widgets();
        load_initial_fragment();
    }

    public void init_widgets() {
        f1_btn = findViewById(R.id.f1_btn);
        f2_btn = findViewById(R.id.f2_btn);
        f1_btn.setOnClickListener(this);
        f2_btn.setOnClickListener(this);
    }

    public void create_fragment_instances() {
        fragment_container = findViewById(R.id.fragment_container);
        f1 = new FragmentA();
        f2 = new FragmentB();
    }

    public void load_initial_fragment() {
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, f1);
        fragmentTransaction.commit();
        FRAGMENT_CURSOR = F1;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.f1_btn) {
            if (FRAGMENT_CURSOR != F1) {
                fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commit();
                FRAGMENT_CURSOR = F1;
            }
            return;
        }
        if (view.getId() == R.id.f2_btn) {
            if (FRAGMENT_CURSOR != F2) {
                fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, f2);
                fragmentTransaction.commit();
                FRAGMENT_CURSOR = F2;
            }
        }
    }
}
