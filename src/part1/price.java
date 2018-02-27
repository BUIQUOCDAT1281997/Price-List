package part1;

public class price {
    private int rub;
    private int copek;

    public price(int rub, int copek) {
        this.rub = rub;
        this.copek = copek;
    }

    public double priceProduct() {
        return rub + (double)copek / 100;
    }

    public int getRub() {
        return rub;
    }

    public int getCopek() {
        return copek;
    }

    public void setCopek(int copek) {
        this.copek = copek;
    }

    public void setRub(int rub) {
        this.rub = rub;
    }

}
