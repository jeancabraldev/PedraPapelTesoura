package com.code4line.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Selecionando a opção pedra
    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    //Selecionando papel
    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    //Selecionando tesoura
    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    //Selecionando opção
    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imageResult = findViewById(R.id.imageResult);
        TextView textResult = findViewById(R.id.textResult);
        TextView textResultUser = findViewById(R.id.textResultUser);

        int numero = new Random().nextInt(3);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                imageResult.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResult.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResult.setImageResource(R.drawable.tesoura);
                break;
        }

        //Verificando quem foi o ganhador
        if (
                //Condições para o App vencer
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                        (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ) {

            textResult.setText("Você perdeu, tente novamente");
            textResultUser.setText(escolhaUsuario);

        } else if (
                //Condições para o usuário vencer
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                        (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                        (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ) {
            textResult.setText("Você venceu");
            textResultUser.setText(escolhaUsuario);
        } else {
            textResult.setText("Uauuu, empatamos");
            textResultUser.setText(escolhaUsuario);
        }
    }

}
