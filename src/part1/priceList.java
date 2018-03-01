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

    // изменение цены товара по кода товара
    public void fixPrice(int code, price newPrice) {
        try {
            int a = 0;
            for (products element : list.keySet()) {
                if (element.getCode() == code) {
                    list.put(element, newPrice);
                    a = 1;
                    break;
                }
            }
            if (a == 0) throw new Exception();
        } catch (Exception e) {
            System.out.println("в списке нет товара по этому коду: " + code);
        }
    }

    // изменение имени товара по кода товара
    public void fixName(int code, String newName) {
        try {
            int b = 0;
            for (products element : list.keySet()) {
                if (element.getCode() == code) {
                    element.setName(newName);
                    b = 1;
                    break;
                }
            }
            if (b == 0) throw new Exception();
        } catch (Exception e) {
            System.out.println("в списке нет товара по этому коду: " + code);
        }
    }

    //удаление товар по коду
    public void delete(int code) {
        try {
            int c = 0;
            for (products element : list.keySet()) {
                if (element.getCode() == code) {
                    list.remove(element);
                    c = 1;
                    break;
                }
            }
            if (c == 0) throw new Exception();
        } catch (Exception e) {
            System.out.println("в списке нет товара по этому коду: " + code);
        }
    }

    //определение цены покупки по коду и количеству экземпляров
    public price findPrice(int amount, int code) {
        try {
            price pre = null;
            for (products element : list.keySet()) {
                if (element.getCode() == code) {
                    double pr = list.get(element).priceProduct() * amount;
                    int rb = (int) pr;
                    double cp = (pr - (double) rb) * 100;
                    pre = new price(rb, (int) cp);
                }
            }
            if (pre == null) throw new Exception();
            return pre;
        } catch (Exception e) {
            System.out.println("в списке нет товара по этому коду: " + code);
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "list of goods: ";
        for (products element : list.keySet()) {
            price pr = list.get(element);
            result += (element.getName() + "( code: " + element.getCode() + " price: " + pr.priceProduct() + ");");
        }
        if (result == "list of goods: ") return result + "There are no goods in the list.";
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj instanceof priceList) {
            priceList other = (priceList) obj;
            return other.list == list;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return list.size() * 31;
    }

    public static void main(String[] args) {
        products phone = new products("phone", 2018);
        products car = new products("car", 2017);
        price pricePhone = new price(1999, 90);
        price priceCar = new price(20000, 60);
        priceList priceList = new priceList(new HashMap<>());
        Map<products, price> list = new HashMap<>();
        Map<products, price> list2 = new HashMap<>();
        list.put(phone, pricePhone);
        priceList.add(phone, pricePhone);
        priceList.add(car, priceCar);
        System.out.println(priceList.toString());
    }
}
