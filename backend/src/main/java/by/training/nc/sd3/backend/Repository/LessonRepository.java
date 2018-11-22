package by.training.nc.sd3.backend.Repository;

import by.training.nc.sd3.backend.Entities.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
