package sample;



import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.*;


public class Controller implements Initializable {

 private HashTable table;
 @FXML
 private TextField insertValue,findValue,deleteValue;

 @FXML
 private List<Text> textList;


  @FXML
  private Pane pane;






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table=new HashTable(15);
        textList=new ArrayList<>(15);

        int squareLayoutX=0, squareLayoutY=250;

        for (int i=0; i<15;i++){


            this.createSquare(squareLayoutX,squareLayoutY);
            squareLayoutX += 50;
        }



    }

    public void insertValues(ActionEvent event){

       String insertValue = this.insertValue.getText();

        int hashIndex=table.hashFunction(insertValue,table.getTheArray());
        textList.get(hashIndex).setText(insertValue);



    }

    public void findValues(ActionEvent event){

        String findValue = this.findValue.getText();
        int index = table.findKey(findValue);
       //maybe i have to change the color of rectangle
        textList.get(index).setFill(Color.RED);



        }

    public void deleteValues(ActionEvent event){

        String deletedValue = this.deleteValue.getText();
        int index = table.deleteValue(deletedValue);
        textList.get(index).setText(" ");
        textList.get(index).setFill(Color.BLACK);


    }



    public void createSquare(int layoutX,int layoutY){
        Rectangle agent=new Rectangle(50,50);
        agent.setFill(Color.GRAY);
        agent.setStroke(Color.BLACK);
        Text text = new Text(" ");
        text.setFill(Color.WHITE);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(agent, text);
        stack.setLayoutX(layoutX);
        stack.setLayoutY(layoutY);
        this.pane.getChildren().add(stack);
        textList.add(text);


    }

    }


