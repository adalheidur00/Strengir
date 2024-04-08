package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vidmot.StrengirController;

public class Ordalisti {

    private final ObservableList<String> ordaListi;

    public Strengir strengir;

    public Ordalisti(Strengir strengir){
        this.ordaListi = FXCollections.observableArrayList();
        this.strengir = strengir;

        String text = strengir.getTexti();
        if(text != null) {
            String[] ord = text.split("\\s+");

            for (String ordin : ord) {
                ordaListi.add(ordin);
            }
        }
    }

    public ObservableList<String> getOrdaListi(){
        return ordaListi;
    }



}
