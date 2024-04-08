package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ordalisti {
    private final ObservableList<String> ordalisti;

    public Ordalisti(){
        this.ordalisti = FXCollections.observableArrayList();

        ordalisti.add(new Strengir().getTexti());
    }

    public ObservableList<String> getOrdalisti(){
        return ordalisti;
    }


}
