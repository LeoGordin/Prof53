package lesson34.currency;

import java.util.HashMap;
import java.util.Map;

public class Exchange {
    public double amount;
    public String from;
    public String to;
    public Map<String, Double> rates = new HashMap<>();
}
