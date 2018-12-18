package by.training.nc.sd3.backend.Repository;

import by.training.nc.sd3.backend.Entities.Attendancy;
import by.training.nc.sd3.backend.Entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendancyRepository extends CrudRepository<Attendancy, Integer> {
    Iterable<Attendancy> getAttendancyByStudent_id(@Param("student_id")int student_id);
}
