package ru.shara.application.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import ru.shara.application.dao.RoleDao;
import ru.shara.application.model.Role;

import java.sql.SQLException;

public interface RoleService {


     Role getUserRole(String role) throws SQLException;

     Role getRoleById(Long id) throws SQLException;
}
