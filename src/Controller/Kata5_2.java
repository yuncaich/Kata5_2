package Controller;



import Model.DataBase;
import Model.Histogram;
import View.DataBaseHistogramBuilder;
import View.HistogramDisplay;
import java.util.HashMap;

public class Kata5_2 {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\Saulo\\Documents\\NetBeansProjects\\Kata6\\Sqlite\\kata6.db";
        DataBase database = new DataBase(url);
        database.open();
        database.select();
        HashMap<String,String> dataBaseMap = database.components;
        Histogram histogram = DataBaseHistogramBuilder.build(dataBaseMap);
        HistogramDisplay histogramdisplay = new HistogramDisplay(histogram);
        histogramdisplay.execute();
        database.close();
    }
}