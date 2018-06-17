package sample;



import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



import java.net.URL;
import java.util.*;


public class Controller implements Initializable {

 private HashTable table;
 @FXML
 private TextField insertValue,findValue,deleteValue;
 @FXML
  private List<Label> labelList;
 @FXML
 private Label label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table=new HashTable(15);
        labelList=new ArrayList<>(15);
        labelList.add(label1);
        labelList.add(label2);
        labelList.add(label3);
        labelList.add(label4);
        labelList.add(label5);
        labelList.add(label6);
        labelList.add(label7);
        labelList.add(label8);
        labelList.add(label9);
        labelList.add(label10);
        labelList.add(label11);
        labelList.add(label12);
        labelList.add(label13);
        labelList.add(label14);
        labelList.add(label15);


    }

    public void insertValues(ActionEvent event){

       String insertValue = this.insertValue.getText();

        int hashIndex=table.hashFunction(insertValue,table.getTheArray());
        labelList.get(hashIndex).setText(insertValue);


    }

    public void findValues(ActionEvent event){

        String findValue = this.findValue.getText();
        int index = table.findKey(findValue);

        labelList.get(index).setStyle("-fx-background-color: orange;");



        }

    public void deleteValues(ActionEvent event){

        String deletedValue = this.deleteValue.getText();
        int index = table.deleteValue(deletedValue);
        labelList.get(index).setText(" ");
        labelList.get(index).setStyle("-fx-background-color: #F5F5F5;");


    }



    }


