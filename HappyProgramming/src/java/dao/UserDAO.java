/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public interface UserDAO {
    public ArrayList<User> getUserList();
    public User getUser(String xName, String xPass);
    public ArrayList<User> getUserByRole(int uRole);
    public User getUserById(int uId);
    public User checkAccount(String xName);
    public void signUp(User user);
    public int updateUserInfo(int uid, User user);
}
