package wcd.repository;

import wcd.entity.Classroom;

import java.util.List;

public interface ClassroomRepository {
    List<Classroom> findAll();
    void save(Classroom classroom);
    Classroom findById(int id);
    void delete(int id);
    void update(int id);

    List<Classroom> findByClassroomName(String classroomName);
}
