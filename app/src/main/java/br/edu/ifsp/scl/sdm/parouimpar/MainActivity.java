package br.edu.ifsp.scl.sdm.parouimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

import br.edu.ifsp.scl.sdm.parouimpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Referência para objetos de UI no leiaute
    private ActivityMainBinding activityMainBinding;

    //private RadioGroup opcaoRG;
    //private Button zeroBt;
    //private Button umBt;
    //private Button doisBt;
    //private Button tresBt;
    //private Button quatroBt;
    //private Button cincoBt;
    //private TextView resultadoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        //opcaoRG = findViewById(R.id.opcaoRg);
        //zeroBt =findViewById(R.id.zeroBt);
        //umBt = findViewById(R.id.umBt);
        //doisBt = findViewById(R.id.doisBt);
        //tresBt = findViewById(R.id.tresBt);
        //quatroBt = findViewById(R.id.quatroBt);
        //cincoBt = findViewById(R.id.cincoBt);
        //resultadoTv = findViewById(R.id.resultadoTv);

        activityMainBinding.zeroBt.setOnClickListener(this);
        activityMainBinding.umBt.setOnClickListener(this);
        activityMainBinding.doisBt.setOnClickListener(this);
        activityMainBinding.tresBt.setOnClickListener(this);
        activityMainBinding.quatroBt.setOnClickListener(this);
        activityMainBinding.cincoBt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int jogada = -1;
        switch (view.getId()) {
            case R.id.zeroBt:
                jogada = 0;
                break;
            case R.id. umBt:
                jogada = 1;
                break;
            case R.id. doisBt:
                jogada = 2;
                break;
            case R.id. tresBt:
                jogada = 3;
                break;
            case R.id. quatroBt:
                jogada = 4;
                break;
            case R.id. cincoBt:
                jogada = 5;
                break;
            default:
                break;
        }
        jogarParouImpar(jogada);
    }
    private void jogarParouImpar(int jogada) {
        Random random = new Random(System.currentTimeMillis());
        int jogadaComputador = random.nextInt(6);

        StringBuilder resultadoSb = new StringBuilder();
        resultadoSb.append("Sua jogada: ");
        resultadoSb.append(jogada);

        resultadoSb.append(", Computador ");
        resultadoSb.append(jogadaComputador);
        resultadoSb.append(", ");

        if (activityMainBinding.opcaoRg.getCheckedRadioButtonId() == R.id.parRB){
            resultadoSb.append((jogada + jogadaComputador) % 2 == 0? "Você GANHOU!" : "Você PERDEU!!");
        }
        else {
            resultadoSb.append((jogada + jogadaComputador) % 2 == 0? "Você Perdeu!" : "Você GANHOU!!");
        }

        activityMainBinding.resultadoTv.setText(resultadoSb.toString());
    }
}