package ru.shara.application.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.shara.application.dao.UserDao;
import ru.shara.application.model.User;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService  {

    private UserDao userHibernateDAO;

    @Autowired
    public UserServiceImpl(UserDao userHibernateDAO) {
        this.userHibernateDAO = userHibernateDAO;

    }

    public void addUser(User user) throws SQLException {
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        userHibernateDAO.addUser(user);
    }

    public List<User> getAllUsers() throws SQLException {
        return userHibernateDAO.getAllUser();
    }

    public void deleteUser(Long id) {
        userHibernateDAO.deleteUser(id);
    }

    public void updateUser(User user) {
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        userHibernateDAO.updateUser(user);
    }

    public User getUserByName(String name) throws SQLException {
        return userHibernateDAO.getUserByName(name);
    }

    public User getUserById(Long id) throws SQLException {
        return userHibernateDAO.getUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userHibernateDAO.getUserByName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
