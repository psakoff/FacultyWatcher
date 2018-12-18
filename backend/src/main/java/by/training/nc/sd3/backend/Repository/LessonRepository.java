package by.training.nc.sd3.backend.Repository;

import by.training.nc.sd3.backend.Entities.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
    Iterable<Lesson> getAllBySpeciality (@Param("speciality")String speciality);
    Iterable<Lesson> getAllByGroupId (@Param("groupId")int groupId);
}
