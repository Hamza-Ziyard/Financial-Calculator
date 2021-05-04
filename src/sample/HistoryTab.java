package sample;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HistoryTab {
    Tab joiningHistoryTab;
    //make constructor of class
    public HistoryTab(Tab joiningHistoryTab){
        this.joiningHistoryTab = joiningHistoryTab;
    }

    // making function
    public void historyFunction() throws IOException {

        //pane displaying the details
        Pane displayHistoryDetails=new Pane();
        Label lblDetails = new Label();
        lblDetails.setStyle("-fx-text-fill:white;-fx-font-family:tahoma");
        String lines;

        //reading auto loan text
        FileReader frAutoLoan=new FileReader("AutoLoan.txt");
        BufferedReader brAutoLoan =new BufferedReader(frAutoLoan);
        while ((lines=brAutoLoan.readLine()) != null){
            lblDetails.setText(lines+"\n"+lblDetails.getText());
        }

        //reading finance loan text
        FileReader frFinance=new FileReader("Finance.txt");
        BufferedReader brFinance =new BufferedReader(frFinance);
        while ((lines=brFinance.readLine()) != null){
            lblDetails.setText(lines+"\n"+lblDetails.getText());
        }

        //reading mortgage text
        FileReader frMortgage = new FileReader("Mortgage.txt");
        BufferedReader brMortgage =new BufferedReader(frMortgage);
        while ((lines=brMortgage.readLine()) != null){
            lblDetails.setText(lines+"\n"+lblDetails.getText());
        }

        //adding the details to the pane
        displayHistoryDetails.getChildren().addAll(lblDetails);

        //adding the scroll pane to the pane displaying the details
        ScrollPane scrollPane = new ScrollPane();
        displayHistoryDetails.setStyle("-fx-font-size:15px;-fx-background-color:gray;-fx-background-opacity:0.5;-fx-text-fill:white;");
        displayHistoryDetails.setMinWidth(980);
        scrollPane.setContent(displayHistoryDetails);
        joiningHistoryTab.setContent(scrollPane);

    }

}
