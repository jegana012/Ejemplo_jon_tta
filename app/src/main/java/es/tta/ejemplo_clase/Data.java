package es.tta.ejemplo_clase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jon on 18/12/15.
 */
public class Data {
    public Test getTest(){
        try {
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

    }
}
