package es.tta.ejemplo_clase;

import java.util.ArrayList;

/**
 * Created by jon on 18/12/15.
 */
public class Test {

    public final static int HTML_ADV=1;
    public final static int VIDEO_ADV=2;
    public final static int AUDIO_ADV=3;
    public String wording;
    public ArrayList<Choice> choices=new ArrayList<Choice>();
    public String getWording(){

        return wording;
    }
    public void setWording ( String wording){
        this.wording=wording;
    }

    public ArrayList<Choice> getChoices(){

       return choices;

   }
    public void setChoices( ArrayList<Choice> choices){

        this.choices=choices;
    }

}

