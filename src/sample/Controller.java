package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {

 private HashTable table=new HashTable(20);
 @FXML
 private TextField input;
 @FXML
 private Label label1;

    public void checkEvents(ActionEvent event){

       String inputValue = input.getText();
        String[] elementsToAdd = {inputValue};
        int hashIndex=table.hashFunction2(elementsToAdd,table.getTheArray());
        label1.setText(inputValue);


    }
}
