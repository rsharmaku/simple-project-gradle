package co.bhavna.repository;

import co.bhavna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This Component is used to interact with data-source to persist user related data and modify too.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * Returns the User object if found with the email and password else returns null
     * @param email
     * @param password
     * @return
     */
    User findByEmailAndPassword(String email,String password);

    /**
     * Deletes User by specified userId
     * @param userId
     */
    void removeByUserId(Integer userId);

    /**
     * Returs the user object if found with the specified email
     * @param email
     * @return
     */
    User findByEmail(String email);

}
