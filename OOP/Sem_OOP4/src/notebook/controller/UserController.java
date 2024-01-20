package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;
// Создаем контроллер для управления USERами
public class UserController {
    // Используем приватное поле GBRepository
    private final GBRepository repository;
    // Принимаем в качестве аргумента GBRepository
    public UserController(GBRepository repository) {
        this.repository = repository;
    }
    // Метод для создания и сохранения USERа
    public void saveUser(User user) {
        repository.create(user);
    }
    // Метод для чтения USERа по ID
    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("USER не найден");
    }
    // Метод для изменения USERа по ID
    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }
    // Метод для удаления USERа по ID
    public void delete(String userId) {
        repository.delete(Long.parseLong(userId));
    }
    // Метод для просмотра ВСЕХ USERов
    public List<User> readAll(){
        return repository.findAll();
    }
}
