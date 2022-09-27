package treinamento.com.calculadora

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtResult: TextView
    private lateinit var txtExpressao: TextView
    private var resultConta : Int = 0;
    private lateinit var lastOperator : String;
    private var oneNumber : Int = 0;
    private var resultExist : Boolean = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.txtResult = findViewById(R.id.txtResult)
        this.txtExpressao = findViewById(R.id.txtExpressao)

        supportActionBar?.hide();
    }

    fun setNumber(view: View) {

        if(resultExist == true){
            limparText();
            resultExist = false;
        }

        val botao = view as Button
        when (view.id) {
            R.id.numberOne ->
                txtResult.text = txtResult.text.toString() + "1";
            R.id.numberTwo ->
                txtResult.text = txtResult.text.toString() + "2";
            R.id.numberThree ->
                txtResult.text = txtResult.text.toString() + "3";
            R.id.numberFour ->
                txtResult.text = txtResult.text.toString() + "4";
            R.id.numberFive ->
                txtResult.text = txtResult.text.toString() + "5";
            R.id.numberSix ->
                txtResult.text = txtResult.text.toString() + "6";
            R.id.numberSeven ->
                txtResult.text = txtResult.text.toString() + "7";
            R.id.numberEight ->
                txtResult.text = txtResult.text.toString() + "8";
            R.id.numberNine ->
                txtResult.text = txtResult.text.toString() + "9";
            R.id.numberZero ->
                txtResult.text = txtResult.text.toString() + "0";
        }
    }

    fun setOperator(view: View){
        oneNumber = txtResult.text.toString().toInt();

        if(resultExist == false){
            resultExist = true;
        }

        when (view.id) {
            R.id.btnLimpar -> {
                limparText();
            }
            R.id.equal ->{
                calcular(lastOperator);
            }
            R.id.numberPlus ->{
                resultConta += oneNumber
                txtExpressao.text =  txtExpressao.text.toString() + txtResult.text.toString() +  "+"
                txtResult.text = resultConta.toString();
                lastOperator = "+";
            }
        }

        Log.d("SUM", resultConta.toString());
    }

    private fun calcular(lastOperator: String) {
        when (lastOperator) {
            "+" -> "";
            "-" -> "";
            "x" -> "";
            "/" -> "";
        }
    }

    fun limparText(){
        txtResult.text = "";
    }

}

