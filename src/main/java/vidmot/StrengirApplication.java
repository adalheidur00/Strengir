package vidmot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
