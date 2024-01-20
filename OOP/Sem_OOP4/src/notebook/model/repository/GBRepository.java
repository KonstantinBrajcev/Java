package notebook.model.repository;

import notebook.model.User;

import java.util.List;
import java.util.Optional;
// ������� ��������� ��� ������ � ��
public interface GBRepository {

    // ����� ���� USER�� --> � ������� List
    List<User> findAll();

    // �������� ������� USER� --> � ��������� USER�
    User create(User user);

    // ����� USER� �� ID --> � ��������� USER�
    Optional<User> findById(Long id);

    // ��������� USER� �� ID --> � ��������� USER�
    Optional<User> update(Long userId, User update);

    // �������� USER� �� ID --> � ��������� True/False
    boolean delete(Long id);
}
