package by.training.nc.sd3.backend.Repository;


import by.training.nc.sd3.backend.Entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Iterable<Student> getAllByGroupId (@Param("groupId")int groupId);
}