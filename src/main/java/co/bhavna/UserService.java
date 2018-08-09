package co.bhavna;

import co.bhavna.model.User;
import co.bhavna.repository.UserRepository;
import co.bhavna.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.transaction.Transactional;
import java.util.List;

/**
 *
 */
@Service
public class UserService implements UserServiceI {
    @Autowired
    private UserRepository userRepository;

    @Override
   public  User save(User user){
        return userRepository.save(user);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public User get(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    public User update(User user) {
        System.out.println(user);
        User u = null;
        //first check that this user is existing in database or not
        String email = user.getEmail();
        if (!StringUtils.isEmpty(email)) {
            User existingUser = userRepository.findByEmail(email);
            if (existingUser != null) {
                //now make update to this model this will be updated as with in transaction
                existingUser.setMobile(user.getMobile());
                existingUser.setUserName(user.getUserName());
                u=existingUser;
            }
        }
        return u;
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public void delete(Integer userId) {
        userRepository.removeByUserId(userId);
    }

    public List<User> getAllUser(){
       return userRepository.findAll();
    }
}
