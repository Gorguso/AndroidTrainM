package magisterka.apmagisterka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

    }



    public void clickFinish(View v)
    {
        this.finish();
    }

    private double resultBmi(double waga, double wzrost)
    {
        double wynik = (waga/(wzrost*wzrost))*10000;
        return wynik;
    }

    public void resetLicznik(View v)
    {
        final EditText editTextWaga = (EditText) findViewById(R.id.editText);
        final EditText editTextWzrost = (EditText) findViewById(R.id.editText2);
        editTextWaga.getText().clear();
        editTextWzrost.getText().clear();
    }

public void onClickBmiLicz(View view)
{
    final EditText editTextWaga = (EditText) findViewById(R.id.editText);
    final EditText editTextWzrost = (EditText) findViewById(R.id.editText2);
    final TextView textViewWynikBmi = (TextView) findViewById(R.id.bmiResult);
    final TextView textViewInterpretacji = (TextView) findViewById(R.id.textView5);

    String s1 = editTextWaga.getText().toString();
    String s2 = editTextWzrost.getText().toString();

    if(TextUtils.isEmpty(s1)){
      editTextWaga.setError("Podaj wage !");
        editTextWaga.requestFocus();
        return;
    }
    if(TextUtils.isEmpty(s2))
    {
        editTextWzrost.setError("Podaj wzrost !");
        editTextWzrost.requestFocus();
        return;
    }

    double waga = Double.parseDouble(s1);
    double wzrost = Double.parseDouble(s2);

    double bmiCalc = resultBmi(waga,wzrost);
    if(bmiCalc <18.5)
    {
        textViewInterpretacji.setText("Niedowaga");
    }
    if(bmiCalc >=18.5 && bmiCalc<=24.999)
    {
        textViewInterpretacji.setText("Prawidłowa masa ciała");
    }
    if(bmiCalc >=25 && bmiCalc <=29.999)
    {
        textViewInterpretacji.setText("Nadwaga");
    }
    if(bmiCalc >=30 && bmiCalc <=34.999)
    {
        textViewInterpretacji.setText("I stopien otyłości");
    }
    if(bmiCalc >=35 && bmiCalc <=39.999)
    {
        textViewInterpretacji.setText("II stopien otyłości");
    }
    if(bmiCalc >40)
    {
        textViewInterpretacji.setText("Otyłość skrajna");
    }

    textViewWynikBmi.setText(String.format("%.3f",bmiCalc));





}


}
