package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

public class Controller implements Initializable {
    public Label text;
    public Button generateButton;
    public Button quotes;
    public Button people;
    public Button dates;
    ArrayList peopleArray = new ArrayList();
    ArrayList peopleQuotesArray = new ArrayList();
    ArrayList quotesArray = new ArrayList();
    ArrayList datesArray = new ArrayList();
    Random rand = new Random();
    int year, month, day;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        peopleRead();
        quotesRead();
        peopleQuotesRead();
        datesRead();
    }

    public void randomClicked(MouseEvent mouseEvent) {
        randomWrite();
    }

    public void quotesClicked(MouseEvent mouseEvent) {
        quotesWrite();
    }

    public void peopleClicked(MouseEvent mouseEvent) {
        peopleWrite();
    }

    public void datesClicked(MouseEvent mouseEvent) {
        datesWrite();
    }


    public void peopleRead() {
        //File file = new File("D:\\Škola\\PRO\\IntelliJ projekty\\projektBrezenDone\\src\\sample\\people.txt");
        Scanner sc = new Scanner(getClass().getResourceAsStream("/people.txt"), "utf-8");
        while (sc.hasNextLine()) {
            peopleArray.add(sc.nextLine().toString());
        }
    }

    public void peopleQuotesRead() {
        //File file = new File("D:\\Škola\\PRO\\IntelliJ projekty\\projektBrezenDone\\src\\sample\\peopleQuotes.txt");
        Scanner sc = new Scanner(getClass().getResourceAsStream("/peopleQuotes.txt"), "utf-8");
        while (sc.hasNextLine()) {
            peopleQuotesArray.add(sc.nextLine().toString());
        }
    }

    public void quotesRead() {
        //File file = new File("D:\\Škola\\PRO\\IntelliJ projekty\\projektBrezenDone\\src\\sample\\quotes.txt");
        Scanner sc = new Scanner(getClass().getResourceAsStream("/quotes.txt"), "utf-8");
        while (sc.hasNextLine()) {
            quotesArray.add(sc.nextLine().toString());
        }
    }

    public void datesRead() {
        //File file = new File("D:\\Škola\\PRO\\IntelliJ projekty\\projektBrezenDone\\src\\sample\\dates.txt");
        Scanner sc = new Scanner(getClass().getResourceAsStream("/dates.txt"), "utf-8");
        while (sc.hasNextLine()) {
            datesArray.add(sc.nextLine().toString());
        }
    }

    public void randomDate() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(gc.YEAR, 2021);
        int dayTmp = (1 + (int) Math.round(Math.random() * (gc.getActualMaximum(gc.DAY_OF_YEAR) - 1)));
        gc.set(gc.DAY_OF_YEAR, dayTmp);
        month = gc.get(gc.MONTH) + 1;
        day = gc.get(gc.DAY_OF_MONTH);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        System.out.println("mesic: " + month + " + MONTH: " + Calendar.MONTH);
        if (month <= (calendar.get(Calendar.MONTH)) + 1) {
            year = 2022;
        } else {
            year = 2021;
        }


    }

    public void quotesWrite() {
        int maxQuotes = quotesArray.size();
        int tmpQuotes = rand.nextInt(maxQuotes);
        System.out.println(quotesArray.get(tmpQuotes));
        text.setText((quotesArray.get(tmpQuotes)).toString());
    }

    public void peopleWrite() {
        int maxPeople = peopleArray.size();
        int tmpPeople = rand.nextInt(maxPeople);
        int maxPeopleQuotes = peopleQuotesArray.size();
        int tmpPeopleQuotes = rand.nextInt(maxPeopleQuotes);
        System.out.println(peopleArray.get(tmpPeople) + ": " + peopleQuotesArray.get(tmpPeopleQuotes));
        text.setText((peopleArray.get(tmpPeople) + ": " + peopleQuotesArray.get(tmpPeopleQuotes)).toString());
    }

    public void datesWrite() {
        int maxDates = datesArray.size();
        int tmpDates = rand.nextInt(maxDates);
        randomDate();
        System.out.println(datesArray.get(tmpDates) + " " + day + ". " + month + ". " + year);
        text.setText((datesArray.get(tmpDates) + " " + day + ". " + month + ". " + year).toString());
    }

    public void randomWrite() {
        int maxRandom = 3;
        int tmpRandom = rand.nextInt(maxRandom);
        switch (tmpRandom) {
            case 0:
                quotesWrite();
                break;
            case 1:
                peopleWrite();
                break;
            case 2:
                datesWrite();
                break;
        }
    }

    public void fontSizeChecker() {
    }
}
