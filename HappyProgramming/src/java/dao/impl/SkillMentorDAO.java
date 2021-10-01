/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 */
package dao.impl;

import context.MyDAO;
import entity.Skill;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public class SkillMentorDAO extends MyDAO implements dao.SkillMentorDAO{

    /**
    * Get all Skill of the Mentor in the database
    * 
    * @param uid of the mentor
    * @return list of all skills of the mentor
    */
    @Override
    public ArrayList<Skill> getAll_Skill_Mentor(int uid) {
        ArrayList<Skill> skillList = new ArrayList<>();
        SkillDAO skilldao = new SkillDAO();
        
        Skill skill = new Skill();
        
        try {
          
            xSql = "select * from SkillMentor where uId='"+uid+"'";
            
            ps = con.prepareStatement(xSql);
            
            rs = ps.executeQuery();              
            
            while(rs.next()) {
                skill = skilldao.getSkillById(rs.getString("sId"));
                
                skillList.add(skill);
                
                skill = new Skill();
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return skillList;
    }
    
    /**
    * Get all ID of Skill of the Mentor in the database
    * 
    * @param uId of the mentor
    * @return list of all id of all skills of the mentor
    */
    @Override
    public ArrayList<String> getAll_Id_Skill_Mentor(int uId) {
        ArrayList<String> skill_Id_List = new ArrayList<>();
    
        try {
          
            xSql = "select * from SkillMentor where uId='"+uId+"'";
            
            ps = con.prepareStatement(xSql);
            
            rs = ps.executeQuery();              
            
            while(rs.next()) {

                skill_Id_List.add(rs.getString("sId"));
     
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return skill_Id_List;
    }
    
    /**
    * Update new Skills for the Mentor in the database
    * 
    * @param uId of the mentor
    * @param skill_ids list of id of new skills
    * @return 1 if update success, 0 if fail
    */
    @Override
    public int updateMentorSkill(int uId, String[] skill_ids) {
        
        int status = 0;
        
        try {
            
            //delete all skill of mentor
            xSql = "delete from SkillMentor where uId='"+uId+"'";
            
            ps = con.prepareStatement(xSql);
            
            status = ps.executeUpdate();
              
            // update with new skill
            String sql_insert = "insert into SkillMentor (uId,sId)"
                    + " values ("+uId+",?)";
            
            for(String skill_id : skill_ids) {
                PreparedStatement ps2 = con.prepareStatement(sql_insert);
                
                ps2.setString(1, skill_id);
                status = ps2.executeUpdate();
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    
    
}
