package ro.pub.cs.systems.eim.Colocviu1_245.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import ro.pub.cs.systems.eim.Colocviu1_245.general.Constants;

public class Colocviu1_245SecondaryActivity extends AppCompatActivity {

    private int total_sum = 0;
    private ArrayList<Integer> terms_to_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.TERMS_LIST)) {
            terms_to_add = intent.getIntegerArrayListExtra(Constants.TERMS_LIST);

            if (terms_to_add != null) {
                for (int i = 0; i < terms_to_add.size(); i++) {
                    total_sum += terms_to_add.get(i);
                }
            }

            Intent intent_send = new Intent(getApplicationContext(), Colocviu1_245MainActivity.class);
            intent_send.putExtra(Constants.TOTAL_SUM, total_sum);
            startActivityForResult(intent_send, Constants.MAIN_ACTIVITY_REQUEST_CODE);
        }
    }
}
