import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label instructionLabel = new Label("Please enter the conversion you want:");
        Label resultLabel = new Label("Result:");
        resultLabel.setStyle("-fx-text-fill: green;");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter the number you would like to convert");

        ComboBox<String> conversionOptions = new ComboBox<>();
        conversionOptions.getItems().addAll("grams to ounces", "meters to miles", "yards to feet", "pounds to grams");
        conversionOptions.setValue("grams to ounces"); //this will be the default conversion

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(_ -> {
            try {
                double inputnum = Double.parseDouble(inputField.getText());
                String conversionChoice = conversionOptions.getValue();
                double result = 0;
            
                switch (conversionChoice) {
                    case "grams to ounces":
                        result = inputnum * 0.035274;
                        resultLabel.setText(inputnum + " grams = " + result + " ounces");
                        break;
                    case "meters to miles":
                        result = inputnum * 0.000621371;
                        resultLabel.setText(inputnum + " meters = " + result + " miles");
                        break;
                    case "yards to feet": 
                        result = inputnum * 3;
                        resultLabel.setText(inputnum + " yards = " + result + " feet");
                        break;
                    case "pounds to grams":
                        result = inputnum * 453.592;
                        resultLabel.setText(inputnum + " pounds = " + result + " grams");
                        break;
                    default:
                        resultLabel.setText("Invalid conversion type");

                }        

        

            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input, enter a valid number");
            }
        });

        VBox layout = new VBox(10); //vertical box with 10px spacing
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(instructionLabel, conversionOptions, inputField, convertButton, resultLabel);
        
        //Display window:
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Conversion App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
