package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	
	static final double TIP = 0.12;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		final Button calBtn = (Button)findViewById(R.id.btnCalculate);
		final EditText amount = (EditText)findViewById(R.id.edtBillAmount);
		final CheckBox round = (CheckBox)findViewById(R.id.chkRound);
		final TextView res = (TextView)findViewById(R.id.txtTipResult);
		calBtn.setOnClickListener(
				new OnClickListener() {
			
					@Override
					public void onClick(View v) {

						double val = Double.parseDouble(amount.getText().toString());
						if(round.isChecked()) {
							res.setText("Tip: $"+Long.valueOf(Math.round(val * TIP)).toString());
						}
						else {
							res.setText("Tip: $"+String.format("%.2f", val * TIP));
						}
					}
				});
		
	}

}
