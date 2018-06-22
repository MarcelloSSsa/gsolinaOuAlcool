package goua.app.com.gsolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView resultadoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.precoAlcool);
        precoGasolina = findViewById(R.id.precoGasolina);
        botaoVerificar = findViewById(R.id.botaoVerificar);
        resultadoId = findViewById(R.id.resultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                if (textoPrecoAlcool.isEmpty())
                    resultadoId.setText("Preencha com o valor do Alcool!");

                if (textoPrecoGasolina.isEmpty())
                    resultadoId.setText("Preencha com o valor do Gasolina!");

                if (textoPrecoAlcool.isEmpty() && textoPrecoGasolina.isEmpty())
                    resultadoId.setText("Preencha os valores!");

                double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                double result = valorAlcool/valorGasolina;

                if (result >= 0.7){
                    resultadoId.setText("É melhor utilizar a Gasolina, pelo preço de "+valorGasolina+" Reias");
                }else{
                    resultadoId.setText("É melhor utilizar a Alcool, pelo preço de "+valorAlcool+" Reias");
                }
            }
        });
    }
}
