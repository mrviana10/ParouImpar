package br.edu.ifsp.scl.sdm.parouimpar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import br.edu.ifsp.scl.sdm.parouimpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Referência para objetos de UI no leiaute
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

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

        // Setando imagem da jogada do computador
        int imagemJogadaComputadoId = -1;
        switch (jogadaComputador) {
            case 0:
                imagemJogadaComputadoId = R.mipmap.zero;
                break;
            case 1:
                imagemJogadaComputadoId = R.mipmap.one;
                break;
            case 2:
                imagemJogadaComputadoId = R.mipmap.two;
                break;
            case 3:
                imagemJogadaComputadoId = R.mipmap.three;
                break;
            case 4:
                imagemJogadaComputadoId = R.mipmap.four;
                break;
            case 5:
                imagemJogadaComputadoId = R.mipmap.five;
                break;
            default:
                break;
        }

        activityMainBinding.jogadaComputadorIv.setImageResource(imagemJogadaComputadoId);

        StringBuilder resultadoSb = new StringBuilder();
        resultadoSb.append("Sua jogada: ");
        resultadoSb.append(jogada);

        resultadoSb.append(", Computador ");
        resultadoSb.append(jogadaComputador);
        resultadoSb.append(", ");

        if (activityMainBinding.opcaoRg.getCheckedRadioButtonId() == R.id.parRB){
            resultadoSb.append((jogada + jogadaComputador) % 2 == 0? "Você GANHOOOOU!" : "Você PERDEU!!");
        }
        else {
            resultadoSb.append((jogada + jogadaComputador) % 2 == 0? "Você Perdeuuuu!" : "Você GANHOU!!");
        }

        activityMainBinding.resultadoTv.setText(resultadoSb.toString());
    }
}