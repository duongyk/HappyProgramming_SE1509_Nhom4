/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.CV;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public interface CVDAO {

    public CV getMentorCV(int uid);

    public void insertCV(int uid, CV newCV);
    
    public int updateCV(int uid, CV newCV);
    
    public ArrayList<CV> getAllMentorCV();
}
