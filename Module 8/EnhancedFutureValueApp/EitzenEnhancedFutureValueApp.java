/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package EnhancedFutureValueApp;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class EitzenEnhancedFutureValueApp extends Application{
    // The following are class variables.
    private TextField txtMonthlyPayment = new TextField("");
    private TextField txtInterestRate = new TextField("");
    private TextArea txtResults = new TextArea("");
    private Label paymentLabel  = new Label("Monthly Payment:");;
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblYears = new Label("Years:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblFutureValueDate = new Label();
    private ComboBox<Integer> cbYears = new ComboBox<Integer>();
    private Button btnCalc = new Button("Calculate");
    private Button btnClear = new Button("Clear");

    /*
     * The following method is used to create the application GUI. Implements button functionality.
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
        pane.add(lblFutureValueDate, 0 , 5);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        GridPane.setColumnSpan(lblFutureValueDate, 2); // This helps prevent scenarios where the text is cutoff due to column 1 being too small.

        //The following adds the TextBoxes and ComboBox to the pane. Also initializes the ComboBox with some options.
        txtMonthlyPayment.setPrefWidth(3);
        txtInterestRate.setPrefWidth(3);
        pane.add(txtMonthlyPayment, 1, 0);
        pane.add(txtInterestRate, 1, 1);
        pane.add(cbYears, 1, 3);
        pane.add(txtResults, 0, 6); // Column span is modified later.
        cbYears.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7); // The number of years was not specified. Added 0-7 somewhat arbitrarily.
        cbYears.getSelectionModel().select(0);

        // The following sets the TextBoxes, ComboBox, and TextArea to be the same size. Also, sets the TextArea to span both columns of the GridPane.
        GridPane.setColumnSpan(txtResults, 2);
        cbYears.setPrefWidth(200);
        txtInterestRate.setPrefWidth(200);
        txtMonthlyPayment.setPrefWidth(200);
        txtResults.setPrefWidth(200);
        
        //The following adds the Clear and Calculate buttons to the pane.
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalc);
        pane.add(actionBtnContainer, 1, 4);
        actionBtnContainer.setAlignment(Pos.BASELINE_RIGHT); // This aligns it to the right, as shown in the assignment's example.

        // The following sets the Buttons functionality
        btnCalc.setOnAction(e -> calculateResults());
        btnClear.setOnAction(e -> clearFormFields());

        // This sets initializes the scene using the GridPane we created. It also names the app and renders it.
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Eitzen Future Value App");
        primaryStage.show();
    } // End Start(Stage)

    // This method resets all form values.
    private void clearFormFields(){
        txtMonthlyPayment.clear();
        txtInterestRate.clear();
        txtResults.clear();
        lblFutureValueDate.setText("");
        cbYears.getSelectionModel().select(0);
    } // End clearFormFields

    // This method takes all input and calculates it.
    private void calculateResults(){
        double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText()); // No error catching was required.
        double rate = Double.parseDouble(txtInterestRate.getText()); // No error catching was required.
        int years = cbYears.getSelectionModel().getSelectedIndex();
        double result = FinanceCalculator.calculateFutureValue(monthlyPayment, rate, years);
        txtResults.clear(); // Removes previous text.
        txtResults.appendText("The future value is $" + String.format("%,.2f", result));
        lblFutureValueDate.setText("Calculation as of " + returnDate());
    } // End calculateResults

    // This method returns the current date in mm/dd/yyyy format.
    private String returnDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(cal.getTime());
    } // End returnDate()

    /*
     * This main method launches the JavaFX Gui.
     * @param args String[]
     */
    public static void main(String[] args) {
        launch(args);
    } // End main(String[])
} // End EitzenEnhancedFutureValueApp

