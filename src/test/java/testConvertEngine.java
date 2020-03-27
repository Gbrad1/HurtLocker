import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class testConvertEngine {

    private ConvertEngine ce;
    private String data;
    private List<Produce> list;
    private Main main;
    private Map<String, LinkedHashMap<String, Integer>> products = new LinkedHashMap<>();

    @Before
    public void setup() {
        ce = new ConvertEngine();
        list = new ArrayList<>();
        try{
            data = new Main().readRawDataToString();
        } catch (Exception c) {
            c.printStackTrace();
        }
    }

    @Test
    public void testSplitString() {
        ce.printArrayOfStrings(ce.splitString(data));
        Assert.assertEquals(28, ce.getSize());
    }

    @Test
    public void testPrintOutStrings() {
        ce.printArrayOfStrings(ce.splitString(data));
    }

    @Test
    public void testGetSize() {
        ce.splitString(data);
        Assert.assertEquals(28, ce.getSize());
    }

    @Test
    public void testMaster() {
        String[] arr = ce.splitString(data);
        ce.generateProduce(arr);
        Assert.assertEquals(28, ce.getListOfProduce().size());
    }

    @Test
    public void testPrintProduce() {
        String[] arr = ce.splitString(data);
        ce.generateProduce(arr);
        list = ce.getListOfProduce();
        ce.printProduce(list);
    }

    @Test
    public void testMapProduceAndPrice() {
        String[] arr = ce.splitString(data);
        ce.generateProduce(arr);
        list = ce.getListOfProduce();
        ce.mapProduceAndPrice();
    }

    @Test
    public void testToString() {
        String[] arr = ce.splitString(data);
        ce.generateProduce(arr);
        ce.toString();
    }

}
