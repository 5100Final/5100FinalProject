/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.service;

import Business.dao.UserDao;
import Business.model.user.User;
import java.util.List;

/**
 *
 * @author Animal
 */
public class UserService {
    
    UserDao userDao = new UserDao();
    
    public boolean addUser(User user){
            if(!userDao.CheckName(user.getUsername())) return false;
           
            userDao.addUser(user);
            
            return true;
    }
    
    
    public User checkUser(String name,String pwd){ 
          return  userDao.checkNameAndPwd(name, pwd);
    }
     
    public User findUserByName(String name){      
          return  userDao.findUserByName(name);
    }
      
    public int modifyUser(User user){
       return  userDao.modifyUser(user);
    }
   public int modifyUserByName(User user){
       return  userDao.modifyUserByName(user);
    }
    public List<User> getCustomerList() {
        return userDao.getListByType("Customer");
    }

    public int getIdByName(String cusName) {
        return userDao.getIdByName(cusName);
    }

    public User getUserById(Integer userId) {
       return userDao.getUserById(userId);
    }

    public List<User> getList() {
         return userDao.getList();
    }

    public List<User> getListByType(String type) {
       return userDao.getListByType(type);
    }

    public int deletedByName(String name) {
        return userDao.deletedByName(name);
    }

    public String getTypeByName(String name) {
        return userDao.getTypeByName(name);
    }
}
