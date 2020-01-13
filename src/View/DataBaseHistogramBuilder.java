package View;

import Model.Histogram;
import java.util.Map;

public class DataBaseHistogramBuilder {

    public DataBaseHistogramBuilder() {
    }
    
    public static Histogram build(Map<String,String> personList) {
        Histogram<String> histogram = new Histogram();
        for(String string : personList.keySet()){
            histogram.increment(personList.get(string));
        }
        return histogram;
    }
}
