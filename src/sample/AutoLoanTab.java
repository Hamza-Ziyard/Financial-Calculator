package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.*;
import java.text.NumberFormat;


public class AutoLoanTab {

    Tab joiningAutoLoanTab;
    //make constructor of class
    public AutoLoanTab(Tab joiningAutoLoanTab){
        this.joiningAutoLoanTab = joiningAutoLoanTab;
    }

    //initiating the print writer
    PrintWriter printAutoloan;

    // making function
    public void autoLoanFunction() throws IOException {
        File file = new File("AutoLoan.txt");
        file.createNewFile();

        //Heading label
        Label topicLbl =new Label("Auto Loan Calculator");
        topicLbl.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;");
        TabPane subPane =new TabPane();

        //create sub tab 1

        //adding the labels,button and text fields to subtab 1
        Tab subTab1 =new Tab("Total Price");
        subTab1.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;-fx-padding:5px");
        Pane contents1 = new Pane();
        subTab1.setClosable(false);

        Button calculateBtn1 =new Button("Calculate");
        calculateBtn1.setStyle("-fx-padding:10px 20px;-fx-background-Color:green;-fx-text-fill:white;-fx-font-Size:20px;");
        calculateBtn1.setMinSize(220,40);

        Label autoPriceLbl1 =new Label("Auto Price : ");
        autoPriceLbl1.setStyle("-fx-font-Weight:bold");
        TextField autoPriceTxt1 =new TextField();
        autoPriceTxt1.setPromptText("$");

        Label downPaymentLbl1 =new Label("Down Payment : ");
        downPaymentLbl1.setStyle("-fx-font-Weight:bold");
        TextField downPaymentTxt1 =new TextField();
        downPaymentTxt1.setPromptText("$");

        Label interestLbl1 =new Label("Interest Value : ");
        interestLbl1.setStyle("-fx-font-Weight:bold");
        TextField interestTxt1 =new TextField();
        interestTxt1.setPromptText("%");

        Label periodLbl1 =new Label("Loan term (Years) : ");
        periodLbl1.setStyle("-fx-font-Weight:bold");
        TextField periodTxt1 =new TextField();
        periodTxt1.setPromptText("yrs");

        Label salesTaxLbl1 =new Label("Sales Tax (%) : ");
        salesTaxLbl1.setStyle("-fx-font-Weight:bold");
        TextField salesTaxTxt1 =new TextField();
        salesTaxTxt1.setPromptText("%");

        Label feeLbl1 =new Label("Fees : ");
        feeLbl1.setStyle("-fx-font-Weight:bold");
        TextField feeTxt1 =new TextField();
        feeTxt1.setPromptText("$");

        Label downPaymentOutputLbl1=new Label();
        downPaymentOutputLbl1.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label autoPriceOutputLbl=new Label();
        autoPriceOutputLbl.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label periodOutputLbl1=new Label();
        periodOutputLbl1.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label interestOutputLbl1=new Label();
        interestOutputLbl1.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label salesTaxOutputLbl1=new Label();
        salesTaxOutputLbl1.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");

        Label finalValueLbl1 =new Label("Monthly Pay");
        finalValueLbl1.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:gray;-fx-padding:15px;");
        Label finalValueOutput1 =new Label();
        finalValueOutput1.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label finalValueOutput2 =new Label();
        finalValueOutput2.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");

        Label errorLbl=new Label();
        errorLbl.setStyle("-fx-padding:5px;-fx-text-fill:black;-fx-opacity:0.7;-fx-font-Size:30px;-fx-font-Weight:bold;");


        //aligning the button, labels and text fields of subtab 1
        calculateBtn1.setLayoutX(120);
        calculateBtn1.setLayoutY(420);
        topicLbl.setLayoutX(50);
        topicLbl.setLayoutY(70);
        autoPriceLbl1.setLayoutX(100);
        autoPriceLbl1.setLayoutY(100);
        autoPriceTxt1.setLayoutX(250);
        autoPriceTxt1.setLayoutY(100);
        downPaymentLbl1.setLayoutX(100);
        downPaymentLbl1.setLayoutY(150);
        downPaymentTxt1.setLayoutX(250);
        downPaymentTxt1.setLayoutY(150);
        interestLbl1.setLayoutX(100);
        interestLbl1.setLayoutY(200);
        interestTxt1.setLayoutX(250);
        interestTxt1.setLayoutY(200);
        periodLbl1.setLayoutX(100);
        periodLbl1.setLayoutY(250);
        periodTxt1.setLayoutX(250);
        periodTxt1.setLayoutY(250);
        salesTaxLbl1.setLayoutX(100);
        salesTaxLbl1.setLayoutY(300);
        salesTaxTxt1.setLayoutX(250);
        salesTaxTxt1.setLayoutY(300);
        feeLbl1.setLayoutX(100);
        feeLbl1.setLayoutY(350);
        feeTxt1.setLayoutX(250);
        feeTxt1.setLayoutY(350);
        errorLbl.setLayoutY(430);
        errorLbl.setLayoutX(450);
        autoPriceOutputLbl.setLayoutX(500);
        autoPriceOutputLbl.setLayoutY(250);
        downPaymentOutputLbl1.setLayoutX(500);
        downPaymentOutputLbl1.setLayoutY(280);
        interestOutputLbl1.setLayoutX(500);
        interestOutputLbl1.setLayoutY(310);
        periodOutputLbl1.setLayoutX(500);
        periodOutputLbl1.setLayoutY(340);
        salesTaxOutputLbl1.setLayoutX(500);
        salesTaxOutputLbl1.setLayoutY(370);
        finalValueLbl1.setLayoutY(120);
        finalValueLbl1.setLayoutX(500);
        finalValueOutput1.setLayoutY(140);
        finalValueOutput1.setLayoutX(700);
        finalValueOutput2.setLayoutY(140);
        finalValueOutput2.setLayoutX(700);

        //---------------------------------------------------------------------------------
        //adding the function to the calculate button 1
        calculateBtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //reading entered data to the autoloan text to be printed
                try {
                    printAutoloan = new PrintWriter(new FileWriter(file, true));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //for not crashing errors if any other inputs other than numbers are entered
                try {
                    final int months = 12;
                    final int percent = 100;
                    String autoValue = autoPriceTxt1.getText();
                    String downPayment = downPaymentTxt1.getText();
                    String interestRate = interestTxt1.getText();
                    String period = periodTxt1.getText();
                    String salesTax = salesTaxTxt1.getText();

                    //to prompt an error if the text fields are left empty
                    if (autoValue.equals("") && downPayment.equals("") && interestRate.equals("") && period.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Your values need to be entered");
                        alert.showAndWait();
                    }
                    else if (autoValue.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please enter in the Home Price");
                        alert.showAndWait();
                    }
                    else if (downPayment.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Down Payment");
                        alert.showAndWait();
                    }
                    else if (interestRate.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Interest Rate");
                        alert.showAndWait();
                    }
                    else if (period.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter the No of years");
                        alert.showAndWait();
                    }
                    else {
                        //calculation to find the monthly pay of the auto loan
                        int noOfPayments = Integer.parseInt(period) * months;
                        double monthlyInterestRate = Double.parseDouble(interestRate) / percent / months;
                        double loanAmount = Double.parseDouble(autoValue) - Double.parseDouble(downPayment);
                        double monthlyValue = (loanAmount * monthlyInterestRate * Math.pow(1 + (monthlyInterestRate), noOfPayments) / (Math.pow(1 + (monthlyInterestRate), noOfPayments) - 1));

                        String mValue = NumberFormat.getCurrencyInstance().format(monthlyValue);
                        finalValueOutput1.setText(mValue);

                        String autoPrice = NumberFormat.getCurrencyInstance().format(Double.parseDouble(autoValue));
                        autoPriceOutputLbl.setText("Auto Price :\t\t\t\t" + autoPrice);
                        String downPaymnt = NumberFormat.getCurrencyInstance().format(Double.parseDouble(downPayment));
                        downPaymentOutputLbl1.setText("Down Payment :\t\t\t" + downPaymnt);
                        interestOutputLbl1.setText("Interest Rate :\t\t\t\t" + interestRate + "%");
                        periodOutputLbl1.setText("Time Period :\t\t\t\t" + period + " years");
                        salesTaxOutputLbl1.setText("Sales Tax :\t\t\t\t" + salesTax + "%");

                        //the values and method to be printed to the text
                        printAutoloan.println("\tSales Tax :- "+salesTax+"%");
                        printAutoloan.println("\tYears :- "+period+" years");
                        printAutoloan.println("\tInterest Rate :- "+interestRate+"%");
                        printAutoloan.println("\tDown Payment :- "+downPayment);
                        printAutoloan.println("\tAuto Price :- "+autoPrice);
                        printAutoloan.println("\tMonthly Pay :- "+mValue);

                        printAutoloan.println("\n\tAuto Loan History Details ( "+ java.time.LocalDateTime.now()+" )\n");

                    }
                    printAutoloan.close();
                } catch (NumberFormatException e) {
                    errorLbl.setText("---ENTER NUMBERS ONLY---");
                }
            }
            });

        //setting the background image for the sub tab 1
        Image aImage1 = new Image("file:autoloan1.jpg");
        ImageView autoloanImage1 = new ImageView(aImage1);
        autoloanImage1.setFitHeight(500);
        autoloanImage1.setFitWidth(1000);
        autoloanImage1.setStyle("-fx-opacity:0.7;");

        //calling sub tab 1
        subPane.getTabs().addAll(subTab1);
        contents1.getChildren().addAll(autoloanImage1,errorLbl,finalValueOutput1,autoPriceOutputLbl,downPaymentOutputLbl1,interestOutputLbl1,periodOutputLbl1,salesTaxOutputLbl1,finalValueLbl1,calculateBtn1,autoPriceLbl1,autoPriceTxt1,periodLbl1,periodTxt1,interestLbl1,interestTxt1,downPaymentLbl1,downPaymentTxt1,salesTaxLbl1,salesTaxTxt1,feeLbl1,feeTxt1);
        subTab1.setContent(contents1);

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //create sub tab 2

        //adding the labels,button and text fields to subtab 2
        Tab subTab2 =new Tab("Monthly Payment");
        subTab2.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;-fx-padding:5px");
        Pane contents2 = new Pane();
        subTab2.setClosable(false);

        Button calculateBtn2 =new Button("Calculate");
        calculateBtn2.setStyle("-fx-padding:10px 20px;-fx-background-Color:green;-fx-text-fill:white;-fx-font-Size:20px;");
        calculateBtn2.setMinSize(220,40);

        Label monthlyPayLbl2 =new Label("Monthly Pay : ");
        monthlyPayLbl2.setStyle("-fx-font-Weight:bold");
        TextField monthlyPayTxt2 =new TextField();
        monthlyPayTxt2.setPromptText("$");

        Label downPaymentLbl2 =new Label("Down Payment : ");
        downPaymentLbl2.setStyle("-fx-font-Weight:bold");
        TextField downPaymentTxt2 =new TextField();
        downPaymentTxt2.setPromptText("$");

        Label interestLbl2 =new Label("Interest Value : ");
        interestLbl2.setStyle("-fx-font-Weight:bold");
        TextField interestTxt2 =new TextField();
        interestTxt2.setPromptText("%");

        Label periodLbl2 =new Label("Loan term (Months) : ");
        periodLbl2.setStyle("-fx-font-Weight:bold");
        TextField periodTxt2 =new TextField();
        periodTxt2.setPromptText("mns");

        Label salesTaxLbl2 =new Label("Sales Tax (%) : ");
        salesTaxLbl2.setStyle("-fx-font-Weight:bold");
        TextField salesTaxTxt2 =new TextField();
        salesTaxTxt2.setPromptText("%");

        Label feeLbl2 =new Label("Fees : ");
        feeLbl2.setStyle("-fx-font-Weight:bold");
        TextField feeTxt2 =new TextField();
        feeTxt2.setPromptText("$");

        Label finalValueLbl2 =new Label("Auto Price");
        finalValueLbl2.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:gray;-fx-padding:15px;");

        Label downPaymentOutputLbl2=new Label();
        downPaymentOutputLbl2.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label vehiclePriceOutputLbl=new Label();
        vehiclePriceOutputLbl.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label periodOutputLbl2=new Label();
        periodOutputLbl2.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label interestOutputLbl2=new Label();
        interestOutputLbl2.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label salesTaxOutputLbl2=new Label();
        salesTaxOutputLbl2.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");

        Label errorLbl2=new Label();
        errorLbl2.setStyle("-fx-padding:5px;-fx-text-fill:black;-fx-opacity:0.7;-fx-font-Size:30px;-fx-font-Weight:bold;");


        //aligning the button, labels and text fields of subtab 1
        calculateBtn2.setLayoutX(120);
        calculateBtn2.setLayoutY(420);
        topicLbl.setLayoutX(50);
        topicLbl.setLayoutY(70);
        monthlyPayLbl2.setLayoutX(100);
        monthlyPayLbl2.setLayoutY(100);
        monthlyPayTxt2.setLayoutX(250);
        monthlyPayTxt2.setLayoutY(100);
        downPaymentLbl2.setLayoutX(100);
        downPaymentLbl2.setLayoutY(150);
        downPaymentTxt2.setLayoutX(250);
        downPaymentTxt2.setLayoutY(150);
        interestLbl2.setLayoutX(100);
        interestLbl2.setLayoutY(200);
        interestTxt2.setLayoutX(250);
        interestTxt2.setLayoutY(200);
        periodLbl2.setLayoutX(100);
        periodLbl2.setLayoutY(250);
        periodTxt2.setLayoutX(250);
        periodTxt2.setLayoutY(250);
        salesTaxLbl2.setLayoutX(100);
        salesTaxLbl2.setLayoutY(300);
        salesTaxTxt2.setLayoutX(250);
        salesTaxTxt2.setLayoutY(300);
        feeLbl2.setLayoutX(100);
        feeLbl2.setLayoutY(350);
        feeTxt2.setLayoutX(250);
        feeTxt2.setLayoutY(350);

        vehiclePriceOutputLbl.setLayoutX(500);
        vehiclePriceOutputLbl.setLayoutY(250);
        downPaymentOutputLbl2.setLayoutX(500);
        downPaymentOutputLbl2.setLayoutY(280);
        interestOutputLbl2.setLayoutX(500);
        interestOutputLbl2.setLayoutY(310);
        periodOutputLbl2.setLayoutX(500);
        periodOutputLbl2.setLayoutY(340);
        salesTaxOutputLbl2.setLayoutX(500);
        salesTaxOutputLbl2.setLayoutY(370);
        finalValueLbl2.setLayoutY(120);
        finalValueLbl2.setLayoutX(500);
        errorLbl2.setLayoutY(430);
        errorLbl2.setLayoutX(450);

        //---------------------------------------------------------------------------------
        //adding the function to the calculate button 2

        calculateBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //reading entered data to the autoloan text to be printed
                try {
                    printAutoloan = new PrintWriter(new FileWriter(file, true));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //for not crashing errors if any other inputs other than numbers are entered
                try {
                    final int percent = 100;
                    String monthlyPay = monthlyPayTxt2.getText();
                    String downPayment2 = downPaymentTxt2.getText();
                    String salesT2 = salesTaxTxt2.getText();
                    String interestRate2 = interestTxt2.getText();
                    String period2 = periodTxt2.getText();

                    //to prompt an error if the text fields are left empty
                    if (monthlyPay.equals("") && downPayment2.equals("") && interestRate2.equals("") && period2.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Your values need to be entered");
                        alert.showAndWait();
                    }
                    else if (monthlyPay.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please enter in the Home Price");
                        alert.showAndWait();
                    }
                    else if (downPayment2.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Down Payment");
                        alert.showAndWait();
                    }
                    else if (interestRate2.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Interest Rate");
                        alert.showAndWait();
                    }
                    else if (period2.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in No of years");
                        alert.showAndWait();
                    }
                    else {
                        //calculation to find the vehicle price of the auto loan
                        double monthlyInterestRate = Double.parseDouble(interestRate2) / percent ;
                        double vehiclePrice = ((Double.parseDouble(monthlyPay) * (Math.pow(1 + monthlyInterestRate /12, Double.parseDouble(period2)) - 1)) / ((monthlyInterestRate / 12) * (Math.pow(1 + monthlyInterestRate / 12, Double.parseDouble(period2))))) + Double.parseDouble(downPayment2);
                        String vValue = NumberFormat.getCurrencyInstance().format(vehiclePrice);
                        finalValueOutput2.setText(vValue);

                        String mPay = NumberFormat.getCurrencyInstance().format(Double.parseDouble(monthlyPay));
                        vehiclePriceOutputLbl.setText("Monthly Pay :\t\t\t\t" + mPay);
                        String downPaymnt = NumberFormat.getCurrencyInstance().format(Double.parseDouble(downPayment2));
                        downPaymentOutputLbl2.setText("Down Payment :\t\t\t" + downPaymnt);
                        interestOutputLbl2.setText("Interest Rate :\t\t\t\t" + interestRate2 + "%");
                        periodOutputLbl2.setText("Time Period :\t\t\t\t" + period2 + " months");
                        salesTaxOutputLbl2.setText("Sales Tax :\t\t\t\t" + salesT2 + "%");

                        //the values and method to be printed to the text
                        printAutoloan.println("\tSales Tax :- "+salesT2+"%");
                        printAutoloan.println("\tMonths :- "+period2+" months");
                        printAutoloan.println("\tInterest Rate :- "+interestRate2+"%");                     //{ details }
                        printAutoloan.println("\tDown Payment :- "+downPayment2);
                        printAutoloan.println("\tMonthly Pay :- "+mPay);
                        printAutoloan.println("\tAuto Price :- "+vValue);

                        printAutoloan.println("\n\tAuto Loan History Details ( "+ java.time.LocalDateTime.now()+" )\n");        // { heading }

                    }
                } catch (NumberFormatException e) {
                    errorLbl2.setText("---ENTER NUMBERS ONLY---");
                }
                printAutoloan.close();
            }
        });

        //setting the background image for sub tab 2
        Image aImage2 = new Image("file:autoloan1.jpg");
        ImageView autoloanImage2 = new ImageView(aImage2);
        autoloanImage2.setFitHeight(500);
        autoloanImage2.setFitWidth(1000);
        autoloanImage2.setStyle("-fx-opacity:0.7;");

        //sub tab 2 calling
        subPane.getTabs().addAll(subTab2);
        contents2.getChildren().addAll(autoloanImage2,errorLbl2,finalValueOutput2,vehiclePriceOutputLbl,downPaymentOutputLbl2,interestOutputLbl2,periodOutputLbl2,salesTaxOutputLbl2,finalValueLbl2,calculateBtn2,monthlyPayLbl2,monthlyPayTxt2,periodLbl2,periodTxt2,interestLbl2,interestTxt2,downPaymentLbl2,downPaymentTxt2,salesTaxLbl2,salesTaxTxt2,feeLbl2,feeTxt2);
        subTab2.setContent(contents2);


        //add inside tab
        Pane displayBox =new Pane(subPane);
        displayBox.getChildren().addAll(topicLbl);
        joiningAutoLoanTab.setContent(displayBox);

        //--------------------------------------------------------------------
        //Joining the Number pad to the pane

        //joining the numberpad to the tab1 (total price tab)
        autoPriceTxt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                autoPriceTxt1.setText(NumberPad.JoinNumberpad());
            }
        });
        downPaymentTxt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                downPaymentTxt1.setText(NumberPad.JoinNumberpad());
            }
        });
        interestTxt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                interestTxt1.setText(NumberPad.JoinNumberpad());
            }
        });
        periodTxt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                periodTxt1.setText(NumberPad.JoinNumberpad());
            }
        });
        salesTaxTxt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                salesTaxTxt1.setText(NumberPad.JoinNumberpad());
            }
        });
        feeTxt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                feeTxt1.setText(NumberPad.JoinNumberpad());
            }
        });


        //joining the numberpad to the tab2 (total price tab)
        monthlyPayTxt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                monthlyPayTxt2.setText(NumberPad.JoinNumberpad());
            }
        });
        downPaymentTxt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                downPaymentTxt2.setText(NumberPad.JoinNumberpad());
            }
        });
        interestTxt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                interestTxt2.setText(NumberPad.JoinNumberpad());
            }
        });
        periodTxt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                periodTxt2.setText(NumberPad.JoinNumberpad());
            }
        });
        salesTaxTxt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                salesTaxTxt2.setText(NumberPad.JoinNumberpad());
            }
        });
        feeTxt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                feeTxt2.setText(NumberPad.JoinNumberpad());
            }
        });

    }
}


