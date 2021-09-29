/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Request;
import entity.User;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public interface RequestDAO {
    public ArrayList<Request> getListByMe(User user);
    public int createRequest(Request req);
}
