/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Skill;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public interface SkillDAO {
    public ArrayList<Skill> getAllSkill();
    public ArrayList<Skill> getSkillByName(String sName);
    
    public Skill getSkillById(String sId);
}
