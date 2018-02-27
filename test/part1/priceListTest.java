package part1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class priceListTest {

    @Test
    void add() {
        products phone = new products("phone", 2018);
        products car = new products("car", 2017);
        price pricePhone = new price(1400, 50);
        price priceCar = new price(20000, 60);
        priceList priceList = new priceList(new HashMap<>());
        assertEquals(0, priceList.list.size());
        priceList.add(phone, pricePhone);
        priceList.add(car, priceCar);
        assertEquals(2, priceList.list.size());
    }

    @Test
    void fixPrice() {
        products phone = new products("phone", 2018);
        price pricePhone = new price(1400, 50);
        priceList priceList = new priceList(new HashMap<>());
        priceList.add(phone, pricePhone);
        priceList.fixPrice("phone", new price(1000, 50));
        assertEquals(1000.5, priceList.list.get(phone).priceProduct());
    }

    @Test
    void fixName() {
        products pr = new products("phone", 2018);
        price pricePr = new price(1400, 50);
        priceList priceList = new priceList(new HashMap<>());
        priceList.add(pr, pricePr);
        priceList.fixName("phone", "car");
        assertEquals("car", pr.getName());
    }

    @Test
    void delete() {
        products phone = new products("phone", 2018);
        price pricePhone = new price(1400, 50);
        priceList priceList = new priceList(new HashMap<>());
        priceList.add(phone, pricePhone);
        priceList.delete(2018);
        assertTrue(priceList.list.isEmpty());
        assertEquals(null, priceList.list.get(phone));
    }

    @Test
    void findPrice() {
        products phone = new products("phone", 2018);
        products car = new products("car", 2017);
        price pricePhone = new price(1999, 90);
        price priceCar = new price(20000, 60);
        priceList priceList = new priceList(new HashMap<>());
        assertEquals(0, priceList.list.size());
        priceList.add(phone, pricePhone);
        priceList.add(car, priceCar);
        assertEquals(8000240.0, priceList.findPrice(400, 2017).priceProduct(),0.01);
        assertEquals(9999.5, priceList.findPrice(5, 2018).priceProduct());
    }

}