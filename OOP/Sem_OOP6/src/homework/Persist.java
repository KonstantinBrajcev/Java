package homework;

public class Persist {// КОНСТРУКТОР СОЗДАНИЯ и СОХРАНЕНИЯ ЮЗЕРА

    private final User user;// Используем ЮЗЕРОВ

    public Persist(User user){// Создаем Юзера
        this.user = user;
    }

    public void save(){// Сохраняем ЮЗЕРА
        System.out.println("Пользователь сохранен: " + user.getName());
    }
}
