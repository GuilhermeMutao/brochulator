package treinamento.com.calculadora

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtOperacaoInserida: TextView
    private lateinit var txtOperacaoRealizada: TextView
    private var resultConta: Int = 0;
    private lateinit var lastOperator: String;
    private var numeroSecundarioInserido: Int = 0;
    private var jaClicado: Boolean = false;
    private var auxiliarNumero: Int = 0;
    private var resultExist: Boolean = false;
    private var jaCalculado: Boolean = false;
    private var primeiraEntrada: Boolean = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.txtOperacaoInserida = findViewById(R.id.txtResult)
        this.txtOperacaoRealizada = findViewById(R.id.txtExpressao)

        supportActionBar?.hide();
    }

    fun setNumber(view: View) {

        if (resultExist == true) {
            limparText();
            resultExist = false;
        }

        when (view.id) {
            R.id.numberOne ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "1";
            R.id.numberTwo ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "2";
            R.id.numberThree ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "3";
            R.id.numberFour ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "4";
            R.id.numberFive ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "5";
            R.id.numberSix ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "6";
            R.id.numberSeven ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "7";
            R.id.numberEight ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "8";
            R.id.numberNine ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "9";
            R.id.numberZero ->
                txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "0";
        }
    }

    fun setOperator(view: View) {

        try{
        if (resultExist == false) {
            resultExist = true;
        }

        when (view.id) {
            R.id.btnLimpar -> {
                encerrarCalculo();
            }
            R.id.equal -> {
                calcular(lastOperator)
            }
            R.id.dot ->{
                if (txtOperacaoInserida.length() == 0) {
                    txtOperacaoInserida.text = txtOperacaoInserida.text.toString() + "0.";
                }

            }
            R.id.delete ->{
                Log.d("r", "sda");
                if (txtOperacaoInserida.length() > 0) {
                    txtOperacaoInserida.text = txtOperacaoInserida.text.toString().substring(0, txtOperacaoInserida.length() - 1);
                }
            }
            R.id.numberPlus -> {
                if (!jaCalculado) {
                    auxiliarNumero = txtOperacaoInserida.text.toString().toInt();
                    txtOperacaoRealizada.text = auxiliarNumero.toString() + "+";
                    jaCalculado = true;
                }else{
                    jaClicado = false;
                }

                txtOperacaoInserida.text = resultConta.toString();

                lastOperator = "+";
            }
            R.id.numberMinus -> {
                if (!jaCalculado) {
                    auxiliarNumero = txtOperacaoInserida.text.toString().toInt();
                    txtOperacaoRealizada.text = auxiliarNumero.toString() + "-";
                    jaCalculado = true;
                }else{
                    jaClicado = false;
                }

                txtOperacaoInserida.text = resultConta.toString();

                lastOperator = "-";
            }
            R.id.numberMutiplication -> {
                if (!jaCalculado) {
                    auxiliarNumero = txtOperacaoInserida.text.toString().toInt();
                    txtOperacaoRealizada.text = auxiliarNumero.toString() + "-";
                    jaCalculado = true;
                }else{
                    jaClicado = false;
                }

                txtOperacaoInserida.text = resultConta.toString();

                lastOperator = "*";
            }
            R.id.btnDivisao ->{
                if (!jaCalculado) {
                    auxiliarNumero = txtOperacaoInserida.text.toString().toInt();
                    txtOperacaoRealizada.text = auxiliarNumero.toString() + "/";
                    jaCalculado = true;
                }else{
                    jaClicado = false;
                }

                txtOperacaoInserida.text = resultConta.toString();

                lastOperator = "/";
            }
        }
    }catch (e: Exception){
        Log.d("EXCEPTION", e.toString());
    }

    }

    fun encerrarCalculo() {
        txtOperacaoInserida.text = "";
        txtOperacaoRealizada.text = "";
        resultConta = 0;
        lastOperator = "";
        numeroSecundarioInserido = 0;
        resultExist = false;
        jaCalculado = false;
        jaClicado = false;
        primeiraEntrada = true;
        auxiliarNumero = 0;
    }



    private fun calcular(lastOperator: String) {
        try {
            when (lastOperator) {
                "+" -> {
                    if(!jaClicado){
                        numeroSecundarioInserido = txtOperacaoInserida.text.toString().toInt();

                        resultConta = auxiliarNumero + txtOperacaoInserida.text.toString().toInt();
                        txtOperacaoRealizada.text = auxiliarNumero.toString() + " + " + numeroSecundarioInserido.toString();
                        txtOperacaoInserida.text = resultConta.toString();
                        jaClicado = true;
                    }else{
                        resultConta += numeroSecundarioInserido;
                        txtOperacaoRealizada.text = txtOperacaoInserida.text.toString() + " + " + numeroSecundarioInserido.toString();
                        txtOperacaoInserida.text = resultConta.toString();
                    }
                }
                "-" -> {
                    if(!jaClicado){
                        numeroSecundarioInserido = txtOperacaoInserida.text.toString().toInt();

                        resultConta = auxiliarNumero - txtOperacaoInserida.text.toString().toInt();
                        txtOperacaoRealizada.text = auxiliarNumero.toString() + " - " + numeroSecundarioInserido.toString();
                        txtOperacaoInserida.text = resultConta.toString();
                        jaClicado = true;
                    }else{
                        resultConta -= numeroSecundarioInserido;
                        txtOperacaoRealizada.text = txtOperacaoInserida.text.toString() + " - " + numeroSecundarioInserido.toString();
                        txtOperacaoInserida.text = resultConta.toString();
                    }
                };
                "*" -> {
                    if(!jaClicado){
                        numeroSecundarioInserido = txtOperacaoInserida.text.toString().toInt();

                        resultConta = auxiliarNumero * txtOperacaoInserida.text.toString().toInt();
                        txtOperacaoRealizada.text = auxiliarNumero.toString() + " * " + numeroSecundarioInserido.toString();
                        txtOperacaoInserida.text = resultConta.toString();
                        jaClicado = true;
                    }else{
                        resultConta *= numeroSecundarioInserido;
                        txtOperacaoRealizada.text = txtOperacaoInserida.text.toString() + " * " + numeroSecundarioInserido.toString();
                        txtOperacaoInserida.text = resultConta.toString();
                    }
                };
                "/" -> {
                    if(!jaClicado){
                        numeroSecundarioInserido = txtOperacaoInserida.text.toString().toInt();

                        resultConta = auxiliarNumero / txtOperacaoInserida.text.toString().toInt();
                        txtOperacaoRealizada.text = auxiliarNumero.toString() + " / " + numeroSecundarioInserido.toString();
                        txtOperacaoInserida.text = resultConta.toString();
                        jaClicado = true;
                    }else{
                        resultConta /= numeroSecundarioInserido;
                        txtOperacaoRealizada.text = txtOperacaoInserida.text.toString() + " / " + numeroSecundarioInserido.toString();
                        txtOperacaoInserida.text = resultConta.toString();
                    }
                };
            }
        }catch (e: Exception){
            Log.d("EXCEPTION", e.toString());
        }

    }

    fun limparText() {
        txtOperacaoInserida.text = "";
    }


}

