package sample;



import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;


public class Controller implements Initializable {

 private HashTable table;
 private int  tempIndex;
 @FXML
 private TextField insertKey,insertValue,findValue,deleteValue;

 @FXML
 private List<Text> textList;

    @FXML
    private List<Rectangle> rectangleList;

  @FXML
  private Pane pane;

  @FXML
  private Label label,titleLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table=new HashTable(15);
        tempIndex = -1;
        textList=new ArrayList<>(15);
        rectangleList=new ArrayList<>(15);
        int squareLayoutX=-10, squareLayoutY=250;

        for (int i=0; i<15;i++){


            this.createSquare(squareLayoutX,squareLayoutY);
            squareLayoutX += 50;

        }

    }

    public void insertValue(ActionEvent event){

       String insertValue = this.insertValue.getText();
        String insertKey = this.insertKey.getText();


        if(!table.isFull()) {
            if (insertValue.equals("") && insertKey.equals("")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("you did not give a value and a key");
                alert.show();

            } else if (insertValue.equals("")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("you did not give a value");
                alert.show();

            } else if (insertKey.equals("")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("you did not give  a key");
                alert.show();

            } else if (table.hasKey(insertKey)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("this key already exists");
                alert.show();

            } else {
                int hashIndex = table.hashFunction(insertKey);

                table.put(insertKey, insertValue);

                textList.get(hashIndex).setText(insertKey + "\n" + insertValue);
                this.showTheHashFunction(insertKey);
                this.pane.getChildren().remove(label);
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("table is full");
            alert.show();
        }
    }

    public void searchValue(ActionEvent event){

        String key = this.findValue.getText();
       // TODO  rectangleList.get(0).setFill(Color.GREEN);

         if(key.equals("")||table.search(key)==-1){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("you did not give  a key"+"\n"+"or"+"\n"+"this key does not exist");
            alert.show();

        }

        else{
             int index = table.search(key);
             if(this.tempIndex !=  -1){
                 textList.get(this.tempIndex).setFill(Color.WHITE);
             }
             this.tempIndex = index;
             textList.get(index).setFill(Color.RED);
        }

        }
// na svini kai an to vlaue einai sto next index logo hash
    public void deleteValue(ActionEvent event){

        String key = this.deleteValue.getText();
         int deletedIndex =table.delete(key);

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
        rectangleList.add(agent);
    }

    public void showTheHashFunction(String key){
        Label label =new Label("");
        label.setLayoutX(-250);
        label.setLayoutY(80);
        label.setTextFill(Color.RED);
        this.pane.getChildren().add(label);
        titleLabel.setVisible(true);

        int asciiNumbers=0;
        String finalHash="";
        for (int i=0;i<key.length();i++){

            asciiNumbers+=(int) key.charAt(i);
            label.setText(label.getText()+"ASCII value of : "+ key.charAt(i) + "    is :"+(int) key.charAt(i)+"\n");

            finalHash=finalHash+(int) key.charAt(i)+"+";
        }

         int sizeofString=  finalHash.length();
        finalHash=finalHash.substring(0,sizeofString-1);
        int result=asciiNumbers %15;
        label.setText(label.getText()+finalHash+" % 15 ="+ String.valueOf(result));
        TranslateTransition transition=new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setNode(label);
        transition.setToX(500);

        transition.setOnFinished(e->{

            FadeTransition fadeOut=new FadeTransition(Duration.seconds(4),label);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(a->{
                titleLabel.setVisible(false);
            });
            fadeOut.play();

        });
        transition.play();
    }
    }
