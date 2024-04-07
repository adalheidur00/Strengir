package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Nanar {

    @FXML
    public void onTilBaka(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.HEIM);
    }
}
