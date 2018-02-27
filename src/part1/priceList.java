package part1;

import java.util.HashMap;
import java.util.Map;

public class priceList {

    Map<products, price> list = new HashMap<>();

    public priceList(Map<products, price> other) {
        this.list = other;
    }

    //добавление товара и его цены.
    public void add(products newProduct, price newPrice) {
        list.put(newProduct, newPrice);
    }

    // изменение цены товара по имену товара
    public void fixPrice(String name, price newPrice) {
        for (products element : list.keySet()) {
            if (element.getName() == name) {
                list.put(element, newPrice);
                break;
            }
        }
    }

    // изменение имени товара
    public void fixName(String name, String newName) {
        for (products element : list.keySet()) {
            if (element.getName() == name) {
                element.setName(newName);
                break;
            }
        }
    }

    //удаление товар по коду
    public void delete(int code) {
        for (products element : list.keySet()) {
            if (element.getCode() == code) {
                list.remove(element);
                break;
            }
        }
    }

    //определение цены покупки по коду и количеству экземпляров
    public price findPrice(int amount, int code) {
        for (products element : list.keySet()) {
            if (element.getCode() == code) {
                double pr = list.get(element).priceProduct() * amount;
                int rb = (int) pr;
                double cp = (pr - (double) rb) * 100;
                return new price(rb, (int) cp);
            }
        }
        return null;
    }

}
