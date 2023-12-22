package PACKAGE_NAME;

// Второй класс-наследник, умеющий плавать
class Fish extends Animal {
    @Override
    public void toGo() {
        System.out.println("Эта рыба может ходить.");
    }

    @Override
    public void fly() {
        // Переопределяем метод, чтобы рыба не летала
        System.out.println("Эта рыба не может летать.");
    }
}