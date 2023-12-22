public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Eagle();
        Animal animal2 = new Fish();
        Animal animal3 = new Cat();

        System.out.println("Действия первого животного:");
        animal1.toGo();
        animal1.fly();
        animal1.swim();

        System.out.println("\nДействия второго животного:");
        animal2.toGo();
        animal2.fly();
        animal2.swim();

        System.out.println("\nДействия третьего животного:");
        animal3.toGo();
        animal3.fly();
        animal3.swim();
    }
}