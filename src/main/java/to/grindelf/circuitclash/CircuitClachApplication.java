package to.grindelf.circuitclash;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;

public class CircuitClachApplication extends Application {

    private static final int SCENE_HEIGHT = 740;
    private static final int SCENE_WIDTH = 980;
    private static final String FXML_FILE = "main-view.fxml";
    private static final String APP_TITLE = "Circuit Clash";

    @Override
    public void start(@NotNull Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CircuitClachApplication.class.getResource(FXML_FILE));
        Scene scene = new Scene(fxmlLoader.load(), SCENE_WIDTH, SCENE_HEIGHT);
        stage.setTitle(APP_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}