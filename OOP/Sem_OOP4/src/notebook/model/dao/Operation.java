package notebook.model.dao;

import java.util.List;

/**
 * Data Access Object (DAO) слой, с методами для работы с БД
 */
// Создаем интерфейс для выполнения операций ЧТЕНИЯ и ЗАПИСИ
public interface Operation {

    // Возвращаем список строк со ВСЕМИ USERами
    List<String> readAll();

    // Сохраняем список строк со ВСЕМИ USERами
    void saveAll(List<String> data);
}
