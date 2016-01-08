package es.tta.ejemplo_clase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jon on 18/12/15.
 */
//http://techslides.com/demos/sample-videos/small.mp4
// VPN erabiliz--> http://u017633.ehu.eus:18080/static/AndroidManifest.mp4
public class Data {
    public Test getTest() {
        boolean correcta;
        Test test = new Test();
        test.setWording("¿Pregunta....?");


        ArrayList<Choice> choices = new ArrayList<Choice>();
        for (int i = 0; i < 5; i++) {
            if (i == 2)
                correcta = true;
            else
                correcta = false;
            Choice choice = new Choice(i, "respuesta " + i, correcta, "http://u017633.ehu.eus:18080/static/AndroidManifest.mp4", "video");
            choices.add(choice);

        }
            test.setChoices(choices);
            return test;
        }
    }

       /* try {
            Test test = new Test();
            JSONObject json = new JSONObject(bundle.getString(EXTRA_TEST));
            test.setWording(json.getString("wording"));
            JSONArray array = json.getJSONArray("choices");
            for(int i=0;i<array.length();i++){
                JSONObject item= array.getJSONObject(i);
                Choice choice = new Choice(item.getInt("id"),item.getString("wording"),item.getBoolean("correct"),item.optString("advise", null),item.optString("mime", null));
                test.getChoices().add(choice);

            }
            return test;

            return test;
        }catch (JSONException e){
            return null;
        }

    }*/

