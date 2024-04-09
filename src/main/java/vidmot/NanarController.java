package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import vinnsla.Ordalisti;


public class NanarController {

    public Label ordaTal;
    @FXML
    private ListView<String> fxVistudOrd;

    public void initialize() {
        fxVistudOrd.setItems(Ordalisti.ordaListi);
        ordaTal.setText(String.valueOf(Ordalisti.ordaListi.size()));
    }

    @FXML
    public void onTilBaka(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.HEIM);
    }



}
