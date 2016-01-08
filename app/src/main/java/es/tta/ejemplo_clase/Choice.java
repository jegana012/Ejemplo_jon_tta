package es.tta.ejemplo_clase;

/**
 * Created by jon on 8/01/16.
 */
public class Choice {
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
