package es.tta.ejemplo_clase;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    Data data= new Data();
    Test test = data.getTest();
    TextView textWording = (TextView) findViewById(R.id.test_wording);
    textWording.setText(test.getWording());
    RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
    int i=0;
    for(Test.Choice choice : test.getChoices()){
        RadioButton radio = new RadioButton(this);
        radio.setText(choice.getWording());
        radio.setOnClickListener(this);
        group.addView(radio);
        if(choice.isCorrect())
            correct =i;
        i++;

    }
    @Override
    public void onClick(View v){
        findViewById(R.id.button_send_file).setVisibility(View.VISIBLE);
    }
    int choices = group.getChildCount();
    for(int i=0;i<choices;i++)
        group.getChildAt(i).setEnabled(false);
    layout.removeView(findViewById(R.id.button_send_test));
    group.getChildAt(correct).setBackgroundColor(Color.GREEN);
    if(Selected != correct){
        group.getChildAt(selected).setBackgroundColor(Color.RED);
        Toast.makeText(getApplicationContext(), "Has fallado", Toast.LENGTH_SHORT);
        if(advise != null && !advise.isEmpty())
            findViewById(R.id.button_view_advise).setVisibility(View.VISIBLE);

    }else
        Toast.makeText(getApplicationContext(),"Correcto!", Toast.LENGTH_SHORT);


}
