/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    @Override
    public int updateMentorSkill(int uId, String[] skills) {
        
        int status = 0;
        
        try {
            
            //delete all skill of mentor
            xSql = "delete from SkillMentor where uId='"+uId+"'";
            
            ps = con.prepareStatement(xSql);
            
            status = ps.executeUpdate();
              
            // update with new skill
            String sql_insert = "insert into SkillMentor (uId,sId)"
                    + " values ("+uId+",?)";
            
            for(String skill_id : skills) {
                PreparedStatement ps2 = con.prepareStatement(sql_insert);
                
                ps2.setString(1, skill_id);
                status = ps2.executeUpdate();
                
  //              System.out.println(skill_id);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    
    
}
