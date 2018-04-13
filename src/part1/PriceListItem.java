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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj instanceof PriceListItem) {
            PriceListItem other = (PriceListItem) obj;
            return name == other.name && code == other.code && getPrice() == other.getPrice();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return code * (rub + copek / 100) * 31;
    }

    @Override
    public String toString() {
         return name + "(" + code + "," + this.getPrice()+")";
    }
}
