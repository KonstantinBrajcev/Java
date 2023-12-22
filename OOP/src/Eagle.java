package PACKAGE_NAME;

// Первый класс-наследник, умеющий летать
public class Eagle extends Animal {
    @Override
    public void toGo() {
        System.out.println("Это птица может ходить.");
    }
}