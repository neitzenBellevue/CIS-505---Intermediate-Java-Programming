/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package GradeBookApp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EitzenGradeBookApp extends Application{

   // The following buttons will have functionality added later
   private Button btnClearForm = new Button("Clear Form");
   private Button btnSaveForm = new Button("Save Form");
   private Button btnLoadForm = new Button("Load Previous Form");
   private Button btnAddRow = new Button("Add Row");
   private Button btnRemoveRow = new Button("Remove Last Row");

   //These labels are for the GridPane Columns
   private Label lblFirstName = new Label("First Name");
   private Label lblLastName = new Label("Last Name");
   private Label lblCourseName = new Label("Course Name");
   private Label lblGrade = new Label("Grade");

   //The following are for inputing information into the rows:
   private TextField txtFirstName = new TextField("");
   private TextField txtLastName = new TextField("");
   private TextField txtCourseName = new TextField("");
   private ComboBox<String> cbGrades = new ComboBox<String>(); 
   private GridPane pane = new GridPane(); // GridPane used as the program will follow an Excel Style layout

   /*
   * The following method is used to create the application GUI. Implements button functionality.
   * @param primaryStage Stage
   */
   @Override
   public void start(Stage primaryStage){
      pane.setAlignment(Pos.CENTER);
      pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      pane.setVgap(5.5);
      pane.setHgap(5.5);

      // The following adds the buttons to the pane. Formats them.
      pane.add(btnLoadForm, 0, 0);
      pane.add(btnSaveForm, 1, 0);
      pane.add(btnClearForm, 3, 0);
      pane.add(btnAddRow, 0, 3);
      pane.add(btnRemoveRow, 1, 3);
      btnClearForm.setTextFill(Color.RED);
      btnRemoveRow.setTextFill(Color.RED);
      btnAddRow.setTextFill(Color.GREEN);

      /*
       * TBD
       * Save Button writing a CSV File. Using Student Class.
       * Load Button loading from CSV File. Using Student Class.
       * Remove Button deleting last added row.
       */
       btnAddRow.setOnAction(e -> addRow(pane.getRowCount())); // Added to display functionality. Remove Button will act in reverse.

      // The following adds the labels for the student grade book rows. Formats it
      pane.add(lblFirstName, 0, 1);
      pane.add(lblLastName, 1, 1);
      pane.add(lblCourseName, 2, 1);
      pane.add(lblGrade, 3, 1);
      lblGrade.setPrefWidth(50);
      lblFirstName.setPrefWidth(100);
      lblLastName.setPrefWidth(100);
      lblCourseName.setPrefWidth(200);
    
      // The following adds the first blank TextField and ComboBox. The remaining should be generated with a script as needed.
      pane.add(txtFirstName, 0, 2);
      pane.add(txtLastName, 1, 2);
      pane.add(txtCourseName, 2, 2);
      pane.add(cbGrades, 3, 2);
      cbGrades.getItems().addAll("", "A", "A-", "B+", "B", "B-","C+", "C", "C-","D+", "D", "D-", "F");

      // This makes the GridPane Scrollable. Needed as it can theoretically go well beyond a screens perimeters.
      ScrollPane sp = new ScrollPane();
      sp.setContent(pane);
      sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    
      sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); 
      
      // The following initializes the scene, displays it, and sets the window title.
      primaryStage.setScene(new Scene(sp));
      primaryStage.setTitle("Eitzen Grade Book App");
      primaryStage.show();
   } // End Start(Stage)
   
   /*
    * This function is used by the "Add Row" button to append a row to the grade book.
    * It shifts the Add/Remove buttons down and adds a row of TextFields and a ComboBox in there place.
    * @param count int
    */
   private void addRow(int count){
      pane.setRowIndex(btnAddRow, count+1); // Will need to implement properly. This is just to display intention for GUI
      pane.setRowIndex(btnRemoveRow, count+1);
      pane.add(new TextField(""), 0, count);
      pane.add(new TextField(""), 1, count);
      pane.add(new TextField(""), 2, count);
      ObservableList<String> options = // This initializes the ComboBox with the correct selection.
         FXCollections.observableArrayList("", "A", "A-", "B+", "B", "B-","C+", "C", "C-","D+", "D", "D-", "F"); 
      pane.add(new ComboBox<String>(options), 3, count);
   } // End addRow(int)

    /*
     * This main method launches the JavaFX Gui.
     * @param args String[]
     */
    public static void main(String[] args) {
      launch(args);
  } // End main(String[])
}
