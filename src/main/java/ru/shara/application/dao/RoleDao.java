package ru.shara.application.dao;

import ru.shara.application.model.Role;

import java.sql.SQLException;

public interface RoleDao  {

    public Role getUserRole(String role) throws SQLException;

    public Role getRoleById(Long id) throws SQLException;
}
