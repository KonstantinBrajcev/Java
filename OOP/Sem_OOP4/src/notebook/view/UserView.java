package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

import java.util.Scanner;
// Создаем пользовательский интерфейс для класса USER
public class UserView {
    // Используем приватное поле USERCONTROLLER
    private final UserController userController;
    // Принимаем в качестве аргумента USERCONTROLLER
    public UserView(UserController userController) {
        this.userController = userController;
    }
    // Метод запуска вечного цикла
    public void run(){
        Commands com;
        // Вечный цикл запроса команд у пользователя
        while (true) {
            String command = prompt("Введите комманду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            // Выбираем что ввел пользователь
            switch (com) {
                // СОЗДАНИЕ записи
                case CREATE:
                    User u = createUser();
                    userController.saveUser(u);
                    break;
                // ЧТЕНИЕ запсии по ID
                case READ:
                    String id = prompt("Введите ID для чтения: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                // ИЗМЕНЕНИЕ записи по ID
                case UPDATE:
                    String userId = prompt("Введите ID для изменения: ");
                    userController.updateUser(userId, createUser());
                // УДАЛЕНИЕ записи по ID
                case DELETE:
                    String userIdToDelete = prompt("Введите ID для удаления: ");
                    try {
                        userController.delete(userIdToDelete);
                        System.out.println("ID удален успешно");
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                // ПРОСМОТР всех записей
                case LIST:
                    System.out.println(userController.readAll());

            }
        }
    }
    // Метод для запроса данных у пользователя
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    // Создаем новый объект USER
    private User createUser() {
        // Запрашиваем ввод ФИО и телефона
        String firstName = prompt("Фамилия: ");
        String lastName = prompt("Имя: ");
        String phone = prompt("Телефон: ");
        // Возвращаем ФИО и Телефон
        return new User(firstName, lastName, phone);
    }
}
