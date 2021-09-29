/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Rating;
import entity.User;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public interface RatingDAO {
    public ArrayList<Rating> getRating(User user);
    public void insert(Rating x);
}
