package Pharmacy;

public class Component implements Comparable<Component> {
    private String name;
    private String weigth;
    private  int power;

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", weigth='" + weigth + '\'' +
                ", power=" + power +
                '}';
    }

    public Component(String name, String weigth, int power) {
        this.name = name;
        this.weigth = weigth;
        this.power = power;
    }

    public  String getName() {
        return name;
    }

    public String getWeigth() {
        return weigth;
    }

    public  int getPower() {
        return power;
    }

    @Override
    public int compareTo(Component o) {
        return Integer.compare( this.power,o.power);
    }
}