package br.edu.ifsp.appconversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextView valorConvertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando elementos do Laioute pelo ID
        valorEditText = findViewById(R.id.editext_value);
        converterCelsius = findViewById(R.id.botao_converter_celsius);
        converterCelsius.setOnClickListener(this);
        valorConvertido = findViewById(R.id.textview_value_converted);
    }

    //Chama Função na View
    @Override
    public void onClick(View view) {
        if(view == converterCelsius){
            getCelsiusConvertion();
        }
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
}










