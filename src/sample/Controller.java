package sample;



import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
 private TextField insertKey,insertValue,findValue,deleteValue;

 @FXML
 private List<Text> textList;


  @FXML
  private Pane pane;


  //check the rename of repository





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
        String insertKey = this.insertKey.getText();
       if(insertValue.equals("")&&insertKey.equals("")){
           Alert alert =new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText("you did not give a value and a key");
           alert.show();

       }
       else if(insertValue.equals(""))
        {
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("you did not give a value");
            alert.show();

        }
        else if(insertKey.equals("")){
           Alert alert =new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText("you did not give  a key");
           alert.show();

       }

       else{
           int hashIndex=table.hashFunction(insertKey);

           table.put(insertKey,insertValue);

           textList.get(hashIndex).setText(insertKey+"\n"+insertValue);
       }






    }

    public void findValues(ActionEvent event){

        String key = this.findValue.getText();


         if(key.equals("")||table.findValue(key)==-1){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("you did not give  a key"+"\n"+"or"+"\n"+"this key does not exist");
            alert.show();

        }

        else{
             int index = table.findValue(key);
             textList.get(index).setFill(Color.RED);
        }


        }

    public void deleteValues(ActionEvent event){

        String key = this.deleteValue.getText();
         int deletedIndex =table.deleteValue(key);

        if(key.equals("")||deletedIndex==-1){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("you did not give  a key"+"\n"+"or"+"\n"+"this key does not exist");
            alert.show();

        }
        else{

            textList.get(deletedIndex).setText("");
            textList.get(deletedIndex).setFill(Color.WHITE);
        }

    }



    public void createSquare(int layoutX,int layoutY){
        Rectangle agent=new Rectangle(50,50);
        agent.setFill(Color.GRAY);
        agent.setStroke(Color.BLACK);
        Text text = new Text(" ");
        text.setFill(Color.WHITE);
        text.setStyle("-fx-font-size: 14");
        StackPane stack = new StackPane();
        stack.getChildren().addAll(agent, text);
        stack.setLayoutX(layoutX);
        stack.setLayoutY(layoutY);
        this.pane.getChildren().add(stack);
        textList.add(text);


    }




    }


