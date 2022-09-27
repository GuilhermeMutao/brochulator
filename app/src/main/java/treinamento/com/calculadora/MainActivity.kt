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
    private var resultConta : Double = 0.0;
    private var oneNumber : Double = 0.0;
    private var twoNumber : Double = 0.0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.txtResult = findViewById(R.id.txtResult)

        supportActionBar?.hide();
    }

    fun setNumber(view: View) {
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
        val botao = view as Button
        txtExpressao.text = txtResult.text.toString();
        when (view.id) {

        }
    }

}

