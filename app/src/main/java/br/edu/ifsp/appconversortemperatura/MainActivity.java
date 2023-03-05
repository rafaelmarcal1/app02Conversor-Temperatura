package br.edu.ifsp.appconversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Variaveis privadas para os elementos do Layout... quer dizer "Laioute"
    private EditText valorEditText;
    private Button converterCelsius;
    private Button converterFahrenheit;
    private Button converterKelvin;
    private Button converterKelvinF;
    private TextView valorConvertido;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando elementos do Laioute pelo ID
        valorEditText = findViewById(R.id.editext_value);
        converterCelsius = findViewById(R.id.botao_converter_celsius);
        converterCelsius.setOnClickListener(this);
        converterFahrenheit = findViewById(R.id.botao_converter_ferenheit);
        converterFahrenheit.setOnClickListener(this);
        converterKelvin = findViewById(R.id.botao_converter_kelvin);
        converterKelvin.setOnClickListener(this);
        converterKelvinF = findViewById(R.id.botao_converter_kelvinF);
        converterKelvinF.setOnClickListener(this);
        valorConvertido = findViewById(R.id.textview_value_converted);
    }

    //Chama Funções na View
    @Override
    public void onClick(View view) {
        if(view == converterCelsius){
            getCelsiusConvertion();
        }
        if(view == converterFahrenheit){
            getFahrenheitConvertion();
        }
        if (view == converterKelvin){
            getKelvinConvertionC();
        }
        if (view == converterKelvinF){
            getKelvinConvertionF();
        }
    }

    //Convertendo Fa
    private void getKelvinConvertionF() {
    }

    //Fazendo tratamento de exceção
    private double pegaValor() {
        double valor;
        String valorString;

        valorString = valorEditText.getText().toString(); //Pega o valor e transforma pra String

        try {
            valor = Double.valueOf(valorString);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Valor digitado é inválido!", Toast.LENGTH_SHORT).show();
            valor = 0;
        }
        return valor;
    }

    //Função que converte o valor de Ferenheit pra Celsius
    private void getCelsiusConvertion() {
        double valor = pegaValor();

        valor = (valor-32)*5/9;

        valorConvertido.setText(String.format("%.2f °C", valor));
    }

    //Função que converte o valor de Celsius para Fahrenheit
    private void getFahrenheitConvertion() {
        double valor = pegaValor();

        valor = valor * 1.8 + 32;

        valorConvertido.setText(String.format("%.2f °F",valor));
    }

    //Converter Celsius para Kelvin
    private void getKelvinConvertionC() {
        double valor = pegaValor();

        valor = valor + 273.15;

        valorConvertido.setText(String.format("%.2f °F",valor));
    }
}