package notebook.model.repository;

import notebook.model.User;

import java.util.List;
import java.util.Optional;
// создаем интерфейс для работы с БД
public interface GBRepository {

    // Вывод всех USERов --> с выводом List
    List<User> findAll();

    // Создание нововго USERа --> с возвратом USERа
    User create(User user);

    // Поиск USERа по ID --> с возвратом USERа
    Optional<User> findById(Long id);

    // Изменение USERа по ID --> с возвратом USERа
    Optional<User> update(Long userId, User update);

    // Удаление USERа по ID --> с возвратом True/False
    boolean delete(Long id);
}
