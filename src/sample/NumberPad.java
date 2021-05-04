package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.text.NumberFormat;

public class NumberPad {


    public static TextField enteredValue;
    public static Button enterBtn;
    public static Pane calc;
    public static String answer;

    //opening a pane for number pad
    public static Pane calc(){

            //adding a help button
            Button helpBtn= new Button("Help");
            helpBtn.setStyle("-fx-background-Color:red;-fx-text-fill:white;-fx-font-Weight:Bold;-fx-text-Align:center;-fx-padding:10px;");
            helpBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("HELP");
                    alert.setHeaderText("How To Use Calculator");
                    alert.setContentText("Click the numbers needed and click respective text field, then the enter button to begin entering values to the fields followed.");
                    alert.showAndWait();
                }
            });

            //aligning the help button
            helpBtn.setLayoutX(200);
            helpBtn.setLayoutY(70);
            helpBtn.setMinSize(100,50);

            //adding the buttons and text fields to the number pad
            Button number0 = new Button("0");
            number0.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button number1 = new Button("1");
            number1.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button number2 = new Button("2");
            number2.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button number3 = new Button("3");
            number3.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button number4 = new Button("4");
            number4.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button number5 = new Button("5");
            number5.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button number6 = new Button("6");
            number6.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button number7 = new Button("7");
            number7.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button number8 = new Button("8");
            number8.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button number9 = new Button("9");
            number9.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button numberDecimal = new Button(".");
            numberDecimal.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:black;-fx-opacity:0.7;-fx-text-fill:white");
            Button numberClear = new Button("C");
            numberClear.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:red yellow;-fx-opacity:0.7;-fx-text-fill:white");


            enteredValue= new TextField();
            enteredValue.setLayoutY(220);
            enteredValue.setLayoutX(60);

            enterBtn=new Button("->");
            enterBtn.setStyle("-fx-font-weight:bold;-fx-background-color:lightgreen;-fx-text-fill:brown");
            enterBtn.setLayoutY(260);
            enterBtn.setLayoutX(130);

            TextField enterValue =new TextField();
            enterValue.setLayoutY(20);
            enterValue.setLayoutX(60);

            //aligning the buttons and text fields to the number pad
            number0.setLayoutX(120);
            number0.setLayoutY(500);
            number0.setMinSize(70, 60);
            number1.setLayoutX(45);
            number1.setLayoutY(435);
            number1.setMinSize(70, 60);
            number2.setLayoutX(120);
            number2.setLayoutY(435);
            number2.setMinSize(70, 60);
            number3.setLayoutX(195);
            number3.setLayoutY(435);
            number3.setMinSize(70, 60);
            number4.setLayoutX(45);
            number4.setLayoutY(370);
            number4.setMinSize(70, 60);
            number5.setLayoutX(120);
            number5.setLayoutY(370);
            number5.setMinSize(70, 60);
            number6.setLayoutX(195);
            number6.setLayoutY(370);
            number6.setMinSize(70, 60);
            number7.setLayoutX(45);
            number7.setLayoutY(305);
            number7.setMinSize(70, 60);
            number8.setLayoutX(120);
            number8.setLayoutY(305);
            number8.setMinSize(70, 60);
            number9.setLayoutX(195);
            number9.setLayoutY(305);
            number9.setMinSize(70, 60);
            numberDecimal.setLayoutX(45);
            numberDecimal.setLayoutY(500);
            numberDecimal.setMinSize(70, 60);
            numberClear.setLayoutX(195);
            numberClear.setLayoutY(500);
            numberClear.setMinSize(70, 60);



                    number0.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number0Txt = NumberPad.enteredValue.getText() + number0.getText();
                            NumberPad.enteredValue.setText(number0Txt);
                        }
                    });
                    number1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number1Txt = NumberPad.enteredValue.getText() + number1.getText();
                            NumberPad.enteredValue.setText(number1Txt);
                        }
                    });
                    number2.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number1Txt = NumberPad.enteredValue.getText() + number2.getText();
                            NumberPad.enteredValue.setText(number1Txt);
                        }
                    });
                    number3.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number1Txt = NumberPad.enteredValue.getText() + number3.getText();
                            NumberPad.enteredValue.setText(number1Txt);
                        }
                    });
                    number4.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number1Txt = NumberPad.enteredValue.getText() + number4.getText();
                            NumberPad.enteredValue.setText(number1Txt);
                        }
                    });
                    number5.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number5Txt = NumberPad.enteredValue.getText() + number5.getText();
                            NumberPad.enteredValue.setText(number5Txt);
                        }
                    });
                    number6.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number1Txt = NumberPad.enteredValue.getText() + number6.getText();
                            NumberPad.enteredValue.setText(number1Txt);
                        }
                    });
                    number7.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number1Txt = NumberPad.enteredValue.getText() + number7.getText();
                            NumberPad.enteredValue.setText(number1Txt);
                        }
                    });
                    number8.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number1Txt = NumberPad.enteredValue.getText() + number8.getText();
                            NumberPad.enteredValue.setText(number1Txt);
                        }
                    });
                    number9.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number1Txt = NumberPad.enteredValue.getText() + number9.getText();
                            NumberPad.enteredValue.setText(number1Txt);
                        }
                    });
                    numberDecimal.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String number1Txt = NumberPad.enteredValue.getText() + numberDecimal.getText();
                            NumberPad.enteredValue.setText(number1Txt);
                        }
                    });
                    numberClear.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            NumberPad.enteredValue.setText("");
                        }
                    });

            Image nImage = new Image("file:numberpad.jpg");
            ImageView numberpadImage = new ImageView(nImage);
            numberpadImage.setFitWidth(300);
            numberpadImage.setFitHeight(600);


            calc = new Pane();
            calc.getChildren().addAll(numberpadImage,enteredValue,enterBtn,helpBtn,number0, number1, number2, number3, number4, number5, number6, number7, number8, number9, numberClear, numberDecimal);
            return calc;
        }

        public  static String JoinNumberpad() {
            NumberPad.enterBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    answer = NumberPad.enteredValue.getText();
                }
            });

            if (!NumberPad.enterBtn.isPressed()) {
                return answer ;
            } else {
                return "";
            }

        }






}
