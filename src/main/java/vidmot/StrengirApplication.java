package vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Main klasi fyrir Strengir application. Sér um að lesa inn notendaviðmótslýsingu og ræsa forritið
 *
 *****************************************************************************/
public class StrengirApplication extends Application {
    @Override
    public void start(Stage stage){
        var scene = new Scene(new Pane());

        ViewSwitcher.setScene(scene);

        ViewSwitcher.switchTo(View.HEIM);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
