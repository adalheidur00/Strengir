package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import vinnsla.Ordalisti;
import vinnsla.Strengir;

public class NanarController {

    private Ordalisti ordalisti;

    @FXML
    private ListView<String> fxVistudOrd;




    public void initialize(){
        Strengir strengir = new Strengir();
        strengir.setTexti("");
        ordalisti = new Ordalisti(strengir);

        fxVistudOrd.setItems(ordalisti.getOrdaListi());

        fxVistudOrd.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });
    }

    @FXML
    public void onTilBaka(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.HEIM);
    }



}
