package part1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PriceListTest {
    PriceList pl = new PriceList();

    @Test
    void add() {
        PriceList pl = new PriceList();
        assertEquals(0, pl.getSize());
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        assertEquals(4, pl.getSize());
        assertEquals(
                "list of products: phone( code: 1 Price: 2000.5); " +
                        "car( code: 2 Price: 300000.6); computer( code: 3 Price: 4000.8); " +
                        "television( code: 4 Price: 6000.4); ", pl.toString());
    }

    @Test
    void fixPrice() {
        PriceList pl = new PriceList();
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        pl.fixPrice(1, 5000.5);
        assertEquals(5000.5, pl.getProduct(1).getPrice());
    }

    @Test
    void fixName() {
        PriceList pl = new PriceList();
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        pl.fixName(2, "water");
        assertEquals("water", pl.getProduct(2).getName());
    }

    @Test
    void delete() {
        PriceList pl = new PriceList();
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        pl.delete(1);
        pl.delete(2);
        assertEquals(null, pl.getProduct(1));
        assertEquals(2, pl.getSize());
        assertEquals("list of products: computer( code: 3 Price: 4000.8); television( code: 4 Price: 6000.4); "
                , pl.toString());
    }

    @Test
    void findPrice() {
        PriceList pl = new PriceList();
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        assertEquals(10002.5, pl.findPrice(5, 1), 1e-5);
        assertEquals(1800003.6, pl.findPrice(6, 2), 1e-5);
        assertEquals(8001.6, pl.findPrice(2, 3), 1e-5);
        assertEquals(24001.6, pl.findPrice(4, 4), 1e-5);
    }

    @Test
    void getSize() {
        PriceList pl = new PriceList();
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        assertEquals(4, pl.getSize());
        pl.delete(1);
        assertEquals(3, pl.getSize());
    }

    @Test
    void getProduct() {
        PriceList pl = new PriceList();
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        assertEquals("name: car, code: 2, price: 300000.6", pl.getProduct(2).toString());
    }

    @Test
    void maxPrice() {
        PriceList pl = new PriceList();
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        assertEquals("name: car, code: 2, price: 300000.6", pl.maxPice().toString());
    }

    @Test
    void minPrice() {
        PriceList pl = new PriceList();
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        assertEquals("name: phone, code: 1, price: 2000.5", pl.minPice().toString());
    }
}