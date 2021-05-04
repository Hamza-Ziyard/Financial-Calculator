package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.*;
import java.text.NumberFormat;

public class MortgageTab {
    Tab joiningMortgageTab;
    //make constructor of class
    public MortgageTab(Tab joiningMortgageTab){
        this.joiningMortgageTab = joiningMortgageTab;
    }

    //initiating the print writer
    PrintWriter printMortgage;

    // making function
    public void mortgageFunction() throws IOException {
        //calling the file of the past details to be entered
        File file = new File("Mortgage.txt");
        file.createNewFile();


        //making the buttons,labels and text fields
        Button calculateBtn =new Button("Calculate");
        calculateBtn.setStyle("-fx-padding:10px 25px;-fx-background-Color:green;-fx-text-fill:white;-fx-font-Size:20px;");
        calculateBtn.setMinSize(220,40);

        Label topicLbl =new Label("Mortgage Calculator");
        topicLbl.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;");
        Label principalLbl =new Label("Principal Value: ");
        principalLbl.setStyle("-fx-font-Weight:bold;");
        TextField principalTxt =new TextField();
        principalTxt.setPromptText("$");
        Label principalOutputLbl=new Label();
        principalOutputLbl.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");

        Label downPaymentLbl =new Label("Down Payment: ");
        downPaymentLbl.setStyle("-fx-font-Weight:bold;");
        TextField downPaymentTxt =new TextField();
        downPaymentTxt.setPromptText("$");
        Label downPaymentOutputLbl=new Label();
        downPaymentOutputLbl.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");

        Label interestLbl =new Label("Interest Value: ");
        interestLbl.setStyle("-fx-font-Weight:bold;");
        TextField interestTxt =new TextField();
        interestTxt.setPromptText("%");
        Label interestOutputLbl=new Label();
        interestOutputLbl.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");

        Label periodLbl =new Label("Periods (Years): ");
        periodLbl.setStyle("-fx-font-Weight:bold;");
        TextField periodTxt =new TextField();
        periodTxt.setPromptText("yrs");
        Label periodOutputLbl=new Label();
        periodOutputLbl.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");

        Label finalValueLbl =new Label("Monthly Pay");
        finalValueLbl.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:gray;-fx-padding:15px;");
        Label finalValueOutput =new Label();
        finalValueOutput.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");

        Label errorLbl=new Label();
        errorLbl.setLayoutY(400);
        errorLbl.setLayoutX(450);
        errorLbl.setStyle("-fx-padding:5px;-fx-text-fill:black;-fx-font-Size:30px;-fx-font-Weight:bold;");

        //aligning all labels, buttons and text fields
        calculateBtn.setLayoutX(100);
        calculateBtn.setLayoutY(320);
        topicLbl.setLayoutX(50);
        topicLbl.setLayoutY(40);
        principalLbl.setLayoutX(100);
        principalLbl.setLayoutY(120);
        principalOutputLbl.setLayoutX(500);
        principalOutputLbl.setLayoutY(260);
        principalTxt.setLayoutX(250);
        principalTxt.setLayoutY(120);
        downPaymentLbl.setLayoutX(100);
        downPaymentLbl.setLayoutY(170);
        downPaymentOutputLbl.setLayoutX(500);
        downPaymentOutputLbl.setLayoutY(290);
        downPaymentTxt.setLayoutX(250);
        downPaymentTxt.setLayoutY(170);
        interestLbl.setLayoutX(100);
        interestLbl.setLayoutY(220);
        interestOutputLbl.setLayoutX(500);
        interestOutputLbl.setLayoutY(320);
        interestTxt.setLayoutX(250);
        interestTxt.setLayoutY(220);
        periodLbl.setLayoutX(100);
        periodLbl.setLayoutY(270);
        periodOutputLbl.setLayoutX(500);
        periodOutputLbl.setLayoutY(350);
        periodTxt.setLayoutX(250);
        periodTxt.setLayoutY(270);
        finalValueLbl.setLayoutY(120);
        finalValueLbl.setLayoutX(500);
        finalValueOutput.setLayoutY(130);
        finalValueOutput.setLayoutX(700);

        //---------------------------------------------------------------------------------
        //adding the function to the calculate button
        calculateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //reading entered data to the mortgage text to be printed
                try {
                    printMortgage = new PrintWriter(new FileWriter(file, true));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //for not crashing errors if any other inputs other than numbers are entered
                try {
                    final int months=12;
                    final int percent=100;
                    String principalValue=principalTxt.getText();
                    String downPayment =downPaymentTxt.getText();
                    String interestRate=interestTxt.getText();
                    String period=periodTxt.getText();

                    //to prompt an error if the text fields are left empty
                    if (principalValue.equals("") && downPayment.equals("") && interestRate.equals("") &&period.equals("")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Your values need to be entered");
                        alert.showAndWait();
                    }
                    else if (principalValue.equals("")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please enter in the Home Price");
                        alert.showAndWait();
                    }
                    else if(downPayment.equals("")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Down Payment");
                        alert.showAndWait();
                    }
                    else if (interestRate.equals("")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Interest Rate");
                        alert.showAndWait();
                    }
                    else if (period.equals("")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in No of years");
                        alert.showAndWait();
                    }
                    else {

                        //calculation to find the monthly pay of the mortgage loan
                        int noOfPayments=Integer.parseInt(period)*months;
                        double monthlyInterestRate = Double.parseDouble(interestRate) / percent / months;
                        double loanAmount=Double.parseDouble(principalValue)-Double.parseDouble(downPayment);
                        double monthlyValue = (loanAmount * monthlyInterestRate * Math.pow(1 + (monthlyInterestRate), noOfPayments) / (Math.pow(1 + (monthlyInterestRate), noOfPayments) - 1));


                        String mValue = NumberFormat.getCurrencyInstance().format(monthlyValue);
                        finalValueOutput.setText(mValue);
                        String homePrice = NumberFormat.getCurrencyInstance().format(Double.parseDouble(principalValue));
                        principalOutputLbl.setText("Home Price :\t\t\t\t" + homePrice);
                        String downPaymnt = NumberFormat.getCurrencyInstance().format(Double.parseDouble(downPayment));
                        downPaymentOutputLbl.setText("Down Payment :\t\t\t" + downPaymnt);
                        interestOutputLbl.setText("Interest Rate :\t\t\t\t" + interestRate + "%");
                        periodOutputLbl.setText("Time Period :\t\t\t\t" + period + "yrs");

                        //the values and method to be printed to the text
                        printMortgage.println("\tYears :- "+period+" years");
                        printMortgage.println("\tInterest Rate :- "+interestRate+"%");              //{ details }
                        printMortgage.println("\tDown Payment :- "+downPayment);
                        printMortgage.println("\tHome Price :- "+homePrice);
                        printMortgage.println("\tMonthly Pay :- "+mValue);

                        printMortgage.println("\n\tMortgage History Details ( "+java.time.LocalDateTime.now()+" )\n");          // { heading }
                    }
                    printMortgage.close();

                } catch (NumberFormatException e) {
                   errorLbl.setText("---ENTER NUMBERS ONLY---");
                }
                }
            });


        //--------------------------------------------------------------------
        //Joining the Number pad to the pane


        principalTxt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                principalTxt.setText(NumberPad.JoinNumberpad());
            }
        });
        downPaymentTxt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               downPaymentTxt.setText(NumberPad.JoinNumberpad());
            }
        });
        interestTxt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                interestTxt.setText(NumberPad.JoinNumberpad());
            }
        });
        periodTxt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                periodTxt.setText(NumberPad.JoinNumberpad());
            }
        });


        //Setting the Background image
        Image mImage = new Image("file:mortgage1.jpg");
        ImageView mortgageImage = new ImageView(mImage);
        mortgageImage.setFitHeight(550);
        mortgageImage.setFitWidth(1000);
        mortgageImage.setStyle("-fx-opacity:0.7;");


        //add inside tab
        Pane displayBox =new Pane();
        displayBox.getChildren().addAll(mortgageImage,principalOutputLbl,downPaymentOutputLbl,interestOutputLbl,periodOutputLbl,calculateBtn,topicLbl,principalLbl,periodLbl,downPaymentLbl,downPaymentTxt,interestLbl,principalTxt,interestTxt,periodTxt,finalValueLbl,finalValueOutput,errorLbl);
        joiningMortgageTab.setContent(displayBox);

    }
}



