package by.taining.nc.sd3.Fapi.services;

import by.taining.nc.sd3.Fapi.models.AdminModel;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public interface DataAdminService {
    AdminModel getAdmin();
}