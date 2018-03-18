package part1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PriceList {

    private Map<Integer, PriceListItem> list;

    public Map<Integer, PriceListItem> getList() {
        return Collections.unmodifiableMap(list);
    }

    public PriceList() {
        this.list = new HashMap<>();
    }

    //добавление товара.
    public void add(int code, PriceListItem product) {
        list.put(code, product);
    }

    // изменение цены товара по кода товара
    public void fixPrice(int code, double price) {
        int rub = (int) price;
        int copek = (int) ((price - rub) * 100);
        PriceListItem product1 = list.get(code);
        list.put(code, new PriceListItem(product1.getName(), code, rub, copek));
    }

    // изменение имени товара по кода товара
    public void fixName(int code, String name) {
        PriceListItem product = list.get(code);
        list.put(code, new PriceListItem(name, product.getCode(), product.getRub(), product.getCopek()));
    }

    //удаление товар по коду
    public void delete(int code) {
        list.remove(code);
    }

    //определение цены покупки по коду и количеству экземпляров
    public double findPrice(int amount, int code) {
        return list.get(code).getPrice() * amount;
    }

    //получения размера прайс-листа
    public int getSize() {
        return list.size();
    }

    //поиска товара по коду
    public PriceListItem getProduct(int code) {
        return list.get(code);
    }

    //поиска товара , цена которого самая дорогая
    public PriceListItem maxPice() {
        double max = 0.0;
        PriceListItem result = null;
        for (PriceListItem element : list.values()) {
            if (element.getPrice() > max) {
                max = element.getPrice();
                result = element;
            }
        }
        return result;
    }

    //поиска товара , цена которого самая дешевая
    public PriceListItem minPice() {
        PriceListItem result = this.maxPice();
        double min = result.getPrice();
        for (PriceListItem element : list.values()) {
            if (element.getPrice() < min) {
                min = element.getPrice();
                result = element;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "list of products: ";
        for (PriceListItem element : list.values()) {
            result += (element.getName() + "( code: " + element.getCode() + " Price: " + element.getPrice() + "); ");
        }
        if (list.isEmpty()) return "There are no products in the list.";
        return result;
    }

    @Override
    public int hashCode() {
        int result = list.size();
        for (PriceListItem element : list.values()) {
            result += element.hashCode() * 31;
        }
        return result;
    }

    public static void main(String[] args) {
        PriceList pl = new PriceList();
        pl.add(1, new PriceListItem("a", 1, 300, 20));
        pl.add(2, new PriceListItem("b", 2, 400, 50));
        System.out.println(pl.toString());
    }
}
