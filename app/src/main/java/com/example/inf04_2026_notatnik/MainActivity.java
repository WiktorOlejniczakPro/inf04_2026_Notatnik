package com.example.inf04_2026_notatnik;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button Btn;
    EditText TytNotatki;
    EditText TreNotatki;
    ListView lista;
    List<String> tekst1 = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Btn = findViewById(R.id.Btn);
        TytNotatki = findViewById(R.id.TytNotatki);
        TreNotatki = findViewById(R.id.TreNotatki);
        lista = findViewById(R.id.lista);
        tekst1.add("tennis \nGra z Ewą w poniedziałek");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,tekst1);
        lista.setAdapter(adapter);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekst1.add(TytNotatki.getText()+" \n"+TreNotatki.getText());
                lista.setAdapter(adapter);
            }
        });

        };
    }
