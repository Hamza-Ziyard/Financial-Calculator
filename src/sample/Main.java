package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //adding the main tab pane
        TabPane mainTabPane=new TabPane();
        mainTabPane.setMinWidth(1000);

        //adding tab panes inside the main tab pane
        Tab mortgageTab=new Tab("Mortgage Calculator");
        mortgageTab.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;");
        mortgageTab.setClosable(false);
        Tab financeTab=new Tab("Finance Calculator");
        financeTab.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;");
        financeTab.setClosable(false);
        Tab loanTab=new Tab("Loan Calculator");
        loanTab.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;");
        loanTab.setClosable(false);
        Tab historyTab=new Tab("History");
        historyTab.setStyle("-fx-font-Weight:bold;-fx-background-Color:#949494;");
        historyTab.setClosable(false);

        //joining all tabs
        mainTabPane.getTabs().addAll(mortgageTab,financeTab,loanTab,historyTab);

        //calling functions to get tabs
        new MortgageTab(mortgageTab).mortgageFunction();
        new FinanceTab(financeTab).financeFunction();
        new AutoLoanTab(loanTab).autoLoanFunction();
        new HistoryTab(historyTab).historyFunction();

        //provide the 2 divisions with calculator and number pad
        HBox MainHbox = new HBox();
        MainHbox.setStyle("-fx-background-Color:gray");
        MainHbox.getChildren().addAll(mainTabPane, NumberPad.calc());

        //creating the primary stage
        Scene scene =new Scene(MainHbox,1300,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Financial Calculator");
        primaryStage.show();
        //provide the 2 divisions with calculator and number pad
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
