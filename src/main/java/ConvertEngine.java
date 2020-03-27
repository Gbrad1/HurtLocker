import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertEngine {

    private String[] arr;
    private Pattern patternMilk;
    private Pattern patternApple;
    private Pattern patternBread;
    private Pattern patternCookie;
    private Matcher matcherMilk;
    private Matcher matcherApple;
    private Matcher matcherBread;
    private Matcher matcherCookie;
    private Produce tempProduce;
    private String string;
    private Map<String, LinkedHashMap<String, Integer>> amountOfProducts = new LinkedHashMap<>();
    List<Produce> listOfProduce = new ArrayList<>();
    private String regexMilk = "[mM][iI][lL][kK]";
    private String regexBread = "[bB][rR][eE][aA][dD]";
    private String regexCookie = "[cC][oO0][oO0][kK][iI][eE][sS]";
    private String regexApple = "[aA][pP][pP][lL][eE][sS]";

    public ConvertEngine() {}

    public void executeMasterCommand(String data) {
        splitString(data);
        generateProduce(arr);
    }

    public void printArrayOfStrings(String[] array) {
        for (String element : array) {
            System.out.println(element);
        }
    }

    public int getSize() {
        return arr.length;
    }

    public String[] splitString(String string) {
        arr = string.split("##");
        return arr;
    }

    public String printProduce(List<Produce> list) {
        String toReturn = "";
        for (Produce element : list) {
            toReturn += element.toString();
            toReturn += "\n";
        }
        System.out.println(toReturn);
        return toReturn;
    }

    public List<Produce> generateProduce(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Produce foodToAdd = findProduceName(arr[i]);
            foodToAdd.setPrice(findProducePrice(arr[i]));
            listOfProduce.add(tempProduce);
        }
        return listOfProduce;
    }

    public Produce findProduceName(String string) {
        patternMilk = Pattern.compile(regexMilk);
        patternApple = Pattern.compile(regexApple);
        patternBread = Pattern.compile(regexBread);
        patternCookie = Pattern.compile(regexCookie);
        matcherMilk = patternMilk.matcher(string);
        matcherApple = patternApple.matcher(string);
        matcherBread = patternBread.matcher(string);
        matcherCookie = patternCookie.matcher(string);

        if (matcherMilk.find()) {
            tempProduce = new Produce("Milk", null);
        }

        if (matcherApple.find()) {
            tempProduce = new Produce("Apple", null);
        }

        if (matcherBread.find()) {
            tempProduce = new Produce("Bread", null);
        }

        if (matcherCookie.find()) {
            tempProduce = new Produce("Cookie", null);
        }

        return tempProduce;
    }

    public String findProducePrice(String string) {
        String[] info = string.split("[!@#$%^&*(),?:;{}|<>]");
        return info[3];
    }

    public void mapProduceAndPrice() {
        for (int i = 0; i < listOfProduce.size(); i++) {
            if (!amountOfProducts.containsKey(listOfProduce.get(i).getName())) {
                LinkedHashMap<String, Integer> prices = new LinkedHashMap<>();
                checkIfPriceExistsYet(prices, i);
                amountOfProducts.put(listOfProduce.get(i).getName(), prices);
            } else {
                checkIfPriceExistsYet(amountOfProducts.get(listOfProduce.get(i).getName()), i);
            }
        }
    }

    public void checkIfPriceExistsYet(LinkedHashMap<String, Integer> map, int index) {
        if (!map.containsKey(listOfProduce.get(index).getPrice())) {
            map.put(listOfProduce.get(index).getPrice(), 1);
        } else {
            map.put(listOfProduce.get(index).getPrice(), map.get(listOfProduce.get(index).getPrice() + 1));
        }
    }

    public Map<String, LinkedHashMap<String, Integer>> getAmountOfProducts() {
        return amountOfProducts;
    }

    public List<Produce> getListOfProduce() {
        return listOfProduce;
    }

    @Override
    public String toString() {
        String string = "name: %7s    seen: %1s times\n=============    =============\n";
        String string1 = "Price: %7s    seen: %1s times\n-------------    -------------\n";

        String toReturn = "";
        for (Map.Entry<String, LinkedHashMap<String, Integer>> element : amountOfProducts.entrySet()) {
            toReturn += String.format(string, element.getKey(), element.getValue());

            }
        System.out.println(toReturn);
        return toReturn;
    }
}
