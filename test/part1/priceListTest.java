package part1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PriceListTest {

    @Test
    void add() {
        PriceList pl = new PriceList(new HashMap<>());
        assertEquals(0, pl.getSize());
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        assertEquals(4, pl.getSize());
    }

    @Test
    void fixPrice() {
        PriceList pl = new PriceList(new HashMap<>());
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        pl.fixPrice(1, 5000.5);
        assertEquals(5000.5, pl.getProduct(1).getPrice());
    }

    @Test
    void fixName() {
        PriceList pl = new PriceList(new HashMap<>());
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        pl.fixName(2, "water");
        assertEquals("water", pl.getProduct(2).getName());
    }

    @Test
    void delete() {
        PriceList pl = new PriceList(new HashMap<>());
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        pl.delete(1);
        pl.delete(2);
        assertEquals(null, pl.getProduct(1));
        assertEquals(2, pl.getSize());
    }

    @Test
    void findPrice() {
        PriceList pl = new PriceList(new HashMap<>());
        pl.add(1, new PriceListItem("phone", 1, 2000, 50));
        pl.add(2, new PriceListItem("car", 2, 300000, 60));
        pl.add(3, new PriceListItem("computer", 3, 4000, 80));
        pl.add(4, new PriceListItem("television", 4, 6000, 40));
        assertEquals(24001.6, pl.findPrice(4, 4));
    }

}