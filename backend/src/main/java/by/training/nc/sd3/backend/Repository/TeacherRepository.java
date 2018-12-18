package by.training.nc.sd3.backend.Repository;


import by.training.nc.sd3.backend.Entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}