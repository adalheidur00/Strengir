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

    private NanarController nanarController;

    public void initialize(){
        ordalisti = new Ordalisti();
        fxVistudOrd.setItems(ordalisti.getOrdalisti());

    }

    @FXML
    public void onTilBaka(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.HEIM);
    }



}
