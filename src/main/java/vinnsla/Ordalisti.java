package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class Ordalisti {

    public static ObservableList<String> ordaListi = FXCollections.observableArrayList();

    public static Strengir strengir;

    /**
     * Býr til orðalista úr streng
     * @param strengir Strengurinn sem orðalistinn er búinn til úr
     */
    public static void setStrengir(Strengir strengir){
        Ordalisti.strengir = strengir;
        String text = strengir.getTexti();
        if(text != null) {
            String[] ord = text.split("\\s+");

            ordaListi.addAll(Arrays.asList(ord));
        }
    }
}
