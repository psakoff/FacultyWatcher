package by.training.nc.sd3.backend.Entities;


import javax.persistence.Entity;
import java.util.Objects;
public class Admin {


    private String id;
    private String password;

    public Admin(String id, String password){
        this.id = id;
        this.password = password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin that = (Admin) o;
        return Objects.equals(password, that.password) && Objects.equals(id, that.id)
                ;

    }

    @Override
    public int hashCode() {

        return Objects.hash(password, id);
    }

    @Override
    public String toString() {
        return "lesson{" +
                "   id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}


