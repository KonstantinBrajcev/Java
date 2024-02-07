package homework;

import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException {// Точка ВХОДА в ПРОГРАММУ
        User user = new User("Bob");// Создаем нового ЮЗЕРА
        user.report();// Выводим ЮЗЕРА
        user.save();// Сохраняем ЮЗЕРА (пустышка)
        user.delete();// Удаляем ЮЗЕРА (пустышка)
    }
}