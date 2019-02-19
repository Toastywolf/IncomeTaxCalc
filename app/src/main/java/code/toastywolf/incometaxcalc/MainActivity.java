package code.toastywolf.incometaxcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TaxInformation taxInfo;
    private RadioGroup statusRadioGroup;
    private TextView incomeTextEntry;
    private TextView taxResultTextView;
    private static final String APP_STATE = "appState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusRadioGroup = findViewById(R.id.statusRadioGroup);
        incomeTextEntry = findViewById(R.id.incomeTextEntry);
        taxResultTextView = findViewById(R.id.incomeTextOutput);

        /*
        if (savedInstanceState != null) {
            String appState = savedInstanceState.getString(APP_STATE);
            TaxInformation.restoreState(appState);
        }*/
    }
    /*
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(APP_STATE, TaxInformation.getState());
    }
    */

    private boolean checkFieldsParseAsInteger() {
        try {
            Integer.parseInt(incomeTextEntry.getText().toString());
            return true;
        } catch (NumberFormatException _) {
            return false;
        }
    }

    public void onClickCalculate(View v){
        if(checkFieldsParseAsInteger()&&!incomeTextEntry.getText().equals("")) {
            taxInfo = new TaxInformation(Integer.parseInt(incomeTextEntry.getText().toString()), statusRadioGroup.getCheckedRadioButtonId()-R.id.single);
            String why=""+taxInfo.getIncome()+taxInfo.getIncome()*TaxCalculator.rate(taxInfo);
            taxResultTextView.setText(why);
        }
    }
}
