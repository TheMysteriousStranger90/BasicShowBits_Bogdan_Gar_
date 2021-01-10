package controller;

import data.BasicShowBits;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button exitButton;
    @FXML
    private Button button8;
    @FXML
    private Button button16;
    @FXML
    private Button button32;
    @FXML
    private Button resetButton;
    @FXML
    private Label errorMessageField;
    @FXML
    private TextField numberField;
    @FXML
    private TextArea fieldResult;

    long result;
    String fin;

    public void numberFieldKeyTyped(KeyEvent event) {
        numberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                numberField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        errorMessageField.setText("Вводите только цифры!");
    }

    public void button8OnAction(ActionEvent event) {
        fieldResult.setText("");
        if (numberField.getText().isEmpty()) {
            errorMessageField.setText("Введите число!");
        } else {
            result = Long.parseLong(numberField.getText());
            BasicShowBits bsb = new BasicShowBits(8);
            fin = bsb.show(result);
            fieldResult.setText(fin);
        }
    }

    public void button16OnAction(ActionEvent event) {
        fieldResult.setText("");
        if (numberField.getText().isEmpty()) {
            errorMessageField.setText("Введите число!");
        } else {
            result = Long.parseLong(numberField.getText());
            BasicShowBits bsb = new BasicShowBits(16);
            fin = bsb.show(result);
            fieldResult.setText(fin);
        }
    }

    public void button32OnAction(ActionEvent event) {
        fieldResult.setText("");
        if (numberField.getText().isEmpty()) {
            errorMessageField.setText("Введите число!");
        } else {
            result = Long.parseLong(numberField.getText());
            BasicShowBits bsb = new BasicShowBits(32);
            fin = bsb.show(result);
            fieldResult.setText(fin);
        }
    }

    public void resetButtonOnAction(ActionEvent event) {
        numberField.clear();
        fieldResult.clear();
        errorMessageField.setText("");
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
