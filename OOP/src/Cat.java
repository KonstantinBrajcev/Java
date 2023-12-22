package PACKAGE_NAME;

// Третий класс-наследник, умеющий бегать
public class Cat extends Animal {
    @Override
    public void fly() {
        // Переопределяем метод, чтобы кошка не летала
        System.out.println("Эта кошка не может летать.");
    }

    @Override
    public void swim() {
        // Переопределяем метод, чтобы кошка не плавала
        System.out.println("Эта кошка не может плавать.");
    }
}