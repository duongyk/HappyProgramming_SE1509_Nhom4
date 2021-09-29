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
public interface SkillMentorDAO {
    public ArrayList<Skill> getAll_Skill_Mentor(int uId);
    public ArrayList<String> getAll_Id_Skill_Mentor(int uId);
    
    public int updateMentorSkill(int uid, String[] skills);
}
