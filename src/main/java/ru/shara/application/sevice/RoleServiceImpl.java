package ru.shara.application.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shara.application.dao.RoleDao;
import ru.shara.application.model.Role;

import java.sql.SQLException;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;

    public RoleServiceImpl() {

    }

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao= roleDao;
    }

    @Transactional
    public Role getUserRole(String role) throws SQLException {
        return roleDao.getUserRole(role);
    }

    @Transactional
    public Role getRoleById(Long id) throws SQLException {
        return roleDao.getRoleById(id);
    }
}
