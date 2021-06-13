import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ReCW01 extends Application {
    private static final int NO_OF_COMPETITORS = 20; // declare a constant variable for no of competitors

    public static void main (String[] args) {
        Application.launch();
    }

    public void start(Stage primaryStage) {
        HashMap<Integer,List<String>> gamersDetails = new HashMap<>(); // Hashmap key:competitor no value:list[name,age,no of coins,score,distance]
        HashMap<Integer,List<Integer>> winnersDetails = new HashMap<>(); // Hashmap key:winning title number value:list[competitor no of the winner of that category]

        while (true) {    //show menu and call appropriate method based on the user input
            System.out.println();
            System.out.println("Welcome!!!");
            System.out.println("By using this program you can find out the winners of the gaming competition after providing the details of each competitor");
            System.out.println("Here are the available options in this program");
            System.out.println();
            System.out.println("^^^^^^^^^^^^^MENU^^^^^^^^^^^^");
            System.out.println();
            System.out.println("A - Input details of a competitor");
            System.out.println("B - View details of all competitors");
            System.out.println("C - View details of a selected competitor");
            System.out.println("D - View winners in all three categories");
            System.out.println("E - View the winner in a selected category");
            System.out.println("Q - Quit program");
            System.out.println();
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the relevant letter of the option you want to select : ");
            String option = input.nextLine();
            System.out.println();

            switch (option) {
                case "A":
                case "a":
                    inputCompetitorDetails(gamersDetails);  // call inputCompetitorDetails() method
                    break;
                case "B":
                case "b":
                    viewAllCompetitorDetails(gamersDetails); // call viewAllCompetitorDetails() method
                    break;
                case "C":
                case "c":
                    viewSelectedCompetitorDetails(gamersDetails); // call  viewSelectedCompetitorDetails()method
                    break;
                case "D":
                case "d":
                    viewAllThreeWinners(gamersDetails, winnersDetails); // call viewAllThreeWinners() method
                    break;
                case "E":
                case "e":
                    viewSelectedWinner(gamersDetails, winnersDetails); // call  viewSelectedWinner() method
                    break;
                case "Q":
                case "q":
                    System.out.println("Now you are exiting from the program");
                    System.exit(0);  //terminate the program
                default:
                    System.out.println("You have entered an invalid input.Please try again");  // execute if none of the above cases match to user input
                    break;
            }
        }
    }

    public static void inputCompetitorDetails(HashMap<Integer,List<String>> competitorDetails) { // allow user to input competitor details
        ArrayList<String> competitorDetailsList = new ArrayList<>(); //list that store [name,age,no of coins,score,distance] of the competitor
        System.out.println("Please enter the following details of the competitor");
        System.out.println();
        boolean loop = true;
        int competitorNo = 0;
        String name;
        int age;
        int noOfCoins;
        int score;
        double distance;
        double formattedDistance;

        while (loop) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Competitor number : ");
                competitorNo = input.nextInt();
                if (competitorNo >= 1 && competitorNo <= NO_OF_COMPETITORS) { //check whether the competitor no is within the valid range
                    boolean usedBefore = false;
                    for (Integer competitorNum : competitorDetails.keySet()) {
                        if (competitorNum.equals(competitorNo)) { //check whether the provided competitor no has used before to enter data
                            System.out.println("Provided competitor number has used previously to enter the details of another competitor.");
                            System.out.println("Please re-check and enter the competitor number");
                            System.out.println();
                            usedBefore = true;
                        }
                    }
                    if (!usedBefore) {  //stop while loop if competitor no hasn`t used before to enter data
                        loop = false;
                    }
                } else {  //execute if user enters an integer which is not in valid range
                    System.out.println("You have to input a valid integer within 1 to " + NO_OF_COMPETITORS + " as the competitor number.Please try again");
                    System.out.println();
                }
            } catch (Exception e) { //execute if user enter an input which is not an integer
                System.out.println("You have to input a valid integer within 1 to " + NO_OF_COMPETITORS + " as the competitor number.Please try again");
                System.out.println();
            }
        }

        Scanner nameInput = new Scanner(System.in);
        System.out.println("Name of the competitor : ");
        name = nameInput.nextLine().toLowerCase(); // convert the provided input into lower case

        while (true) {
            try {
                Scanner ageInput = new Scanner(System.in);
                System.out.println("Age in years : ");
                age = ageInput.nextInt();  //assign user input into variable 'age'
                break;
            } catch (Exception e) { //execute if user enter an input which is not an integer
                System.out.println("Please enter a valid integer as the age of competitor in years.");
            }
        }

        while (true) {
            try {
                Scanner coinsInput = new Scanner(System.in);
                System.out.println("No of coins collected : ");
                noOfCoins = coinsInput.nextInt();  //assign user input into variable 'noOfCoins'
                break;
            } catch (Exception e) {  //execute if user enter an input which is not an integer
                System.out.println("Please enter a valid integer as the number of coins collected by the competitor.");
            }
        }

        while (true) {
            try {
                Scanner scoreInput = new Scanner(System.in);
                System.out.println("Score achieved : ");
                score = scoreInput.nextInt();  //assign user input into variable 'score'
                break;
            } catch (Exception e) {  //execute if user enter an input which is not an integer
                System.out.println("Please enter a valid integer as the score achieved by the competitor.");
            }
        }

        while (true) {
            try {
                Scanner distanceInput = new Scanner(System.in);
                System.out.println("Distance reached in meters: ");
                distance = distanceInput.nextDouble();  //assign user input into variable 'distance'
                formattedDistance = (double) Math.round(distance * 100.0) / 100.0; //round the value assigned to 'distance'
                break;
            } catch (Exception e) {  //execute if user enter an input which is not a double value
                System.out.println("Please enter a valid decimal number as the distance reached by the competitor in meters.");
            }
        }

        System.out.println();
        System.out.println("Here are the details of the competitor provided by you.");  //print competitor details provided by the user
        System.out.println();
        System.out.println("            Competitor number : " + competitorNo);
        System.out.println("            Name of the competitor : " + name);
        System.out.println("            Age in years : " + age);
        System.out.println("            No of coins collected : " + noOfCoins);
        System.out.println("            Score achieved : " + score);
        System.out.println("            Distance reached in meters: " + formattedDistance);
        System.out.println();

        while (true) {
            Scanner changeInput = new Scanner(System.in);
            System.out.println("Do you want to change any detail given above? (Y/N) :");
            String change = changeInput.nextLine().toUpperCase();  //convert the given input into uppercase
            if (change.equals("Y")) {  //execute if user want to change data
                inputCompetitorDetails(competitorDetails);  //call inputCompetitorDetails() method
                break;
            } else if (change.equals("N")) {  //execute if user don`t want to change data
                competitorDetailsList.add(name);   //add name,age,no of coins,score and distance into arraylist
                competitorDetailsList.add(Integer.toString(age));
                competitorDetailsList.add(Integer.toString(noOfCoins));
                competitorDetailsList.add(Integer.toString(score));
                competitorDetailsList.add(Double.toString(formattedDistance));
                competitorDetails.put(competitorNo, competitorDetailsList);  //add data into hashmap

                System.out.println("Following details has been successfully recorded");  //print the recorded data
                System.out.println();
                System.out.println("            Competitor number : " + competitorNo);
                System.out.println("            Name of the competitor : " + name);
                System.out.println("            Age in years : " + age);
                System.out.println("            No of coins collected : " + noOfCoins);
                System.out.println("            Score achieved : " + score);
                System.out.println("            Distance reached in meters: " + formattedDistance);
                System.out.println();
                break;
            } else {  //execute if user input an invalid input
                System.out.println("Please enter either 'Y' or 'N' as the input");
            }
        }
    }

    public static void viewAllCompetitorDetails(HashMap<Integer,List<String>> competitorDetails) { //view details of all the competitors
        if (competitorDetails.size() != 0) {  //check whether there`s any details to show
            GridPane gridlayout = new GridPane(); // create a GUI to view all competitor details
            gridlayout.setStyle("-fx-background-color:#22F2E4");
            gridlayout.setPadding(new Insets(20, 20, 20, 20));
            gridlayout.setVgap(15);
            gridlayout.setHgap(15);

            Label message = new Label("Here`s the list of details of all the competitors"); //create labels,buttons and add them into layout
            message.setFont(new Font("Arial Rounded MT Bold", 22));                        //to view details of all competitors
            gridlayout.add(message, 14, 2, 40, 1);

            int xPosition = 6, yPosition = 10;
            for (Integer competitorNum : competitorDetails.keySet()) {
                Label competitorNo = new Label("            Competitor number : " + competitorNum);
                competitorNo.setFont(new Font("Calibri", 18));
                gridlayout.add(competitorNo, xPosition, yPosition, 8, 1);
                Label name = new Label("            Name of the competitor : " + competitorDetails.get(competitorNum).get(0));
                name.setFont(new Font("Calibri", 18));
                gridlayout.add(name, xPosition, yPosition + 1, 8, 1);
                Label age = new Label("            Age in years : " + competitorDetails.get(competitorNum).get(1));
                age.setFont(new Font("Calibri", 18));
                gridlayout.add(age, xPosition, yPosition + 2, 8, 1);
                Label noOfCoins = new Label("            No of coins collected : " + competitorDetails.get(competitorNum).get(2));
                noOfCoins.setFont(new Font("Calibri", 18));
                gridlayout.add(noOfCoins, xPosition, yPosition + 3, 8, 1);
                Label score = new Label("            Score achieved : " + competitorDetails.get(competitorNum).get(3));
                score.setFont(new Font("Calibri", 18));
                gridlayout.add(score, xPosition, yPosition + 4, 8, 1);
                Label distance = new Label("            Distance reached in meters: " + competitorDetails.get(competitorNum).get(4));
                distance.setFont(new Font("Calibri", 18));
                gridlayout.add(distance, xPosition, yPosition + 5, 8, 1);
                yPosition += 8;
            }

            ScrollPane scrollPane = new ScrollPane(gridlayout); // add a scroll pane
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);

            Scene scene = new Scene(scrollPane, 2300,700);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("View details of all competitors");
            primaryStage.setScene(scene);
            primaryStage.showAndWait(); //show GUI
        } else {
            System.out.println("There`s no recorded details about any competitor to show.");
        }
    }

    public static void viewSelectedCompetitorDetails(HashMap<Integer,List<String>> competitorDetails) { //view details of a selected player by using competitor no
        if (competitorDetails.size() != 0) { // check whether there are any details to show
            GridPane gridlayout = new GridPane();  //create GUI
            gridlayout.setStyle("-fx-background-color:#B17EE0");
            gridlayout.setPadding(new Insets(20, 20, 20, 20));
            gridlayout.setVgap(15);
            gridlayout.setHgap(15);

            Label message = new Label("Please enter the competitor number of the competitor you want to get details : "); //create labels and buttons
            message.setFont(new Font("Arial Rounded MT Bold", 20));       //and add them into layout to get the competitor no of the competitor
            gridlayout.add(message, 2, 4, 38, 1);
            TextField competitorNumInput = new TextField();
            gridlayout.add(competitorNumInput, 40, 4, 15, 1);
            Button okButton = new Button("OK");
            okButton.setFont(new Font("Arial Rounded MT Bold", 18));
            gridlayout.add(okButton, 58, 5, 15, 1);

            okButton.setOnAction(event -> {  //add an event handler to 'okButton'
                String input = competitorNumInput.getText();

                try {
                    int competitorNo = Integer.parseInt(input);
                    if (competitorNo >= 1 && competitorNo <= NO_OF_COMPETITORS) { //check whether the given number is within the valid range
                        if (competitorDetails.containsKey(competitorNo)) {  //check whether there`re any recorded details related to the given competitor no
                            for (Integer competitorNum : competitorDetails.keySet()) {  //view details of the selected competitor
                                if (competitorNum.equals(competitorNo)) {
                                    Label message1 = new Label("Here are the details related to the competitor with competitor number " + competitorNo);
                                    message1.setFont(new Font("Arial Rounded MT Bold", 20));
                                    gridlayout.add(message1, 5, 7, 40, 1);
                                    Label competitorNumber = new Label("            Competitor number : " + competitorNum);
                                    competitorNumber.setFont(new Font("Calibri", 18));
                                    gridlayout.add(competitorNumber, 8, 8, 18, 1);
                                    Label name = new Label("            Name of the competitor : " + competitorDetails.get(competitorNum).get(0));
                                    name.setFont(new Font("Calibri", 18));
                                    gridlayout.add(name, 8, 9, 18, 1);
                                    Label age = new Label("            Age in years : " + competitorDetails.get(competitorNum).get(1));
                                    age.setFont(new Font("Calibri", 18));
                                    gridlayout.add(age, 8, 10, 18, 1);
                                    Label noOfCoins = new Label("            No of coins collected : " + competitorDetails.get(competitorNum).get(2));
                                    noOfCoins.setFont(new Font("Calibri", 18));
                                    gridlayout.add(noOfCoins, 8, 11, 18, 1);
                                    Label score = new Label("            Score achieved : " + competitorDetails.get(competitorNum).get(3));
                                    score.setFont(new Font("Calibri", 18));
                                    gridlayout.add(score, 8, 12, 18, 1);
                                    Label distance = new Label("            Distance reached in meters: " + competitorDetails.get(competitorNum).get(4));
                                    distance.setFont(new Font("Calibri", 18));
                                    gridlayout.add(distance, 8, 13, 18, 1);
                                }
                            }
                        } else {  //execute if any data hasn`t recorded related to the given competitor no
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Invalid Data Alert");
                            alert.setContentText("There aren`t any recorded details related to the given competitor number");
                            alert.showAndWait();
                        }
                    } else {  //execute if provided number is not in the valid range
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Invalid Data Alert");
                        alert.setContentText("You have to input a valid integer within 1 to " + NO_OF_COMPETITORS + " as the competitor number");
                        alert.showAndWait();
                    }
                } catch (Exception e) {  //execute if user has provided an input of an invalid data type
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Data Alert");
                    alert.setContentText("You have to input a valid integer within 1 to " + NO_OF_COMPETITORS + " as the competitor number");
                    alert.showAndWait();
                }
            });

            Scene scene = new Scene(gridlayout, 2300, 700);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("View details of a selected competitor");
            primaryStage.setScene(scene);
            primaryStage.showAndWait();  //show GUI
        } else {
            System.out.println("There`s no recorded details about any competitor to show.");
        }
    }

    public static void findAllThreeWinners(HashMap<Integer,List<String>> competitorDetails,HashMap<Integer,List<Integer>> gameWinnersDetails) { //find the winners in all three categories
        ArrayList<Integer> scoreList = new ArrayList<>(); //contains scores of all competitors
        ArrayList<Double> distanceList = new ArrayList<>(); //contains distances of all competitors
        ArrayList<Integer> coinsList = new ArrayList<>(); //contains no of collected coins of all competitors
        ArrayList<Integer> scoreWinnerList = new ArrayList<>(); //contains competitor numbers of the competitors with the highest score
        ArrayList<Integer> distanceWinnerList = new ArrayList<>();  //contains competitor numbers of the competitors who ran the maximum distance
        ArrayList<Integer> coinsWinnerList = new ArrayList<>(); //contains competitor numbers of the competitors who collected the maximum no coins

        for (Integer competitorNum : competitorDetails.keySet()) { //add relevant data (score,distance,no of coins) into relevant lists
            scoreList.add(Integer.parseInt(competitorDetails.get(competitorNum).get(3)));
            distanceList.add(Double.parseDouble(competitorDetails.get(competitorNum).get(4)));
            coinsList.add(Integer.parseInt(competitorDetails.get(competitorNum).get(2)));
        }

        for(int i=0; i<scoreList.size(); i++) { //sort the score list using bubble sort algorithm
            for(int j=0; j<scoreList.size()-i-1;j++ ) {
                if(scoreList.get(j) < scoreList.get(j+1)) {
                    int temporaryVariable = scoreList.get(j);
                    scoreList.set(j,scoreList.get(j+1));
                    scoreList.set(j+1,temporaryVariable);
                }
            }
        }
        for (Integer competitorNum : competitorDetails.keySet()) { //add competitor numbers of the competitors with the highest score into arraylist
            if (competitorDetails.get(competitorNum).get(3).equals(Integer.toString(scoreList.get(0)))) {
                scoreWinnerList.add(competitorNum);
            }
        }

        for(int i=0; i<distanceList.size(); i++) { //sort the distance list using bubble sort algorithm
            for(int j=0; j<distanceList.size()-i-1;j++ ) {
                if(distanceList.get(j) < distanceList.get(j+1)) {
                    double temporaryVariable = distanceList.get(j);
                    distanceList.set(j,distanceList.get(j+1));
                    distanceList.set(j+1,temporaryVariable);
                }
            }
        }
        for (Integer competitorNum : competitorDetails.keySet()) { //add competitor numbers of the competitors who ran the maximum distance into arraylist
            if (competitorDetails.get(competitorNum).get(4).equals(Double.toString(distanceList.get(0)))) {
                distanceWinnerList.add(competitorNum);
            }
        }

        for(int i=0; i<coinsList.size(); i++) { //sort the no of coins list using bubble sort algorithm
            for(int j=0; j<coinsList.size()-i-1;j++ ) {
                if(coinsList.get(j) < coinsList.get(j+1)) {
                    int temporaryVariable = coinsList.get(j);
                    coinsList.set(j,coinsList.get(j+1));
                    coinsList.set(j+1,temporaryVariable);
                }
            }
        }
        for (Integer competitorNum : competitorDetails.keySet()) { //add competitor numbers of the competitors who collected the max no of coins into arraylist
            if (competitorDetails.get(competitorNum).get(2).equals(Integer.toString(coinsList.get(0)))) {
                coinsWinnerList.add(competitorNum);
            }
        }

        gameWinnersDetails.put(1,scoreWinnerList); //put data into hashmap
        gameWinnersDetails.put(2,distanceWinnerList);
        gameWinnersDetails.put(3,coinsWinnerList);
    }

    public static void viewAllThreeWinners(HashMap<Integer,List<String>> competitorDetails,HashMap<Integer,List<Integer>> gameWinnersDetails) { //display details of all three winners
        if (competitorDetails.size() != 0) {  //check if there`re any winner details to show
            findAllThreeWinners(competitorDetails,gameWinnersDetails);  //call findAllThreeWinners() method

            GridPane gridlayout = new GridPane();  //create GUI
            gridlayout.setStyle("-fx-background-color:#D9F00E");
            gridlayout.setPadding(new Insets(20, 20, 20, 20));
            gridlayout.setVgap(15);
            gridlayout.setHgap(15);

            Label message = new Label("Here are the winners in each category"); //create labels and add them into layout to show details of the winners
            message.setFont(new Font("Arial Rounded MT Bold", 20));
            gridlayout.add(message, 16, 2, 40, 1);

            int xPosition = 6, yPosition = 4;

            Label highestScore = new Label("The competitor with the highest score : "); //show details of the competitor with the highest score
            highestScore.setFont(new Font("Arial Rounded MT Bold", 20));
            gridlayout.add(highestScore, 4, yPosition, 40, 1);
            for (Integer competitorNum : competitorDetails.keySet()) {
                if (gameWinnersDetails.get(1).contains(competitorNum)) {
                    Label competitorNo = new Label("            Competitor number : " + competitorNum);
                    competitorNo.setFont(new Font("Calibri", 18));
                    gridlayout.add(competitorNo, xPosition, yPosition + 1, 8, 1);
                    Label name = new Label("            Name of the competitor : " + competitorDetails.get(competitorNum).get(0));
                    name.setFont(new Font("Calibri", 18));
                    gridlayout.add(name, xPosition, yPosition + 2, 8, 1);
                    Label age = new Label("            Age in years : " + competitorDetails.get(competitorNum).get(1));
                    age.setFont(new Font("Calibri", 18));
                    gridlayout.add(age, xPosition, yPosition + 3, 8, 1);
                    Label noOfCoins = new Label("            No of coins collected : " + competitorDetails.get(competitorNum).get(2));
                    noOfCoins.setFont(new Font("Calibri", 18));
                    gridlayout.add(noOfCoins, xPosition, yPosition + 4, 8, 1);
                    Label score = new Label("            Score achieved : " + competitorDetails.get(competitorNum).get(3));
                    score.setFont(new Font("Calibri", 18));
                    gridlayout.add(score, xPosition, yPosition + 5, 8, 1);
                    Label distance = new Label("            Distance reached in meters: " + competitorDetails.get(competitorNum).get(4));
                    distance.setFont(new Font("Calibri", 18));
                    gridlayout.add(distance, xPosition, yPosition + 6, 8, 1);
                    yPosition += 8;
                }
            }

            Label maximumDistance = new Label("The competitor who ran the maximum distance : "); //show details of the competitor who ran the max distance
            maximumDistance.setFont(new Font("Arial Rounded MT Bold", 20));
            gridlayout.add(maximumDistance, 4, yPosition + 2, 40, 1);
            yPosition += 3;
            for (Integer competitorNum : competitorDetails.keySet()) {
                if (gameWinnersDetails.get(2).contains(competitorNum)) {
                    Label competitorNo = new Label("            Competitor number : " + competitorNum);
                    competitorNo.setFont(new Font("Calibri", 18));
                    gridlayout.add(competitorNo, xPosition, yPosition, 8, 1);
                    Label name = new Label("            Name of the competitor : " + competitorDetails.get(competitorNum).get(0));
                    name.setFont(new Font("Calibri", 18));
                    gridlayout.add(name, xPosition, yPosition + 1, 8, 1);
                    Label age = new Label("            Age in years : " + competitorDetails.get(competitorNum).get(1));
                    age.setFont(new Font("Calibri", 18));
                    gridlayout.add(age, xPosition, yPosition + 2, 8, 1);
                    Label noOfCoins = new Label("            No of coins collected : " + competitorDetails.get(competitorNum).get(2));
                    noOfCoins.setFont(new Font("Calibri", 18));
                    gridlayout.add(noOfCoins, xPosition, yPosition + 3, 8, 1);
                    Label score = new Label("            Score achieved : " + competitorDetails.get(competitorNum).get(3));
                    score.setFont(new Font("Calibri", 18));
                    gridlayout.add(score, xPosition, yPosition + 4, 8, 1);
                    Label distance = new Label("            Distance reached in meters: " + competitorDetails.get(competitorNum).get(4));
                    distance.setFont(new Font("Calibri", 18));
                    gridlayout.add(distance, xPosition, yPosition + 5, 8, 1);
                    yPosition += 8;
                }
            }

            Label maximumCoins = new Label("The competitor who collected the maximum no. of gold coins : "); //show details of the competitor who collected the max no of coins
            maximumCoins.setFont(new Font("Arial Rounded MT Bold", 20));
            gridlayout.add(maximumCoins, 4, yPosition + 2, 40, 1);
            yPosition += 3;
            for (Integer competitorNum : competitorDetails.keySet()) {
                if (gameWinnersDetails.get(3).contains(competitorNum)) {
                    Label competitorNo = new Label("            Competitor number : " + competitorNum);
                    competitorNo.setFont(new Font("Calibri", 18));
                    gridlayout.add(competitorNo, xPosition, yPosition, 8, 1);
                    Label name = new Label("            Name of the competitor : " + competitorDetails.get(competitorNum).get(0));
                    name.setFont(new Font("Calibri", 18));
                    gridlayout.add(name, xPosition, yPosition + 1, 8, 1);
                    Label age = new Label("            Age in years : " + competitorDetails.get(competitorNum).get(1));
                    age.setFont(new Font("Calibri", 18));
                    gridlayout.add(age, xPosition, yPosition + 2, 8, 1);
                    Label noOfCoins = new Label("            No of coins collected : " + competitorDetails.get(competitorNum).get(2));
                    noOfCoins.setFont(new Font("Calibri", 18));
                    gridlayout.add(noOfCoins, xPosition, yPosition + 3, 8, 1);
                    Label score = new Label("            Score achieved : " + competitorDetails.get(competitorNum).get(3));
                    score.setFont(new Font("Calibri", 18));
                    gridlayout.add(score, xPosition, yPosition + 4, 8, 1);
                    Label distance = new Label("            Distance reached in meters: " + competitorDetails.get(competitorNum).get(4));
                    distance.setFont(new Font("Calibri", 18));
                    gridlayout.add(distance, xPosition, yPosition + 5, 8, 1);
                    yPosition += 8;
                }
            }

            ScrollPane scrollPane = new ScrollPane(gridlayout);  //add a scroll pane
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);

            Scene scene = new Scene(scrollPane, 2300, 700);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("View winners in all three categories");
            primaryStage.setScene(scene);
            primaryStage.showAndWait();  //show GUI
        } else {
            System.out.println("There`s no recorded details about any competitor.Hence there aren`t any winners to show.");
        }
    }

    public static void viewSelectedWinner(HashMap<Integer,List<String>> competitorDetails,HashMap<Integer,List<Integer>> gameWinnersDetails) { //display details of a selected winner
        if (competitorDetails.size() != 0) {  //check if there`re any winner details to show
            findAllThreeWinners(competitorDetails,gameWinnersDetails);  //call findAllThreeWinners() method

            GridPane gridlayout = new GridPane();  //create GUI
            gridlayout.setStyle("-fx-background-color:#FFAFC5");
            gridlayout.setPadding(new Insets(20, 20, 20, 20));
            gridlayout.setVgap(15);
            gridlayout.setHgap(15);

            Label option1 = new Label("1 - The competitor with the highest score"); //create labels and buttons to get
            option1.setFont(new Font("Arial Rounded MT Bold", 17));     //the winning category that want to show details
            gridlayout.add(option1, 8, 3, 40, 1);
            Label option2 = new Label("2 - The competitor who ran the maximum distance");
            option2.setFont(new Font("Arial Rounded MT Bold", 17));
            gridlayout.add(option2, 8, 4, 40, 1);
            Label option3 = new Label("3 - The competitor who collected the maximum no. of gold coins");
            option3.setFont(new Font("Arial Rounded MT Bold", 17));
            gridlayout.add(option3, 8, 5, 40, 1);
            Label message = new Label("Please enter the relevant option number to get the details of the winner of your preferred category : ");
            message.setFont(new Font("Arial Rounded MT Bold", 18));
            gridlayout.add(message, 2, 7, 45, 1);
            TextField option = new TextField();
            gridlayout.add(option, 50, 7, 16, 1);
            Button okButton = new Button("OK");
            okButton.setFont(new Font("Arial Rounded MT Bold", 18));
            gridlayout.add(okButton, 55, 8, 20, 1);

            okButton.setOnAction(event -> {  //set an event handler to 'okButton'
                String optionNum = option.getText();
                int xPosition = 10, yPosition = 10;

                try {
                    int category = Integer.parseInt(optionNum);
                    if (category >= 1 && category <= 3) {  //check if the user input is within valid inputs
                        switch (category) {
                            case 1:
                                Label highestScore = new Label("The competitor with the highest score : "); //show details of the competitor with the highest score
                                highestScore.setFont(new Font("Arial Rounded MT Bold", 20));
                                gridlayout.add(highestScore, 8, 9, 40, 1);
                                for (Integer competitorNum : competitorDetails.keySet()) {
                                    if (gameWinnersDetails.get(1).contains(competitorNum)) {
                                        Label competitorNo = new Label("            Competitor number : " + competitorNum);
                                        competitorNo.setFont(new Font("Calibri", 18));
                                        gridlayout.add(competitorNo, xPosition, yPosition, 20, 1);
                                        Label name = new Label("            Name of the competitor : " + competitorDetails.get(competitorNum).get(0));
                                        name.setFont(new Font("Calibri", 18));
                                        gridlayout.add(name, xPosition, yPosition + 1, 20, 1);
                                        Label age = new Label("            Age in years : " + competitorDetails.get(competitorNum).get(1));
                                        age.setFont(new Font("Calibri", 18));
                                        gridlayout.add(age, xPosition, yPosition + 2, 20, 1);
                                        Label noOfCoins = new Label("            No of coins collected : " + competitorDetails.get(competitorNum).get(2));
                                        noOfCoins.setFont(new Font("Calibri", 18));
                                        gridlayout.add(noOfCoins, xPosition, yPosition + 3, 20, 1);
                                        Label score = new Label("            Score achieved : " + competitorDetails.get(competitorNum).get(3));
                                        score.setFont(new Font("Calibri", 18));
                                        gridlayout.add(score, xPosition, yPosition + 4, 20, 1);
                                        Label distance = new Label("            Distance reached in meters: " + competitorDetails.get(competitorNum).get(4));
                                        distance.setFont(new Font("Calibri", 18));
                                        gridlayout.add(distance, xPosition, yPosition + 5, 20, 1);
                                        yPosition += 7;
                                    }
                                }
                                break;
                            case 2:
                                Label maximumDistance = new Label("The competitor who ran the maximum distance : "); //show details of the competitor who ran the max distance
                                maximumDistance.setFont(new Font("Arial Rounded MT Bold", 20));
                                gridlayout.add(maximumDistance, 8, 9, 40, 1);
                                for (Integer competitorNum : competitorDetails.keySet()) {
                                    if (gameWinnersDetails.get(2).contains(competitorNum)) {
                                        Label competitorNo = new Label("            Competitor number : " + competitorNum);
                                        competitorNo.setFont(new Font("Calibri", 18));
                                        gridlayout.add(competitorNo, xPosition, yPosition, 20, 1);
                                        Label name = new Label("            Name of the competitor : " + competitorDetails.get(competitorNum).get(0));
                                        name.setFont(new Font("Calibri", 18));
                                        gridlayout.add(name, xPosition, yPosition + 1, 20, 1);
                                        Label age = new Label("            Age in years : " + competitorDetails.get(competitorNum).get(1));
                                        age.setFont(new Font("Calibri", 18));
                                        gridlayout.add(age, xPosition, yPosition + 2, 20, 1);
                                        Label noOfCoins = new Label("            No of coins collected : " + competitorDetails.get(competitorNum).get(2));
                                        noOfCoins.setFont(new Font("Calibri", 18));
                                        gridlayout.add(noOfCoins, xPosition, yPosition + 3, 20, 1);
                                        Label score = new Label("            Score achieved : " + competitorDetails.get(competitorNum).get(3));
                                        score.setFont(new Font("Calibri", 18));
                                        gridlayout.add(score, xPosition, yPosition + 4, 20, 1);
                                        Label distance = new Label("            Distance reached in meters: " + competitorDetails.get(competitorNum).get(4));
                                        distance.setFont(new Font("Calibri", 18));
                                        gridlayout.add(distance, xPosition, yPosition + 5, 20, 1);
                                        yPosition += 7;
                                    }
                                }
                                break;
                            case 3:
                                Label maximumCoins = new Label("The competitor who collected the maximum no. of gold coins : "); //show details of the competitor who collected the max no of coins
                                maximumCoins.setFont(new Font("Arial Rounded MT Bold", 20));
                                gridlayout.add(maximumCoins, 8, 9, 40, 1);
                                for (Integer competitorNum : competitorDetails.keySet()) {
                                    if (gameWinnersDetails.get(3).contains(competitorNum)) {
                                        Label competitorNo = new Label("            Competitor number : " + competitorNum);
                                        competitorNo.setFont(new Font("Calibri", 18));
                                        gridlayout.add(competitorNo, xPosition, yPosition, 20, 1);
                                        Label name = new Label("            Name of the competitor : " + competitorDetails.get(competitorNum).get(0));
                                        name.setFont(new Font("Calibri", 18));
                                        gridlayout.add(name, xPosition, yPosition + 1, 20, 1);
                                        Label age = new Label("            Age in years : " + competitorDetails.get(competitorNum).get(1));
                                        age.setFont(new Font("Calibri", 18));
                                        gridlayout.add(age, xPosition, yPosition + 2, 20, 1);
                                        Label noOfCoins = new Label("            No of coins collected : " + competitorDetails.get(competitorNum).get(2));
                                        noOfCoins.setFont(new Font("Calibri", 18));
                                        gridlayout.add(noOfCoins, xPosition, yPosition + 3, 20, 1);
                                        Label score = new Label("            Score achieved : " + competitorDetails.get(competitorNum).get(3));
                                        score.setFont(new Font("Calibri", 18));
                                        gridlayout.add(score, xPosition, yPosition + 4, 20, 1);
                                        Label distance = new Label("            Distance reached in meters: " + competitorDetails.get(competitorNum).get(4));
                                        distance.setFont(new Font("Calibri", 18));
                                        gridlayout.add(distance, xPosition, yPosition + 5, 20, 1);
                                        yPosition += 7;
                                    }
                                }
                                break;
                        }
                    } else {  //execute if user input is not within the valid input range
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Invalid Data Alert");
                        alert.setContentText("Please enter a valid number within the given option numbers");
                        alert.showAndWait();
                    }
                } catch (Exception e) {  //execute if user has entered an input of invalid data type
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Data Alert");
                    alert.setContentText("Please enter a valid number within the given option numbers");
                    alert.showAndWait();
                }
            });

            ScrollPane scrollPane = new ScrollPane(gridlayout); //add a scroll pane
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);

            Scene scene = new Scene(scrollPane, 2300, 700);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("View the winner in a selected category");
            primaryStage.setScene(scene);
            primaryStage.showAndWait(); //show GUI
        } else {
            System.out.println("There`s no recorded details about any competitor.Hence there aren`t any winners to show.");
        }
    }

}