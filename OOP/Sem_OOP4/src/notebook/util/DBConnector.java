package notebook.util;

import java.io.File;

public class DBConnector {
    // Создаем константу с именем фала БД
    public static final String DB_PATH = "db.txt";
    // Метод для создания БД
    public static void createDB() {
        try {
            // Создаем новый файл БД
            File db = new File(DB_PATH);
            // Если файл создан то
            if (db.createNewFile()) {
                // Выводим сообщение
                System.out.println("DB создана");
            }
            else {
                // Иначе объявляем что БД уже есть
                System.out.println("DB уже существует");
            }
        }
        // Если не получилось
        catch (Exception e) {
            // Выводим ошибку
            System.err.println(e);
        }
    }
}
