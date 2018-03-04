package part1;

public class PriceListItem {
    private String name;
    private int code;
    private int rub;
    private int copek;

    public PriceListItem(String name, int code, int rub, int copek) {
        this.name = name;
        this.code = code;
        this.rub = rub;
        this.copek = copek;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public int getRub() {
        return rub;
    }

    public int getCopek() {
        return copek;
    }

    public double getPrice() {
        return (double) rub + (double) copek / 100;
    }

}
