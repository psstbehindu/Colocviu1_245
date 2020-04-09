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

//                case R.id.compute_button:
//                    Intent intent_send = new Intent(getApplicationContext(), Colocviu1_245MainActivity.class);
//                    intent.putExtra(Constants.TOTAL_SUM, total_sum);
//                    startActivityForResult(intent_send, Constants.MAIN_ACTIVITY_REQUEST_CODE);
//
//                    break;

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
    }




//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
//            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
//        }
//    }
}
