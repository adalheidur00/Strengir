package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vinnsla.Ordalisti;
import vinnsla.Strengir;

public class NanarController {

    private Ordalisti ordalisti;

    @FXML
    private ListView<String> fxVistudOrd;


    public void initialize() {
        Strengir strengir = new Strengir();
        strengir.setTexti("");
        ordalisti = new Ordalisti(strengir);

        fxVistudOrd.setItems(ordalisti.getOrdaListi());

        fxVistudOrd.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });
    }

    @FXML
    public void onTilBaka(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.HEIM);
    }

    @FXML
    private MenuItem LOKA;
    @FXML
    private AnchorPane nanaranchor;

    Stage stage;

    public void loka(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Loka");
        alert.setHeaderText("Ertu viss um að þú viljir loka forritinu?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) nanaranchor.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void onUm(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.UM);
    }
}
