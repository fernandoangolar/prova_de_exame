package domain.fila;

public class Tire {

    private static int cont = 1;
    private int id;
    private double width;
    private double weight;
    private String toCheck;
    private String mark;

    public Tire() {
    }

    public Tire(String toCheck ) {
        this.toCheck = toCheck;
    }

    public Tire(double width, double weight, String toCheck, String mark) {
        this.id = cont;
        this.width = width;
        this.weight = weight;
        this.toCheck = toCheck;
        this.mark = mark;
        Tire.cont++;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public double getWidth() {
        return width;
    }


    public void setWidth(double width) {
        this.width = width;
    }


    public double getWeight() {
        return weight;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }


    public String getMark() {
        return mark;
    }


    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getToCheck() {
        return toCheck;
    }

    public void setToCheck(String toCheck) {
        this.toCheck = toCheck;
    }

    @Override
    public String toString() {
        return "Tire [id >>> " + id + ", width >>> " + width + ", weight >>> " + weight + ", toCheck >>> " + toCheck + ", mark >>> " + mark
                + "]";
    }

    /**
     * @return
     */
    public String toChecks() {
        return "Tire [toCheck >>> " + toCheck +
                " ]";
    }
}
