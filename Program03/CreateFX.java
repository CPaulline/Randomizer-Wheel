import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class for creating all the FX in the program
 */
public class CreateFX {
    Wheel wheelGuy = new Wheel();

    /**
     * Method to create the main VBox that holds everything that functions
     * in the GUI
     * @return VBox that holds all buttons and everything apart of the function
     */
    public VBox createMachine(){
        //sets the default name for the wheel 
        Label wheelName = new Label("Unkown Wheel");

        //creates a textfield and enter button to change the wheel name and stores it in a HBox
        TextField nameBar = new TextField();
        nameBar.setPromptText("Enter a Wheel name");
        Button nameChange = new Button("Name");
        nameChange.setMinWidth(50);
        nameChange.setOnAction(e->{
            if(!nameBar.getText().isEmpty()){
                wheelName.setText(nameBar.getText());
                nameBar.clear();
            }
        });
        HBox set1 = new HBox(nameBar, nameChange);
        set1.setAlignment(Pos.CENTER);

        //creates a textfield and enter button to add an item to a list and stores it in a HBox
        TextField addBar = new TextField();
        addBar.setPromptText("Enter a Wheel item");
        Button add = new Button("Add");
        add.setMinWidth(50);
        add.setOnAction(e->{
            if(!addBar.getText().isEmpty()){
                wheelGuy.addItem(addBar.getText());
                createMessage(addBar.getText() + " was added");
                addBar.clear();
            }
        });
        HBox set2 = new HBox(addBar, add);
        set2.setAlignment(Pos.CENTER);

        //creates a spin and reload button and sets their functions then stores into a HBox
        Button spin = new Button("Spin");
        spin.setMinWidth(80);
        spin.setOnAction(e->{
            createMessage("Item Spun: " + wheelGuy.spin());
        });
        Button reload = new Button("Reload");
        reload.setMinWidth(80);
        reload.setOnAction(e->{
            boolean flag = wheelGuy.reloadItems();
			if(flag) {createMessage("Items reloaded");}
            else {createMessage("Error: Reload only works after spinning.");}
        });
        HBox set3 = new HBox(spin, reload);
        set3.setAlignment(Pos.CENTER);
        set3.setSpacing(10);

        //creates a clear and reverse buttom and sets their functions then stores into a HBox
        Button clear = new Button("Clear");
        clear.setMinWidth(80);
        clear.setOnAction(e->{
            wheelGuy.clearItems();
            System.out.println(wheelGuy);
            createMessage("Items cleared");
        });
        Button reverse = new Button("Reverse");
        reverse.setMinWidth(80);
        reverse.setOnAction(e->{
            wheelGuy.reverseItems();
            System.out.println(wheelGuy);
            createMessage("Item order reversed");
        });
        HBox set4 = new HBox(clear, reverse);
        set4.setAlignment(Pos.CENTER);
        set4.setSpacing(10);

        //creates a report button and calls function defined bellow for an info box
        Button report = new Button("Report");
        report.setMinWidth(80);
        report.setOnAction(e->{
            createReport();
        });

        //creates a VBox for all sets, wheel name, and report button
        VBox v = new VBox(wheelName, set1, set2, set3, set4, report);
        v.setAlignment(Pos.CENTER); 
        v.setSpacing(10);
        return v;
    }

    /**
     * Creates the report box listing the items, number of items, also first and last item
     */
    private void createReport(){
        Stage repo = new Stage();
        repo.setTitle("Report");

        Label items = new Label("List Items: " + wheelGuy);
        Label numItems = new Label("Number of Items: " + wheelGuy.size());
        Label firstItem = new Label("First Item: " + wheelGuy.firstItem());
        Label lastItem = new Label("Last Item: " + wheelGuy.lastItem());
        Button ok = new Button("Ok");
        ok.setOnAction(e->{
            repo.close();
        });

        VBox repoBox = new VBox(items, numItems, firstItem, lastItem, ok);
        repoBox.setSpacing(10);
        repoBox.setAlignment(Pos.CENTER);
        Scene report = new Scene(repoBox, 300, 200);
        repo.setScene(report);
        repo.show();
    }

    /**
     * Creates a default message box when a message is passed in
     * @param message custom message that is to be displayed
     */
    private void createMessage(String message){
        Stage mess = new Stage();
        
        Label messLabel = new Label(message);
        messLabel.setAlignment(Pos.CENTER);

        Button ok = new Button("ok");
        ok.setOnAction(e->{
            mess.close();
        });

        VBox box = new VBox(messLabel, ok);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        Scene messScene = new Scene(box, 220, 115);
        mess.setScene(messScene);

        mess.show();
    }
}