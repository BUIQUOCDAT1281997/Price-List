package part1;

public class products {
    private String name;
    private int code;

    public products(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name= name;
    }

    public void setCode(int code){
        this.code=code;
    }

}