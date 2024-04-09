package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class UmController {

    @FXML
    public void onUmTilBaka(ActionEvent actionEvent) { ViewSwitcher.switchTo(View.HEIM);
    }
}



