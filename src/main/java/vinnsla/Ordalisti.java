package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class Ordalisti {

    public static ObservableList<String> ordaListi = FXCollections.observableArrayList();

    public static Strengir strengir;

//    public Ordalisti(Strengir strengir){
//        ordaListi = FXCollections.observableArrayList();
//        Ordalisti.strengir = strengir;
//
//        String text = strengir.getTexti();
//        if(text != null) {
//            String[] ord = text.split("\\s+");
//
//            ordaListi.addAll(Arrays.asList(ord));
//        }
//    }

    public static void setStrengir(Strengir strengir){
        Ordalisti.strengir = strengir;
        String text = strengir.getTexti();
        if(text != null) {
            String[] ord = text.split("\\s+");

            ordaListi.addAll(Arrays.asList(ord));
        }
    }

//    public ObservableList<String> getOrdaListi(){
//        return ordaListi;
//    }



}
