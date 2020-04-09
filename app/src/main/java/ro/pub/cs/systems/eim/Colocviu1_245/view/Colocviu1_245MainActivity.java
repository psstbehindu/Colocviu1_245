package ro.pub.cs.systems.eim.Colocviu1_245.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ro.pub.cs.systems.eim.Colocviu1_245.R;
import ro.pub.cs.systems.eim.Colocviu1_245.general.Constants;

public class Colocviu1_245MainActivity extends AppCompatActivity {

    private Button add_button;
    private Button compute_button;
    private EditText next_term;
    private EditText all_terms;
    private int total_sum = 0;
    private ArrayList<Integer> terms_to_add = new ArrayList<>();

    private ButtonClickListener buttonClickListener = new ButtonClickListener();


    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.add_button:
                    if (!StringUtils.isNullOrWhiteSpace(next_term.getText().toString()) && next_term.getText().toString().matches("\\d*")) {
                        if (!all_terms.getText().toString().equals("")) {
                            all_terms.setText(all_terms.getText().toString().concat(" + " + next_term.getText().toString()));
                            terms_to_add.add(Integer.valueOf(next_term.getText().toString()));
                        } else {
                            all_terms.setText(all_terms.getText().toString().concat(next_term.getText().toString()));
                            terms_to_add.add(Integer.valueOf(next_term.getText().toString()));
                        }
                    }
                    break;

                case R.id.compute_button:
                    Intent intent_send = new Intent(getApplicationContext(), Colocviu1_245SecondaryActivity.class);
                    intent_send.putExtra(Constants.TERMS_LIST, terms_to_add);
                    startActivityForResult(intent_send, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);

                    Intent intent = getIntent();
                    if (intent != null && intent.getExtras().containsKey(Constants.TOTAL_SUM)) {
                        total_sum = intent.getIntExtra(Constants.TOTAL_SUM, -1);
                        Toast.makeText(getApplicationContext(), "The activity returned with result " + total_sum, Toast.LENGTH_LONG).show();
                    }

                    break;

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);

        add_button = (Button)findViewById(R.id.add_button);
        compute_button = (Button)findViewById(R.id.compute_button);
        next_term = (EditText)findViewById(R.id.next_term);
        all_terms = (EditText)findViewById(R.id.all_terms);


        add_button.setOnClickListener(buttonClickListener);


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.TOTAL_SUM)) {
                total_sum = Integer.valueOf(savedInstanceState.getString(Constants.TOTAL_SUM));
            } else {
                total_sum = 0;
            }

        }
    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.TOTAL_SUM, String.valueOf(total_sum));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.TOTAL_SUM) && savedInstanceState.getString(Constants.TOTAL_SUM) != null) {
            total_sum = Integer.valueOf(savedInstanceState.getString(Constants.TOTAL_SUM));
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
