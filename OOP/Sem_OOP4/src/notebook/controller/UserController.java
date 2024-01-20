package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;
// ������� ���������� ��� ���������� USER���
public class UserController {
    // ���������� ��������� ���� GBRepository
    private final GBRepository repository;
    // ��������� � �������� ��������� GBRepository
    public UserController(GBRepository repository) {
        this.repository = repository;
    }
    // ����� ��� �������� � ���������� USER�
    public void saveUser(User user) {
        repository.create(user);
    }
    // ����� ��� ������ USER� �� ID
    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("USER �� ������");
    }
    // ����� ��� ��������� USER� �� ID
    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }
    // ����� ��� �������� USER� �� ID
    public void delete(String userId) {
        repository.delete(Long.parseLong(userId));
    }
    // ����� ��� ��������� ���� USER��
    public List<User> readAll(){
        return repository.findAll();
    }
}
