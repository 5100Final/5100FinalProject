/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.service;

import Business.dao.UserDao;
import Business.model.user.User;

/**
 *
 * @author Animal
 */
public class UserService {
    
    UserDao userDao = new UserDao();
    
    public void addUser(User user){
            userDao.addUser(user);
    }
    
    
    public boolean checkUser(String name,String pwd){ 
          return  userDao.checkNameAndPwd(name, pwd);
    }
     
    public User findUserByName(String name){      
          return  userDao.findUserByName(name);
    }
      
    public int modifyUser(User user){
       return  userDao.modifyUser(user);
    }
}
