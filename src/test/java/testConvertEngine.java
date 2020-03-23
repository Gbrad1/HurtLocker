import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testConvertEngine {

    ConvertEngine ce;
    String data;

    @Before
    public void setup() {
        ce = new ConvertEngine();
        data = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
    }

    @Test
    public void testSplitString() {
        ce.splitString(data);
        Assert.assertEquals(251, ce.getSize());
    }

    @Test
    public void testPrintOutStrings() {
        ce.printArrayOfStrings(ce.splitString(data));
    }

    @Test
    public void testGetSize() {
        ce.splitString(data);
        Assert.assertEquals(251, ce.getSize());
    }

    @Test
    public void testMapMilk() {
        ce.splitString(data);
        ce.mapMilk();
        int actualAmountOfMilk = ce.getAmountOfProducts().get("Milk");
        Assert.assertTrue(ce.getAmountOfProducts().containsKey("Milk"));
        Assert.assertEquals(8, actualAmountOfMilk);
    }

    @Test
    public void testMapBread() {
        ce.splitString(data);
        ce.mapBread();
        int actualAmountOfBread = ce.getAmountOfProducts().get("Bread");
        Assert.assertTrue(ce.getAmountOfProducts().containsKey("Bread"));
        Assert.assertEquals(6, actualAmountOfBread);
    }

    @Test
    public void testMapCookies() {
        ce.splitString(data);
        ce.mapCookies();
        int actualAmountOfCookies = ce.getAmountOfProducts().get("Cookies");
        Assert.assertTrue(ce.getAmountOfProducts().containsKey("Cookies"));
        Assert.assertEquals(8, actualAmountOfCookies);
    }

    @Test
    public void testMapApples() {
        ce.splitString(data);
        ce.mapApples();
        int actualAmountOfApples = ce.getAmountOfProducts().get("Apples");
        Assert.assertTrue(ce.getAmountOfProducts().containsKey("Apples"));
        Assert.assertEquals(4, actualAmountOfApples);
    }

    @Test
    public void testMapAllFood() {
        ce.executeMasterCommand(data);

        int actualAmountOfMilk = ce.getAmountOfProducts().get("Milk");
        int actualAmountOfBread = ce.getAmountOfProducts().get("Bread");
        int actualAmountOfCookies = ce.getAmountOfProducts().get("Cookies");
        int actualAmountOfApples = ce.getAmountOfProducts().get("Apples");

        Assert.assertTrue(ce.getAmountOfProducts().containsKey("Apples"));
        Assert.assertEquals(4, actualAmountOfApples);
        Assert.assertTrue(ce.getAmountOfProducts().containsKey("Cookies"));
        Assert.assertEquals(8, actualAmountOfCookies);
        Assert.assertTrue(ce.getAmountOfProducts().containsKey("Bread"));
        Assert.assertEquals(6, actualAmountOfBread);
        Assert.assertTrue(ce.getAmountOfProducts().containsKey("Milk"));
        Assert.assertEquals(8, actualAmountOfMilk);

    }

    @Test
    public void testGetAppleFirstPrice() {
        ce.executeMasterCommand(data);
        ce.getFirstApplePrice();
        int actualAmountOfFirstApplePrices = ce.getAmountOfPrices().get("0.25");
        Assert.assertTrue(ce.getAmountOfPrices().containsKey("0.25"));
        Assert.assertEquals(2, actualAmountOfFirstApplePrices);
    }

    @Test
    public void testGetAppleSecondPrice() {
        ce.executeMasterCommand(data);
        ce.getSecondApplePrice();
        int actualAmountOfSecondApplePrices = ce.getAmountOfPrices().get("0.23");
        Assert.assertTrue(ce.getAmountOfPrices().containsKey("0.23"));
        Assert.assertEquals(2, actualAmountOfSecondApplePrices);
    }

    @Test
    public void testGetBreadPrice() {
        ce.executeMasterCommand(data);
        ce.getBreadPrice();
        int actualamountOfBreadPrices = ce.getAmountOfPrices().get("1.23");
        Assert.assertTrue(ce.getAmountOfPrices().containsKey("1.23"));
        Assert.assertEquals(7, actualamountOfBreadPrices);
    }

    @Test
    public void testGetCookiesPrice() {
        ce.executeMasterCommand(data);
        ce.getCookiesPrice();
        int actualAmountOfCookiePrices = ce.getAmountOfPrices().get("2.25");
        Assert.assertTrue(ce.getAmountOfPrices().containsKey("2.25"));
        Assert.assertEquals(8, actualAmountOfCookiePrices);
    }


    @Test
    public void testGetMilkFirstPrice() {
        ce.executeMasterCommand(data);
        ce.getMilkFirstPrice();
        int actualAmountOfMilkFirstPrices = ce.getAmountOfPrices().get("1.23");
        Assert.assertTrue(ce.getAmountOfPrices().containsKey("1.23"));
        Assert.assertEquals(7, actualAmountOfMilkFirstPrices);
    }

    @Test
    public void testGetMilkSecondPrice() {
        ce.executeMasterCommand(data);
        ce.getMilkSecondPrice();
        int actualamountOfSecondMilkPrices = ce.getAmountOfPrices().get("3.23");
        Assert.assertTrue(ce.getAmountOfPrices().containsKey("3.23"));
        Assert.assertEquals(7, actualamountOfSecondMilkPrices);
    }

}
