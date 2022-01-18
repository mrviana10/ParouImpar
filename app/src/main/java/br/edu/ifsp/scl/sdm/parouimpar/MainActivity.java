package br.edu.ifsp.scl.sdm.parouimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Referência para objetos de UI no leiaute
    private RadioGroup opcaoRG;
    private Button zeroBt;
    private Button umBt;
    private Button doisBt;
    private Button tresBt;
    private Button quatroBt;
    private Button cincoBt;
    private TextView resultadoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcaoRG = findViewById(R.id.opcaoRg);
        umBt = findViewById(R.id.umBt);
        doisBt = findViewById(R.id.doisBt);
        tresBt = findViewById(R.id.tresBt);
        quatroBt = findViewById(R.id.quatroBt);
        cincoBt = findViewById(R.id.cincoBt);


    }
}