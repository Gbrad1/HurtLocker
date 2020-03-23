import com.sun.javafx.binding.StringFormatter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertEngine {

    private String[] toReturn;
    private Pattern pattern;
    private Matcher matcher;
    String string;
    private Map<String, Integer> amountOfProducts = new LinkedHashMap<>();
    private Map<String, Integer> amountOfPrices = new LinkedHashMap<>();
    private String regexMilk = "[mM][iI][lL][kK]";
    private String regexBread = "[bB][rR][eE][aA][dD]";
    private String regexCookie = "[cC][oO0][oO0][kK][iI][eE][sS]";
    private String regexApple = "[aA][pP][pP][lL][eE][sS]";

    public ConvertEngine() {}

    public void executeMasterCommand(String data) {
        splitString(data);
        mapAllFood();
        mapAllPrices();
    }

    public void printArrayOfStrings(String[] array) {
        for (String element : array) {
            System.out.println(element);
        }
    }

    public int getSize() {
        return toReturn.length;
    }

    public String[] splitString(String string) {
        toReturn = string.split("[!@#$%^&*(),?\":;{}|<>]");
        return toReturn;
    }

    public String arrayToString(String[] array) {
        String string = "";
        for (String element : array) {
            string += element += " ";
        }
        return string;
    }

    public void mapMilk() {
        string = arrayToString(toReturn);
        pattern = Pattern.compile(regexMilk);
        matcher = pattern.matcher(string);
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if (matcher.find()) {
                count++;
            }
        }
        amountOfProducts.put("Milk", count);
    }

    public void mapBread() {
        string = arrayToString(toReturn);
        pattern = Pattern.compile(regexBread);
        matcher = pattern.matcher(string);
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if (matcher.find()) {
                count++;
            }
        }
        amountOfProducts.put("Bread", count);
    }

    public void mapCookies() {
        string = arrayToString(toReturn);
        pattern = Pattern.compile(regexCookie);
        matcher = pattern.matcher(string);
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if (matcher.find()) {
                count++;
            }
        }
        amountOfProducts.put("Cookies", count);
    }

    public void mapApples() {
        string = arrayToString(toReturn);
        pattern = Pattern.compile(regexApple);
        matcher = pattern.matcher(string);
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if (matcher.find()) {
                count++;
            }
        }
        amountOfProducts.put("Apples", count);
    }

    public void getFirstApplePrice() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if(toReturn[i].equals("0.25")) {
                count++;
            }
        }
        amountOfPrices.put("0.25", count);
    }

    public void getSecondApplePrice() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if(toReturn[i].equals("0.23")) {
                count++;
            }
        }
        amountOfPrices.put("0.23", count);
    }

    public void getBreadPrice() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if(toReturn[i].equals("1.23")) {
                count++;
            }
        }
        amountOfPrices.put("1.23", count);
    }

    public void getCookiesPrice() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if(toReturn[i].equals("2.25")) {
                count++;
            }
        }
        amountOfPrices.put("2.25", count);
    }

    public void getMilkFirstPrice() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if(toReturn[i].equals("1.23")) {
                count++;
            }
        }
        amountOfPrices.put("1.23", count);
    }

    public void getMilkSecondPrice() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if(toReturn[i].equals("3.23")) {
                count++;
            }
        }
        amountOfPrices.put("3.23", count);
    }


    public void mapAllPrices() {
        getFirstApplePrice();
        getSecondApplePrice();
        getBreadPrice();
        getCookiesPrice();
        getMilkFirstPrice();
        getMilkSecondPrice();
    }

    public void mapAllFood() {
        mapMilk();
        mapBread();
        mapCookies();
        mapApples();
    }


    public Map<String, Integer> getAmountOfProducts() {
        return amountOfProducts;
    }

    public Map<String, Integer> getAmountOfPrices() {
        return amountOfPrices;
    }

    @Override
    public String toString() {
        String string = String.format("name:    %s", product);
        String toReturn = "name: ";

    }
}
