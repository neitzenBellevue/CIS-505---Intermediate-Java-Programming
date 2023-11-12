/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package GradeBookApp;

import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
   private Button btnRemoveRow = new Button("Remove Row");

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

   // The following sets the csv files name.
   private final String fileName = "students.csv";

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

      // The following adds functionality to the buttons.
      btnAddRow.setOnAction(e -> addRow(pane.getRowCount())); // Added to display functionality. Remove Button will act in reverse.
      btnRemoveRow.setOnAction(e -> removeRow(pane.getRowCount())); // Added to display functionality. Remove Button will act in reverse.
      btnClearForm.setOnAction(e -> clearBook());
      btnSaveForm.setOnAction(e -> saveBook());
      btnLoadForm.setOnAction(e -> loadBook(fileName));

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
      GridPane.setRowIndex(btnAddRow, count);
      GridPane.setRowIndex(btnRemoveRow, count);
      pane.add(new TextField(""), 0, count-1);
      pane.add(new TextField(""), 1, count-1);
      pane.add(new TextField(""), 2, count-1);
      ObservableList<String> options = // This initializes the ComboBox with the correct selection.
         FXCollections.observableArrayList("", "A", "A-", "B+", "B", "B-","C+", "C", "C-","D+", "D", "D-", "F"); 
      pane.add(new ComboBox<String>(options), 3, count-1);
   } // End addRow(int)

    /*
    * This function is used by the "Remove Row" button to remove the last row of the Grade Book.
    * It shifts the Add/Remove buttons uo and removes a row of TextFields and a ComboBox. Will not remove the last row.
    * Sends a warning if you attempt to remove the last row.
    * @param count int
    */
   private void removeRow(int count){
      if(count > 4){
         pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == count-2);
         GridPane.setRowIndex(btnAddRow, count-2);
         GridPane.setRowIndex(btnRemoveRow, count-2);
      }
      else{
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Warning");
         alert.setHeaderText("You cannot remove the last row of the Gradebook");
         alert.alertTypeProperty();
         Optional<ButtonType> result = alert.showAndWait();
     }
   }// End removeRow(int)

   /*
    * The following loops thru each Grade Book row and creates a student.
    * Creates an array of Students and sends to Student class to write to a CSV.
    */  
   private void saveBook(){
      Student[] students = new Student[pane.getRowCount()-3];
      ObservableList<Node> childrens = pane.getChildren();

      /*
       * The following loop is complicated. Basically, we are looping thru the GridPane, starting with the first valid row and ending with the last.
       * Valid rows are any row that isn't dedicated to buttons. We go thru and assign first name, last name, course name, and grades based on expected column.
       * Those values are used to create a student object which is stored into an array of students. Finally, we send the array to be written to a CSV file.
       */
      for(int row = 2; row <= pane.getRowCount() - 2; row++){ // This loop is mostly to keep track of the array's index.
         String fName = "";
         String lName = "";
         String cName = "";
         String grade = "";
         for(Node node : childrens){ // This loop goes thru the nodes and extracts 
            if(node instanceof TextField ){
               if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == 0) {
                  fName = ((TextField)node).getText();
               }else if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == 1) {
                  lName = ((TextField)node).getText();
               }else if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == 2) {
                  cName = ((TextField)node).getText();
               }
            }
            else if(node instanceof ComboBox){
               if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == 3 && !((ComboBox)node).getSelectionModel().isEmpty()){
                  grade = ((ComboBox)node).getSelectionModel().getSelectedItem().toString();
               }
            }
         } // End Node for loop
         students[row-2] = new Student(fName, lName, cName, grade);
      } // End Main for loop

      // The following checks for any empty strings. Writes to csv if none found. Otherwise, throws an error.
      boolean missing = false;
      for(Student student : students){
         if(student.getFirstName().equals("") | student.getLastName().equals("") 
                  | student.getClass().equals("") | student.getGrade().equals("") ){
            missing = true;
            break;
         }
      }
      if(!missing) Student.writeStudents(students, fileName);
      else{ // Creates an alert if Grade Book not fully filled out.
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Warning");
         alert.setHeaderText("Your gradebook is not fully filled out. Progress not saved.");
         alert.alertTypeProperty();
         Optional<ButtonType> result = alert.showAndWait();
      }
   } // End saveBook()

 
   // The following loads from a CSV file. Uses Student class to get array of students and transforms into the Gradebook.
   private void loadBook(String fileName){
      Student[] students = Student.readStudents(fileName);
   } // End loadBook

   /*
    * The following method resets the Grade Book to it's original state.
    * This includes all excess rows removed, the first row cleared, add/remove button relocated.
    */
   private void clearBook(){
      pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) >= 3);
      txtCourseName.clear();
      txtFirstName.clear();
      txtLastName.clear();
      cbGrades.getSelectionModel().select(0);
      pane.add(btnAddRow, 0, 3);
      pane.add(btnRemoveRow, 1, 3);
   } // End clearBook()

    /*
     * This main method launches the JavaFX Gui.
     * @param args String[]
     */
    public static void main(String[] args) {
      launch(args);
  } // End main(String[])
}
