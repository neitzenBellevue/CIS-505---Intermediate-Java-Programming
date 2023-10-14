package FutureValueApp;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EitzenFutureValueApp extends Application{
    // The following are class variables.
    private TextField txtMonthlyPayment = new TextField("");
    private TextField txtInterestRate = new TextField("");
    private TextArea txtAreaOutput = new TextArea("");
    private Label paymentLabel  = new Label("Monthly Payment:");;
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblYears = new Label("Years:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label label5; // Assignment said to make 5, but I only see 4 label use cases. Perhaps used in the future?
    private ComboBox<Integer> yearsBox = new ComboBox<Integer>();
    private Button btnCalc = new Button("Calculate");
    private Button btnClear = new Button("Clear");

    /*
     * The following method is used to start the program. Creates the pane.
     * @param primaryStage Stage
     */
    @Override
    public void start(Stage primaryStage){
        //The following sets the base settings of the pane.
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setVgap(5.5);
        pane.setHgap(5.5);
        

        // The following adds the labels to the pane.
        pane.add(paymentLabel, 0, 0);
        pane.add(lblInterestRate, 0, 1);
        pane.add(lblYears, 0, 3);
        lblInterestRateFormat.setTextFill(Color.RED);
        pane.add(lblInterestRateFormat, 1, 2); // This label is on a different column than the rest due to needing to align with the TextBoxes.
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        //The following adds the TextBoxes and ComboBox to the pane. Also initializes the ComboBox with some options.
        txtMonthlyPayment.setPrefWidth(3);
        txtInterestRate.setPrefWidth(3);
        pane.add(txtMonthlyPayment, 1, 0);
        pane.add(txtInterestRate, 1, 1);
        pane.add(yearsBox, 1, 3);
        pane.add(txtAreaOutput, 0, 5); // Column span is modified later.
        yearsBox.getItems().addAll(1, 2, 3, 4); // This wasn't specified, but I added it to confirm ComboBox functionality.

        // The following sets the TextBoxes, ComboBox, and TextArea to be the same size. Also, sets the TextArea to span both columns of the GridPane.
        GridPane.setColumnSpan(txtAreaOutput, 2);
        yearsBox.setPrefWidth(200);
        txtInterestRate.setPrefWidth(200);
        txtMonthlyPayment.setPrefWidth(200);
        txtAreaOutput.setPrefWidth(200);
        
        //The following adds the Clear and Calculate buttons to the pane.
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalc);
        pane.add(actionBtnContainer, 1, 4);
        actionBtnContainer.setAlignment(Pos.BASELINE_RIGHT); // This aligns it to the right, as shown in the assignment's example.

        // This sets initializes the scene using the GridPane we created. It also names the app and renders it.
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Eitzen Future Value App");
        primaryStage.show();

    } // End Start(Stage)

    /*
     * This main method launches the JavaFX Gui.
     * @param args String[]
     */
    public static void main(String[] args) {
        launch(args);
    }
}

