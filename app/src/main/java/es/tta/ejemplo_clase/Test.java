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
        //String question="¿Cuál de las siguientes opciones NO se indica en el fichero de manifiesto de la app?";
        //return question;
        return wording;
    }
    public void setWording ( String wording){
        this.wording=wording;
    }

    public ArrayList<Choice> getChoices(){

       return choices;

   }




    /*public class Choice{
        private int id;
        private String opcion;
        private boolean correcta;
        private String advise;
        private String adviseType;
        public Choice(int id,String opcion, boolean correcta, String advise, String adviseType){
            this.opcion=opcion;
            this.correcta=correcta;
            this.advise=advise;
            this.adviseType=adviseType;

        }


        public String getOpcion(){
            return opcion;
        }

        public boolean isCorrecta(){
            return correcta;
        }

        public String getAdvise() {
            return advise;
        }
        public String getAdviseType(){
            return adviseType;
        }
    }
*/
}

