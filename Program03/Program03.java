import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Program that creates a randomizer spinner wheel
 * @author Cole Paulline
 */
public class Program03 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Start that initiates the GUI and functionality
     */
    public void start(Stage primaryStage){
        primaryStage.setTitle("Wheel Spinner");

        CreateFX wheelEFX = new CreateFX();

        //calls the FX method class and puts in a variable
        VBox vbox = wheelEFX.createMachine();
        vbox.setLayoutY(-600); //offset position for animation transition

        //additional transition animation
        TranslateTransition trans = new TranslateTransition(Duration.seconds(2), vbox);
        trans.setDelay(Duration.seconds(2));
        trans.setToY(600);
        trans.setCycleCount(1);
        trans.play();

        //creates scene and shows it on the stage
        Scene scene = new Scene(vbox, 960, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}