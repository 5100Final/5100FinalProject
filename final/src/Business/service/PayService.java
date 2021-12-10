/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.service;

import Business.dao.PayDao;
import Business.model.order.PayMethod;
import Business.model.user.CountVO;
import java.util.List;

/**
 *
 * @author Animal
 */
public class PayService {
    PayDao payDao = new PayDao();

    public List<PayMethod> getListByUser(String username) {
        return  payDao.getListByUser(username);
    }

    public List<PayMethod> getNumberByMethod(String method,String username) {
        return  payDao.getNumberByMethod(method,username);
    }
    public List<CountVO> getPie(String username) {
        return  payDao.getPie(username);
    }
    
}
