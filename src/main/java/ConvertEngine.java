import java.util.LinkedHashMap;
import java.util.Map;

public class ConvertEngine {

    private String[] toReturn;
    private char[] charArray;
    private Map<String, Integer> amountOfProducts = new LinkedHashMap<>();
    private Map<String, Integer> amountOfPrices = new LinkedHashMap<>();
    private String regexMilk = "^[mM][iI][lL][kK]$";
    private String regexBread = "^[bB][rR][eE][aA][dD]$";
    private String regexCookie = "^[cC][oO0][oO0][kK][iI][eE][sS]$";
    private String regexApple = "^[aA][pP][pP][lL][eE][sS]$";

    public ConvertEngine() {}

    public void executeMasterCommand(String data) {
        convertIntoPairs(data);
        mapAllFood();
    }

    public void convertIntoPairs(String string) {
        charArray = string.toCharArray();
        String[] buffer = new String[string.length()];
        int count = 0;
        String toAdd = "";

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '#') {
                toAdd += charArray[i];
            } else {
                buffer[count++] = toAdd;
                i++;
                toAdd = "";
            }
        }

        toReturn = new String[count];
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != null) {
                toReturn[i] = buffer[i];
            }
        }
    }

    public void printArrayOfStrings() {
        for (String element : toReturn) {
            System.out.println(element);
        }
    }

    public int getSize() {
        return toReturn.length;
    }

    public void mapMilk() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if (toReturn[i].substring(5, 9).matches(regexMilk)) {
                count++;
            }
            amountOfProducts.put("Milk", count);
        }
    }

    public void mapBread() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if (toReturn[i].substring(5, 10).matches(regexBread)) {
                count++;
            }
            amountOfProducts.put("Bread", count);
        }
    }

    public void mapCookies() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if (toReturn[i].substring(5, 12).matches(regexCookie)) {
                count++;
            }
            amountOfProducts.put("Cookies", count);
        }
    }

    public void mapApples() {
        int count = 0;
        for (int i = 0; i < toReturn.length; i++) {
            if (toReturn[i].substring(5, 11).matches(regexApple)) {
                count++;
            }
            amountOfProducts.put("Apples", count);
        }
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
}
