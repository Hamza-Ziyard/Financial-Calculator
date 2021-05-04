package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;

public class FinanceTab {
    Tab joiningFinanceTab;

    //make constructor of class
    public FinanceTab(Tab joiningFinanceTab){
        this.joiningFinanceTab = joiningFinanceTab;
    }

    //initiating the print writer
    PrintWriter printFinance;

    // making function
    public void financeFunction() throws IOException {
        //calling the file of the past details to be entered
        File file = new File("Finance.txt");
        file.createNewFile();

        //Heading label
        Label topicLbl =new Label("Finance Calculator");
        topicLbl.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;");
        TabPane subPane =new TabPane();

        //results displaying label
        Label finalValueLbl =new Label("Results");
        finalValueLbl.setStyle("-fx-font-Size:25px;-fx-font-Weight:bold;-fx-background-Color:gray;-fx-padding:15px;");

        //aligning results displaying label
        finalValueLbl.setLayoutY(140);
        finalValueLbl.setLayoutX(540);
        subPane.setMinWidth(1000);

        //present value displaying label
        Label presentValueLbl =new Label("Present Value");
        presentValueLbl.setStyle("-fx-font-Size:20px;-fx-font-Weight:bold;-fx-background-Color:gray;-fx-padding:15px;");

        //aligning PV label
        presentValueLbl.setLayoutX(540);
        presentValueLbl.setLayoutY(200);


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //create sub tab 1

        Tab subTab1 =new Tab("FV");
        subTab1.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;-fx-padding:5px");
        Pane contents1 = new Pane();
        subTab1.setClosable(false);

        //adding the labels,button and text fields to subtab 1
        Button calculateBtn1 =new Button("Calculate");
        calculateBtn1.setStyle("-fx-padding:10px 20px;-fx-background-Color:green;-fx-text-fill:white;-fx-font-Size:20px;");
        calculateBtn1.setMinSize(220,40);

        Label principalLbl1 =new Label("Principal Value: ");
        principalLbl1.setStyle("-fx-font-Weight:bold;");
        TextField principalTxt1 =new TextField();
        Label principalOutputLbl1=new Label();
        principalOutputLbl1.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        principalTxt1.setPromptText("$");

        Label pmtLbl1 =new Label("PMT (Annuity Payment): ");
        pmtLbl1.setStyle("-fx-font-Weight:bold;");
        TextField pmtTxt1 =new TextField();
        Label pmtOutputLbl1=new Label();
        pmtOutputLbl1.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        pmtTxt1.setPromptText("$");

        Label interestLbl1 =new Label("Interest Value: ");
        interestLbl1.setStyle("-fx-font-Weight:bold;");
        TextField interestTxt1 =new TextField();
        Label interestOutputLbl1=new Label();
        interestOutputLbl1.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        interestTxt1.setPromptText("%");

        Label periodLbl1 =new Label("Periods (Years): ");
        periodLbl1.setStyle("-fx-font-Weight:bold;");
        TextField periodTxt1 =new TextField();
        Label periodOutputLbl1=new Label();
        periodOutputLbl1.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        periodTxt1.setPromptText("yrs");

        Label errorLbl1=new Label();
        errorLbl1.setStyle("-fx-padding:5px;-fx-text-fill:black;-fx-opacity:0.7;-fx-font-Size:30px;-fx-font-Weight:bold;");

        Label finalValueOutput1 =new Label();
        finalValueOutput1.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");

        Label presentValueOutput1 =new Label();
        presentValueOutput1.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");



        //aligning the labels,button and text fields to subtab 1
        calculateBtn1.setLayoutX(100);
        calculateBtn1.setLayoutY(320);
        topicLbl.setLayoutX(50);
        topicLbl.setLayoutY(70);
        principalLbl1.setLayoutX(100);
        principalLbl1.setLayoutY(100);
        principalTxt1.setLayoutX(290);
        principalTxt1.setLayoutY(100);
        pmtLbl1.setLayoutX(100);
        pmtLbl1.setLayoutY(150);
        pmtTxt1.setLayoutX(290);
        pmtTxt1.setLayoutY(150);
        interestLbl1.setLayoutX(100);
        interestLbl1.setLayoutY(200);
        interestTxt1.setLayoutX(290);
        interestTxt1.setLayoutY(200);
        periodLbl1.setLayoutX(100);
        periodLbl1.setLayoutY(250);
        periodTxt1.setLayoutX(290);
        periodTxt1.setLayoutY(250);

        principalOutputLbl1.setLayoutX(530);
        principalOutputLbl1.setLayoutY(250);
        pmtOutputLbl1.setLayoutX(530);
        pmtOutputLbl1.setLayoutY(280);
        interestOutputLbl1.setLayoutX(530);
        interestOutputLbl1.setLayoutY(310);
        periodOutputLbl1.setLayoutX(530);
        periodOutputLbl1.setLayoutY(340);
        errorLbl1.setLayoutY(430);
        errorLbl1.setLayoutX(450);
        finalValueOutput1.setLayoutY(110);
        finalValueOutput1.setLayoutX(680);
        presentValueOutput1.setLayoutY(170);
        presentValueOutput1.setLayoutX(720);


        //adding function to the calculate button of the sub tab 1
        calculateBtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //reading entered data to the mortgage text to be printed
                try {
                    printFinance = new PrintWriter(new FileWriter(file, true));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //for not crashing errors if any other inputs other than numbers are entered
                try{
                    final int percent = 100;
                    String principalValue1=principalTxt1.getText();
                    String pmtValue1=pmtTxt1.getText();
                    String interestRate1=interestTxt1.getText();
                    String period1=periodTxt1.getText();

                    //to prompt an error if the text fields are left empty
                    if (principalValue1.equals("") && pmtValue1.equals("") && interestRate1.equals("") && period1.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Your values need to be entered");
                        alert.showAndWait();
                    }
                    else if (principalValue1.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please enter in the Home Price");
                        alert.showAndWait();
                    }
                    else if (pmtValue1.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the PMT value (Annuity Payment)");
                        alert.showAndWait();
                    }
                    else if (interestRate1.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Interest Rate");
                        alert.showAndWait();
                    }
                    else if (period1.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in No of years");
                        alert.showAndWait();
                    }
                    else {
                        //calculation to find the future value of the finance loan
                        double period=Double.parseDouble(period1);
                        double interestRate = Double.parseDouble(interestRate1) / percent;
                        double fvValueD=((Double.parseDouble(principalValue1)*Math.pow(1+interestRate,period)) + (Double.parseDouble(pmtValue1)*((Math.pow(1+interestRate,period)-1))/interestRate));
                        String FVValue=NumberFormat.getCurrencyInstance().format(fvValueD);
                        finalValueOutput1.setText(FVValue);

                        double presentValue1=fvValueD * Math.pow(1+interestRate,-period);
                        String pvFinal=NumberFormat.getCurrencyInstance().format(presentValue1);
                        presentValueOutput1.setText(pvFinal);

                        String homePrice = NumberFormat.getCurrencyInstance().format(Double.parseDouble(principalValue1));
                        principalOutputLbl1.setText("Principal Value :\t\t\t" + homePrice);
                        String downPaymnt = NumberFormat.getCurrencyInstance().format(Double.parseDouble(pmtValue1));
                        pmtOutputLbl1.setText("PMT Value :\t\t\t\t" + downPaymnt);
                        interestOutputLbl1.setText("Interest Rate :\t\t\t\t" + interestRate1 + "%");
                        periodOutputLbl1.setText("Time Period :\t\t\t\t" + period1 + "yrs");

                        //the values and method to be printed to the text
                        printFinance.println("\tYears :- "+period1+" years");
                        printFinance.println("\tInterest Rate :- "+interestRate1+"%");              //{ details }
                        printFinance.println("\tPMT (Annuity Payment) :- "+downPaymnt);
                        printFinance.println("\tPrincipal Value :- "+homePrice);
                        printFinance.println("\tFuture Value :- "+FVValue);

                        printFinance.println("\n\tFinance History Details ( "+ LocalDateTime.now()+" )\n");          // { heading }
                    }
                    printFinance.close();
                } catch (NumberFormatException e) {
                    errorLbl1.setText("---ENTER NUMBERS ONLY---");
                }
            }
        });

        //setting the background image for the sub tab 1
        Image fImage1 = new Image("file:savings1.jpg");
        ImageView financeImage1 = new ImageView(fImage1);
        financeImage1.setFitHeight(500);
        financeImage1.setFitWidth(1000);
        financeImage1.setStyle("-fx-opacity:0.7;");

        //sub tab 1 calling
        subPane.getTabs().addAll(subTab1);
        contents1.getChildren().addAll(financeImage1,presentValueOutput1,periodOutputLbl1,interestOutputLbl1,pmtOutputLbl1,principalOutputLbl1,errorLbl1,finalValueOutput1,calculateBtn1,topicLbl,principalLbl1,periodLbl1,pmtLbl1,pmtTxt1,interestLbl1,principalTxt1,interestTxt1,periodTxt1,finalValueLbl);
        subTab1.setContent(contents1);

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //create sub tab2
        Tab subTab2 =new Tab("PMT");
        subTab2.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;-fx-padding:5px");
        Pane contents2 = new Pane();
        subTab2.setClosable(false);

        //adding the labels,button and text fields to subtab 2
        Button calculateBtn2 =new Button("Calculate");
        calculateBtn2.setStyle("-fx-padding:10px 20px;-fx-background-Color:green;-fx-text-fill:white;-fx-font-Size:20px;");
        calculateBtn2.setMinSize(220,40);

        Label principalLbl2 =new Label("Principal Value: ");
        principalLbl2.setStyle("-fx-font-Weight:bold;");
        Label principalOutputLbl2=new Label();
        principalOutputLbl2.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        TextField principalTxt2 =new TextField();
        principalTxt2.setPromptText("$");

        Label fvLbl2 =new Label("FV (Future Value): ");
        fvLbl2.setStyle("-fx-font-Weight:bold;");
        Label fvOutputLbl2=new Label();
        fvOutputLbl2.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        TextField fvTxt2 =new TextField();
        fvTxt2.setPromptText("$");

        Label interestLbl2 =new Label("Interest Value: ");
        interestLbl2.setStyle("-fx-font-Weight:bold;");
        Label interestOutputLbl2=new Label();
        interestOutputLbl2.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        TextField interestTxt2 =new TextField();
        interestTxt2.setPromptText("%");

        Label periodLbl2 =new Label("Periods (Years): ");
        periodLbl2.setStyle("-fx-font-Weight:bold;");
        Label periodOutputLbl2=new Label();
        periodOutputLbl2.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        TextField periodTxt2 =new TextField();
        periodTxt2.setPromptText("yrs");

        Label finalValueOutput2 =new Label();
        finalValueOutput2.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label errorLbl2=new Label();
        errorLbl2.setStyle("-fx-padding:5px;-fx-text-fill:black;-fx-opacity:0.7;-fx-font-Size:30px;-fx-font-Weight:bold;");

        Label presentValueOutput2 =new Label();
        presentValueOutput2.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");

        //aligning the labels,button and text fields to subtab 2
        calculateBtn2.setLayoutX(100);
        calculateBtn2.setLayoutY(320);
        principalLbl2.setLayoutX(100);
        principalLbl2.setLayoutY(100);
        principalTxt2.setLayoutX(290);
        principalTxt2.setLayoutY(100);
        fvLbl2.setLayoutX(100);
        fvLbl2.setLayoutY(150);
        fvTxt2.setLayoutX(290);
        fvTxt2.setLayoutY(150);
        interestLbl2.setLayoutX(100);
        interestLbl2.setLayoutY(200);
        interestTxt2.setLayoutX(290);
        interestTxt2.setLayoutY(200);
        periodLbl2.setLayoutX(100);
        periodLbl2.setLayoutY(250);
        periodTxt2.setLayoutX(290);
        periodTxt2.setLayoutY(250);

        principalOutputLbl2.setLayoutX(530);
        principalOutputLbl2.setLayoutY(250);
        fvOutputLbl2.setLayoutX(530);
        fvOutputLbl2.setLayoutY(280);
        interestOutputLbl2.setLayoutX(530);
        interestOutputLbl2.setLayoutY(310);
        periodOutputLbl2.setLayoutX(530);
        periodOutputLbl2.setLayoutY(340);

        finalValueOutput2.setLayoutY(110);
        finalValueOutput2.setLayoutX(680);
        errorLbl2.setLayoutY(430);
        errorLbl2.setLayoutX(450);
        presentValueOutput2.setLayoutY(170);
        presentValueOutput2.setLayoutX(720);

        //adding function to the calculate button of the sub tab 2
        calculateBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //reading entered data to the finance text to be printed
                try {
                     printFinance = new PrintWriter(new FileWriter(file, true));
                } catch (IOException e) {
                     e.printStackTrace();
                }
                //for not crashing errors if any other inputs other than numbers are entered
                try{
                    final int percent = 100;
                    String principalValue2=principalTxt2.getText();
                    String fvValue2=fvTxt2.getText();
                    String interestRate2=interestTxt2.getText();
                    String period2=periodTxt2.getText();

                    //to prompt an error if the text fields are left empty
                    if (principalValue2.equals("") && fvValue2.equals("") && interestRate2.equals("") && period2.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Your values need to be entered");
                        alert.showAndWait();
                    }
                    else if (principalValue2.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please enter in the Home Price");
                        alert.showAndWait();
                    }
                    else if (fvValue2.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the PMT value (Annuity Payment)");
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
                        //calculation to find the pmt value of the finance loan
                        double period=Double.parseDouble(period2);
                        double interestRate = Double.parseDouble(interestRate2) / percent;
                        double pmtValueD=((Double.parseDouble(fvValue2)-((Double.parseDouble(principalValue2))*(Math.pow(1+interestRate,period))))*interestRate)/((Math.pow(1+interestRate,period)-1));
                        String PMTValue=NumberFormat.getCurrencyInstance().format(pmtValueD);
                        finalValueOutput2.setText(PMTValue);

                        double presentValue2=Double.parseDouble(fvValue2) * Math.pow(1+interestRate,-period);
                        String pvFinal=NumberFormat.getCurrencyInstance().format(presentValue2);
                        presentValueOutput2.setText(pvFinal);

                        String homePrice = NumberFormat.getCurrencyInstance().format(Double.parseDouble(principalValue2));
                        principalOutputLbl2.setText("Principal Value :\t\t\t" + homePrice);
                        String fvVal = NumberFormat.getCurrencyInstance().format(Double.parseDouble(fvValue2));
                        fvOutputLbl2.setText("FV Value :\t\t\t\t" + fvVal);
                        interestOutputLbl2.setText("Interest Rate :\t\t\t\t" + interestRate2 + "%");
                        periodOutputLbl2.setText("Time Period :\t\t\t\t" + period2 + "yrs");

                        //the values and method to be printed to the text
                        printFinance.println("\tYears :- "+period2+" years");
                        printFinance.println("\tInterest Rate :- "+interestRate2+"%");              //{ details }
                        printFinance.println("\tFuture Value :- "+fvVal);
                        printFinance.println("\tPrincipal Value :- "+homePrice);
                        printFinance.println("\tPMT (Annuity Payment) :- "+PMTValue);

                        printFinance.println("\n\tFinance History Details ( "+ LocalDateTime.now()+" )\n");          // { heading }

                    }
                    printFinance.close();
                } catch (NumberFormatException e) {
                    errorLbl2.setText("---ENTER NUMBERS ONLY---");
                }
            }
        });

        //setting background image in sub tab 2
        Image fImage2 = new Image("file:savings1.jpg");
        ImageView financeImage2 = new ImageView(fImage2);
        financeImage2.setFitHeight(500);
        financeImage2.setFitWidth(1000);
        financeImage2.setStyle("-fx-opacity:0.7;");

        //sub tab 2 calling
        subPane.getTabs().addAll(subTab2);
        contents2.getChildren().addAll(financeImage2,presentValueOutput2,periodOutputLbl2,interestOutputLbl2,fvOutputLbl2,principalOutputLbl2,errorLbl2,finalValueOutput2,calculateBtn2,topicLbl,principalLbl2,periodLbl2,fvLbl2,fvTxt2,interestLbl2,principalTxt2,interestTxt2,periodTxt2,finalValueLbl);
        subTab2.setContent(contents2);

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //create sub tab3
        Tab subTab3 =new Tab("I/Y");
        subTab3.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;-fx-padding:5px");
        Pane contents3 = new Pane();
        subTab3.setClosable(false);

        //adding the labels,button and text fields to subtab 3
        Button calculateBtn3 =new Button("Calculate");
        calculateBtn3.setMinSize(220,40);
        calculateBtn3.setStyle("-fx-padding:10px 20px;-fx-background-Color:green;-fx-text-fill:white;-fx-font-Size:20px;");

        Label principalLbl3 =new Label("Principal Value: ");
        principalLbl3.setStyle("-fx-font-Weight:bold;");
        Label principalOutputLbl3=new Label();
        principalOutputLbl3.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        TextField principalTxt3 =new TextField();
        principalTxt3.setPromptText("$");

        Label fvLbl3 =new Label("FV (Future Value): ");
        fvLbl3.setStyle("-fx-font-Weight:bold;");
        Label fvOutputLbl3=new Label();
        fvOutputLbl3.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        TextField fvTxt3 =new TextField();
        fvTxt3.setPromptText("$");

        Label periodLbl3 =new Label("Periods (Years): ");
        periodLbl3.setStyle("-fx-font-Weight:bold;");
        Label periodOutputLbl3=new Label();
        periodOutputLbl3.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        TextField periodTxt3 =new TextField();
        periodTxt3.setPromptText("yrs");

        Label finalValueOutput3 =new Label();
        finalValueOutput3.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label errorLbl3=new Label();
        errorLbl3.setStyle("-fx-padding:5px;-fx-text-fill:black;-fx-opacity:0.7;-fx-font-Size:30px;-fx-font-Weight:bold;");

        Label presentValueOutput3 =new Label();
        presentValueOutput3.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");

        //aligning the labels,button and text fields to subtab 3
        calculateBtn3.setLayoutX(100);
        calculateBtn3.setLayoutY(320);
        principalLbl3.setLayoutX(100);
        principalLbl3.setLayoutY(100);
        principalTxt3.setLayoutX(290);
        principalTxt3.setLayoutY(100);
        fvLbl3.setLayoutX(100);
        fvLbl3.setLayoutY(150);
        fvTxt3.setLayoutX(290);
        fvTxt3.setLayoutY(150);
        periodLbl3.setLayoutX(100);
        periodLbl3.setLayoutY(200);
        periodTxt3.setLayoutX(290);
        periodTxt3.setLayoutY(200);

        principalOutputLbl3.setLayoutX(530);
        principalOutputLbl3.setLayoutY(250);
        fvOutputLbl3.setLayoutX(530);
        fvOutputLbl3.setLayoutY(280);
        periodOutputLbl3.setLayoutX(530);
        periodOutputLbl3.setLayoutY(310);

        finalValueOutput3.setLayoutY(110);
        finalValueOutput3.setLayoutX(680);
        errorLbl3.setLayoutY(430);
        errorLbl3.setLayoutX(450);
        presentValueOutput3.setLayoutY(170);
        presentValueOutput3.setLayoutX(720);

        //adding function to the calculate button of the sub tab 2
        calculateBtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //reading entered data to the finance text to be printed
                try {
                     printFinance = new PrintWriter(new FileWriter(file, true));
                } catch (IOException e) {
                     e.printStackTrace();
                }

                //for not crashing errors if any other inputs other than numbers are entered
                try{
                    final int percent = 100;
                    String principalValue3=principalTxt3.getText();
                    String fvValue3=fvTxt3.getText();
                    String period3=periodTxt3.getText();

                    //to prompt an error if the text fields are left empty
                    if (principalValue3.equals("") && fvValue3.equals("") &&  period3.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Your values need to be entered");
                        alert.showAndWait();
                    }
                    else if (principalValue3.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please enter in the Principal Value");
                        alert.showAndWait();
                    }
                    else if (fvValue3.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Future Value");
                        alert.showAndWait();
                    }
                    else if (period3.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in No of years");
                        alert.showAndWait();
                    }
                    else {
                        //calculation to find the pmt value of the finance loan
                        double interestValue=(Math.pow(Double.parseDouble(fvValue3)/Double.parseDouble(principalValue3),1/Double.parseDouble(period3))-1)*percent;
                        double interestPV=(Math.pow(Double.parseDouble(fvValue3)/Double.parseDouble(principalValue3),1/Double.parseDouble(period3))-1);

                        DecimalFormat intersetRateF = new DecimalFormat("###.##");
                        finalValueOutput3.setText(intersetRateF.format(interestValue)+"%");

                        double presentValue3=Double.parseDouble(fvValue3) * Math.pow(1+interestPV,-Double.parseDouble(period3));
                        String pvFinal=NumberFormat.getCurrencyInstance().format(presentValue3);
                        presentValueOutput3.setText(pvFinal);

                        String homePrice = NumberFormat.getCurrencyInstance().format(Double.parseDouble(principalValue3));
                        principalOutputLbl3.setText("Principal Value :\t\t\t" + homePrice);
                        String fvVal = NumberFormat.getCurrencyInstance().format(Double.parseDouble(fvValue3));
                        fvOutputLbl3.setText("FV Value :\t\t\t\t " + fvVal);
                        periodOutputLbl3.setText("Time Period :\t\t\t\t" + period3 + "yrs");

                        //the values and method to be printed to the text
                        printFinance.println("\tYears :- "+period3+" years");
                        printFinance.println("\tInterest Rate :- "+interestValue+"%");              //{ details }
                        printFinance.println("\tFuture Value :- "+fvVal);
                        printFinance.println("\tPrincipal Value :- "+homePrice);

                        printFinance.println("\n\tFinance History Details ( "+ LocalDateTime.now()+" )\n");          // { heading }

                    }
                    printFinance.close();
                } catch (NumberFormatException e) {
                    errorLbl3.setText("---ENTER NUMBERS ONLY---");
                }
            }
        });

        //seeting the background image for sub tab 3
        Image fImage3 = new Image("file:savings1.jpg");
        ImageView financeImage3 = new ImageView(fImage3);
        financeImage3.setFitHeight(500);
        financeImage3.setFitWidth(1000);
        financeImage3.setStyle("-fx-opacity:0.7;");

        //sub tab 3 calling
        subPane.getTabs().addAll(subTab3);
        contents3.getChildren().addAll(financeImage3,presentValueOutput3,principalOutputLbl3,periodOutputLbl3,fvOutputLbl3,errorLbl3,finalValueOutput3,calculateBtn3,topicLbl,principalLbl3,periodLbl3,fvLbl3,fvTxt3,principalTxt3,periodTxt3,finalValueLbl);
        subTab3.setContent(contents3);

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //create sub tab 4
        Tab subTab4 =new Tab("N");
        subTab4.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;-fx-padding:5px");
        Pane contents4 = new Pane();
        subTab4.setClosable(false);

        //adding the labels,button and text fields to subtab 4
        Button calculateBtn4 =new Button("Calculate");
        calculateBtn4.setMinSize(220,40);
        calculateBtn4.setStyle("-fx-padding:10px 20px;-fx-background-Color:green;-fx-text-fill:white;-fx-font-Size:20px;");

        Label principalLbl4 =new Label("Principal Value: ");
        principalLbl4.setStyle("-fx-font-Weight:bold;");
        TextField principalTxt4 =new TextField();
        Label principalOutputLbl4=new Label();
        principalOutputLbl4.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        principalTxt4.setPromptText("$");

        Label fvLbl4 =new Label("FV (Future Value): ");
        fvLbl4.setStyle("-fx-font-Weight:bold;");
        TextField fvTxt4 =new TextField();
        Label fvOutputLbl4=new Label();
        fvOutputLbl4.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        fvTxt4.setPromptText("$");

        Label pmtLbl4 =new Label("PMT (Annuity Payment): ");
        pmtLbl4.setStyle("-fx-font-Weight:bold;");
        TextField pmtTxt4 =new TextField();
        Label pmtOutputLbl4=new Label();
        pmtOutputLbl4.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        pmtTxt4.setPromptText("$");

        Label interestLbl4 =new Label("Interest: ");
        interestLbl4.setStyle("-fx-font-Weight:bold;");
        TextField interestTxt4 =new TextField();
        Label interestOutputLbl4=new Label();
        interestOutputLbl4.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        interestTxt4.setPromptText("%");

        Label finalValueOutput4 =new Label();
        finalValueOutput4.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label errorLbl4=new Label();
        errorLbl4.setStyle("-fx-padding:5px;-fx-text-fill:black;-fx-opacity:0.7;-fx-font-Size:30px;-fx-font-Weight:bold;");

        Label presentValueOutput4 =new Label();
        presentValueOutput4.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");

        //aligning the labels,button and text fields to subtab 4
        calculateBtn4.setLayoutX(100);
        calculateBtn4.setLayoutY(320);
        principalLbl4.setLayoutX(100);
        principalLbl4.setLayoutY(100);
        principalTxt4.setLayoutX(290);
        principalTxt4.setLayoutY(100);
        fvLbl4.setLayoutX(100);
        fvLbl4.setLayoutY(150);
        fvTxt4.setLayoutX(290);
        fvTxt4.setLayoutY(150);
        pmtLbl4.setLayoutX(100);
        pmtLbl4.setLayoutY(200);
        pmtTxt4.setLayoutX(290);
        pmtTxt4.setLayoutY(200);
        interestLbl4.setLayoutX(100);
        interestLbl4.setLayoutY(250);
        interestTxt4.setLayoutX(290);
        interestTxt4.setLayoutY(250);

        principalOutputLbl4.setLayoutX(530);
        principalOutputLbl4.setLayoutY(250);
        fvOutputLbl4.setLayoutX(530);
        fvOutputLbl4.setLayoutY(280);
        interestOutputLbl4.setLayoutX(530);
        interestOutputLbl4.setLayoutY(310);
        pmtOutputLbl4.setLayoutX(530);
        pmtOutputLbl4.setLayoutY(340);

        finalValueOutput4.setLayoutY(110);
        finalValueOutput4.setLayoutX(680);
        errorLbl4.setLayoutY(430);
        errorLbl4.setLayoutX(450);
        presentValueOutput4.setLayoutY(170);
        presentValueOutput4.setLayoutX(720);

        //adding function to the calculate button of the sub tab 2
        calculateBtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //reading entered data to the mortgage text to be printed
                try {
                    printFinance = new PrintWriter(new FileWriter(file, true));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //for not crashing errors if any other inputs other than numbers are entered
                try{
                    final int percent = 100;
                    String pValue4=principalTxt4.getText();
                    String fvValue4=fvTxt4.getText();
                    String interestRate4=interestTxt4.getText();
                    String pmtValue4=pmtTxt4.getText();

                    //to prompt an error if the text fields are left empty
                    if (pmtValue4.equals("") && fvValue4.equals("") && interestRate4.equals("") && pValue4.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Your values need to be entered");
                        alert.showAndWait();
                    }
                    else if (pValue4.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please enter in the Principal Value");
                        alert.showAndWait();
                    }
                    else if (fvValue4.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Future Value");
                        alert.showAndWait();
                    }
                    else if (pmtValue4.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the PMT value (Annuity Payment)");
                        alert.showAndWait();
                    }
                    else if (interestRate4.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter the Interest Rate");
                        alert.showAndWait();
                    }
                    else {
                        //calculation to find the principal value of the finance loan
                        double interestRate = Double.parseDouble(interestRate4) / percent;
                        double period4=Math.log(((Double.parseDouble(fvValue4)*interestRate)+Double.parseDouble(pmtValue4))/((Double.parseDouble(pValue4)*interestRate)+Double.parseDouble(pmtValue4)))/Math.log(1+interestRate);
                        DecimalFormat timeV = new DecimalFormat("###.##");
                        finalValueOutput4.setText(timeV.format(period4)+" yrs");

                        double presentValue4=Double.parseDouble(fvValue4) * Math.pow(1+interestRate,-period4);
                        String pvFinal=NumberFormat.getCurrencyInstance().format(presentValue4);
                        presentValueOutput4.setText(pvFinal);

                        principalOutputLbl4.setText("Principal Value :\t\t$" +pValue4);
                        fvOutputLbl4.setText("FV Value :\t\t\t$" + fvValue4);
                        interestOutputLbl4.setText("Interest Rate :\t\t\t" + interestRate4 + "%");
                        pmtOutputLbl4.setText("PMT Value :\t\t\t$" +pmtValue4);

                        //the values and method to be printed to the text file
                        printFinance.println("\tYears :- "+timeV+" years");
                        printFinance.println("\tInterest Rate :- "+interestRate4+"%");              //{ details }
                        printFinance.println("\tFuture Value :- "+fvValue4);
                        printFinance.println("\tPMT (Annuity Payment) :- "+pmtValue4);
                        printFinance.println("\tStart Principal :- "+pValue4);
//
                        printFinance.println("\n\tFinance History Details ( "+ LocalDateTime.now()+" )\n");          // { heading }

                    }
                    printFinance.close();
                } catch (NumberFormatException e) {
                    errorLbl4.setText("---ENTER NUMBERS ONLY---");
                }
            }
        });

        //setting the background image for sub tab 4
        Image fImage4 = new Image("file:savings1.jpg");
        ImageView financeImage4 = new ImageView(fImage4);
        financeImage4.setFitHeight(500);
        financeImage4.setFitWidth(1000);
        financeImage4.setStyle("-fx-opacity:0.7;");


        //sub tab 4 calling
        subPane.getTabs().addAll(subTab4);
        contents4.getChildren().addAll(financeImage4,presentValueOutput4,pmtOutputLbl4,interestOutputLbl4,principalOutputLbl4,fvOutputLbl4,errorLbl4,finalValueOutput4,calculateBtn4,topicLbl,principalLbl4,fvLbl4,pmtLbl4,pmtTxt4,interestLbl4,principalTxt4,interestTxt4,fvTxt4,finalValueLbl);
        subTab4.setContent(contents4);

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //create sub tab 5
        Tab subTab5 =new Tab("Start Principal");
        subTab5.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;-fx-padding:5px");
        Pane contents5 = new Pane();
        subTab5.setClosable(false);

        //adding the labels,button and text fields to subtab 5
        Button calculateBtn5 =new Button("Calculate");
        calculateBtn5.setStyle("-fx-padding:10px 20px;-fx-background-Color:green;-fx-text-fill:white;-fx-font-Size:20px;");
        calculateBtn5.setMinSize(220,40);

        Label periodLbl5 =new Label("Period (Years): ");
        Label periodOutputLbl5=new Label();
        periodOutputLbl5.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        periodLbl5.setStyle("-fx-font-Weight:bold;");
        TextField periodTxt5 =new TextField();
        periodTxt5.setPromptText("yrs");

        Label fvLbl5 =new Label("FV (Future Value): ");
        Label fvOutputLbl5=new Label();
        fvOutputLbl5.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        fvLbl5.setStyle("-fx-font-Weight:bold;");
        TextField fvTxt5 =new TextField();
        fvTxt5.setPromptText("$");

        Label pmtLbl5 =new Label("PMT (Annuity Payment): ");
        Label pmtOutputLbl5=new Label();
        pmtOutputLbl5.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        pmtLbl5.setStyle("-fx-font-Weight:bold;");
        TextField pmtTxt5 =new TextField();
        pmtTxt5.setPromptText("$");

        Label interestLbl5 =new Label("Interest: ");
        Label interestOutputLbl5=new Label();
        interestOutputLbl5.setStyle("-fx-font-Weight:bold;-fx-font-size:18px;-fx-background-Color:lightgray;-fx-padding:5px");
        interestLbl5.setStyle("-fx-font-Weight:bold;");
        TextField interestTxt5 =new TextField();
        interestTxt5.setPromptText("%");


        Label finalValueOutput5 =new Label();
        finalValueOutput5.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");
        Label errorLbl5=new Label();
        errorLbl5.setStyle("-fx-padding:5px;-fx-text-fill:black;-fx-opacity:0.7;-fx-font-Size:30px;-fx-font-Weight:bold;");

        Label presentValueOutput5 =new Label();
        presentValueOutput5.setStyle("-fx-font-Weight:bold;-fx-font-size:20px;-fx-background-Color:lightgray;-fx-padding:5px");

        //aligning the labels,button and text fields to subtab 5
        calculateBtn5.setLayoutX(100);
        calculateBtn5.setLayoutY(320);
        periodLbl5.setLayoutX(100);
        periodLbl5.setLayoutY(100);
        periodTxt5.setLayoutX(290);
        periodTxt5.setLayoutY(100);
        fvLbl5.setLayoutX(100);
        fvLbl5.setLayoutY(150);
        fvTxt5.setLayoutX(290);
        fvTxt5.setLayoutY(150);
        pmtLbl5.setLayoutX(100);
        pmtLbl5.setLayoutY(200);
        pmtTxt5.setLayoutX(290);
        pmtTxt5.setLayoutY(200);
        interestLbl5.setLayoutX(100);
        interestLbl5.setLayoutY(250);
        interestTxt5.setLayoutX(290);
        interestTxt5.setLayoutY(250);

        pmtOutputLbl5.setLayoutX(530);
        pmtOutputLbl5.setLayoutY(250);
        fvOutputLbl5.setLayoutX(530);
        fvOutputLbl5.setLayoutY(280);
        interestOutputLbl5.setLayoutX(530);
        interestOutputLbl5.setLayoutY(310);
        periodOutputLbl5.setLayoutX(530);
        periodOutputLbl5.setLayoutY(340);

        finalValueOutput5.setLayoutY(110);
        finalValueOutput5.setLayoutX(680);
        errorLbl5.setLayoutY(430);
        errorLbl5.setLayoutX(450);
        presentValueOutput5.setLayoutY(170);
        presentValueOutput5.setLayoutX(720);


        //adding function to the calculate button of the sub tab 2
        calculateBtn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //reading entered data to the mortgage text to be printed
                try {
                    printFinance = new PrintWriter(new FileWriter(file, true));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //for not crashing errors if any other inputs other than numbers are entered
                try{
                    final int percent = 100;
                    String pmtValue5=pmtTxt5.getText();
                    String fvValue5=fvTxt5.getText();
                    String interestRate5=interestTxt5.getText();
                    String period5=periodTxt5.getText();

                    //to prompt an error if the text fields are left empty
                    if (pmtValue5.equals("") && fvValue5.equals("") && interestRate5.equals("") && period5.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Your values need to be entered");
                        alert.showAndWait();
                    }
                    else if (pmtValue5.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Please enter in the Home Price");
                        alert.showAndWait();
                    }
                    else if (fvValue5.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the PMT value (Annuity Payment)");
                        alert.showAndWait();
                    }
                    else if (interestRate5.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in the Interest Rate");
                        alert.showAndWait();
                    }
                    else if (period5.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!!");
                        alert.setContentText("Please enter in No of years");
                        alert.showAndWait();
                    }
                    else {
                        //calculation to find the principal value of the finance loan
                        double period=Double.parseDouble(period5);
                        double interestRate = Double.parseDouble(interestRate5) / percent;
                        double pValueD=(Double.parseDouble(fvValue5)-(Double.parseDouble(pmtValue5)*((Math.pow(1+interestRate,period)-1))/interestRate))/ (Math.pow(1+interestRate,period));
                        String principalValue=NumberFormat.getCurrencyInstance().format(pValueD);
                        finalValueOutput5.setText(principalValue);

                        double presentValue5=Double.parseDouble(fvValue5) * Math.pow(1+interestRate,-period);
                        String pvFinal=NumberFormat.getCurrencyInstance().format(presentValue5);
                        presentValueOutput5.setText(pvFinal);

                        String pmtVal = NumberFormat.getCurrencyInstance().format(Double.parseDouble(pmtValue5));
                        pmtOutputLbl5.setText("PMT Value :\t\t\t" + pmtVal);
                        String fvVal = NumberFormat.getCurrencyInstance().format(Double.parseDouble(fvValue5));
                        fvOutputLbl5.setText("FV Value :\t\t\t" + fvVal);
                        interestOutputLbl5.setText("Interest Rate :\t\t\t" + interestRate5 + "%");
                        periodOutputLbl5.setText("Time Period :\t\t\t" + period5 + "yrs");

                        //the values and method to be printed to the text
                        printFinance.println("\tYears :- "+period5+" years");
                        printFinance.println("\tInterest Rate :- "+interestRate5+"%");              //{ details }
                        printFinance.println("\tFuture Value :- "+fvVal);
                        printFinance.println("\tPMT (Annuity Payment) :- "+pmtVal);
                        printFinance.println("\tStart Principal :- "+principalValue);

                        printFinance.println("\n\tFinance History Details ( "+ LocalDateTime.now()+" )\n");          // { heading }


                    }
                    printFinance.close();
                } catch (NumberFormatException e) {
                    errorLbl5.setText("---ENTER NUMBERS ONLY---");
                }
            }
        });


        //setting the background image for sub tab 5
        Image fImage5 = new Image("file:savings1.jpg");
        ImageView financeImage5 = new ImageView(fImage5);
        financeImage5.setFitHeight(500);
        financeImage5.setFitWidth(1000);
        financeImage5.setStyle("-fx-opacity:0.7;");


        //sub tab 5 calling
        subPane.getTabs().addAll(subTab5);
        contents5.getChildren().addAll(financeImage5,presentValueOutput5,periodOutputLbl5,interestOutputLbl5,pmtOutputLbl5,fvOutputLbl5,errorLbl5,finalValueOutput5,calculateBtn5,topicLbl,periodLbl5,fvLbl5,pmtLbl5,pmtTxt5,interestLbl5,periodTxt5,interestTxt5,fvTxt5,finalValueLbl);
        subTab5.setContent(contents5);

        //add inside tab
        Pane displayBox =new Pane(subPane);
        displayBox.getChildren().addAll(topicLbl,finalValueLbl,presentValueLbl);
        joiningFinanceTab.setContent(displayBox);

        //--------------------------------------------------------------------
        //Joining the Number pad to the pane

        //tab 1
        principalTxt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                principalTxt1.setText(NumberPad.JoinNumberpad());
            }
        });
        pmtTxt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pmtTxt1.setText(NumberPad.JoinNumberpad());
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

        //tab 2
        principalTxt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                principalTxt2.setText(NumberPad.JoinNumberpad());
            }
        });
        fvTxt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fvTxt2.setText(NumberPad.JoinNumberpad());
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

        //tab 3
        principalTxt3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                principalTxt3.setText(NumberPad.JoinNumberpad());
            }
        });
        fvTxt3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               fvTxt3.setText(NumberPad.JoinNumberpad());
            }
        });
        periodTxt3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                periodTxt3.setText(NumberPad.JoinNumberpad());
            }
        });

        //tab 4
        principalTxt4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                principalTxt4.setText(NumberPad.JoinNumberpad());
            }
        });
        fvTxt4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fvTxt4.setText(NumberPad.JoinNumberpad());
            }
        });
        interestTxt4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                interestTxt4.setText(NumberPad.JoinNumberpad());
            }
        });
        pmtTxt4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pmtTxt4.setText(NumberPad.JoinNumberpad());
            }
        });

        //tab 5
        fvTxt5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fvTxt5.setText(NumberPad.JoinNumberpad());
            }
        });
        pmtTxt5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pmtTxt5.setText(NumberPad.JoinNumberpad());
            }
        });
        interestTxt5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                interestTxt5.setText(NumberPad.JoinNumberpad());
            }
        });
        periodTxt5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                periodTxt5.setText(NumberPad.JoinNumberpad());
            }
        });
    }
}

