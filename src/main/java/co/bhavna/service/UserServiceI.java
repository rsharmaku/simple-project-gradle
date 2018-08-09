package co.bhavna.service;

import co.bhavna.model.User;

/**
 * This is service description of the user related operation
 */
public interface UserServiceI {
     User save(User user);
     User get(String email, String password);
     User update(User user);
     void delete(Integer userId);

}
