package es.tta.ejemplo_clase;

import android.content.Intent;
import android.graphics.Color;
//import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
//import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;

import java.io.IOException;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    int correct;
    private String advise="";
    private String video="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {//mirar los advices
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Data data= new Data();
        Test test = data.getTest();
        TextView textWording = (TextView) findViewById(R.id.test_wording);
        textWording.setText(test.getWording());
        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
        int i=0;
        for(Test.Choice choice : test.getChoices()){
            RadioButton radio = new RadioButton(this);
            radio.setText(choice.getOpcion());
            radio.setOnClickListener(this);
            group.addView(radio);
            if(choice.isCorrecta())
                correct=i;
            i++;

        }
        advise="http://www.surf30.net/";
        video="https://www.youtube.com/watch?v=Q4KkfiLRLdQ";

    }

    @Override
    public void onClick(View v){
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

    public void send (View view){
        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
        int choices = group.getChildCount();
        for(int i=0;i<choices;i++)
            group.getChildAt(i).setEnabled(false);
        LinearLayout layout =(LinearLayout)findViewById(R.id.test_layout);
        layout.removeView(findViewById(R.id.button_send_test));
        group.getChildAt(correct).setBackgroundColor(Color.GREEN);
        int selectedId=group.getCheckedRadioButtonId();
        View radioButton= group.findViewById(selectedId);
        int selected = group.indexOfChild(radioButton);
        if(selected!=correct){
            group.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(), "Has fallado", Toast.LENGTH_SHORT);

                findViewById(R.id.button_view_advice).setVisibility(View.VISIBLE);

        }else
            Toast.makeText(getApplicationContext(),"Correcto!", Toast.LENGTH_SHORT);
    }

    public void showHtml (View view){

        if(advise.substring(0,10).contains("://")){
            Uri uri = Uri.parse(advise);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }else {
            WebView web = new WebView(this);
            web.loadData(advise, "text/html",null);
            web.setBackgroundColor(Color.TRANSPARENT);
            web.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
            LinearLayout layout =(LinearLayout)findViewById(R.id.test_layout);
            layout.addView(web);
            layout.removeView(findViewById(R.id.button_view_advice));
        }
    }

    public void showVideo(View view){
        VideoView video = new VideoView(this);
        video.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=Q4KkfiLRLdQ"));
        ViewGroup.LayoutParams params =new ViewGroup.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        video.setLayoutParams(params);

        MediaController controller = new MediaController(this){
            @Override
            public void hide(){
            //para que no se esconda sobreescribimos el metodo
            }
            @Override
            public boolean dispatchKeyEvent(KeyEvent event){
                if(event.getKeyCode() == KeyEvent.KEYCODE_BACK)
                    finish();//cuando el usuario de a la tecla atars se finalice
                return super.dispatchKeyEvent(event);//resto llamamos a los metodos de la clase
            }
        };
        controller.setAnchorView(video);
        video.setMediaController(controller);
        LinearLayout layout =(LinearLayout)findViewById(R.id.test_layout);
        layout.addView(video);
        video.start();


    }
    public void showAudio(View view) throws IOException {
        //View view = new View(this);
        AudioPlayer audioPlayer = new AudioPlayer(view);
        audioPlayer.setAudioUri(Uri.parse(advise));
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        LinearLayout layout =(LinearLayout)findViewById(R.id.test_layout);
        layout.addView(view);
        audioPlayer.start();

    }





}
