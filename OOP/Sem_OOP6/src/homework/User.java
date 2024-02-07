package homework;

public class User{// Публичный класс ЮЗЕР

    private final String name;// Используем внутреннюю переменную

    public User(String name){// Конструктор для инициализации ИМЕНИ
        this.name = name;
    }

    public String getName(){// ГЕТЕР - Получаем ИМЯ ЮЗЕРА
        return name;
    }

    public void save(){// СОЗДАЕМ и СОХРАНЯЕМ нового ЮЗЕРА
        Persist persist = new Persist(this);// Создаем
        persist.save();// Сохраняем
    }

    public void report(){// ПЕЧАТАЕМ имя ЮЗЕРа
        System.out.println("Report for user: " + name);
    }

    public void delete(){//Удаляем ЮЗЕРа
        return;
    }
}
