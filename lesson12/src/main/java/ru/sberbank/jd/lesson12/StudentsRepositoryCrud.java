package ru.sberbank.jd.lesson12;

import java.util.List;
import java.util.UUID;
import ru.sberbank.jd.lesson12.model.Student;

/**
 * Позволяет выполнять CRUD операции с моделью Student.
 */
public interface StudentsRepositoryCrud {

    /**
     * Создание записи в БД.
     * id у student должен быть null, иначе требуется вызов update.
     * id генерируем через UUID.randomUUID()
     *
     * @param student - заполненный объект
     * @return сгенерированный UUID
     */
    UUID create(Student student);

    /**
     * Получение записи по id из БД.
     *
     * @param id идентификатор записи
     * @return запись
     */
    Student selectById(UUID id);

    /**
     * Получение всех записей из БД.
     *
     * @return записи
     */
    List<Student> selectAll();

    /**
     * Обновление записи в БД.
     *
     * @param student измененная запись
     * @return количество обновленных записей
     */
    int  update(Student student);

    /**
     * Удаление указанных записей по id.
     *
     * @param idList список идентификаторов записей
     * @return количество удаленных записей
     */
    int remove(List<UUID> idList);
}
