package co.bhavna.controller;

import co.bhavna.UserService;
import co.bhavna.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {
                      
    @Autowired
    private UserService userService;

    /**
     * @param user
     * @return
     */
    @PostMapping(value = "/user/create",produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    public User createResource(@RequestBody User user ){
        return  userService.save(user);
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping(value = "user/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> modifyResource(@RequestBody User user){
        HttpHeaders headers = new HttpHeaders();
        User updatedUser = userService.update(user);
        ResponseEntity<User> responseEntity = new ResponseEntity<User>(updatedUser,headers, HttpStatus.valueOf(202));
     return  responseEntity;
    }

    /**
     * This will returns all users from the table which is registered
     * @return
     */
    @PostMapping(value = "/user/all",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> getAllUser(HttpServletResponse httpServletResponse){

        Cookie cookie = new Cookie("name1","value1");
        httpServletResponse.addCookie(cookie);

       return new ResponseEntity<>(userService.getAllUser(),null,HttpStatus.valueOf(200));
    }

}
