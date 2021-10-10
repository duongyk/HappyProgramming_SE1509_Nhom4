/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        GiangNVT          First Deploy<br>
 */
package dao.impl;

import context.DBContext;
import entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements from class interface SkillDAOImpl. <br>
 * This class contains method to query select data from the table Skill.<br>
 * There are Get all Skill in the database, , Get skill by name, Get skill by
 * ID, Insert new Skill into the database,Find duplicate skill
 *
 * @author giangnvthe150748
 */
public class SkillDAOImpl extends DBContext implements dao.SkillDAO {

    /**
     * Get all Skill of the user in the database
     *
     * @return a list <code>Skill</code> object
     */
    @Override

    public ArrayList<Skill> getAllSkill() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Skill> list = new ArrayList<>();
        String sql = "select * from [Skill]";
        int id;
        int status;
        String name;
        String detail;
        String image;
        Skill s;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("sId");
                name = rs.getString("sName");
                detail = rs.getString("sDetail");
                image = rs.getString("sImage");
                status = rs.getInt("sStatus");
                s = new Skill(id, name, detail, image, status);
                list.add(s);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return list;
    }
    
    public ArrayList<Skill> getActiveSkill() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Skill> list = new ArrayList<>();
        String sql = "select * from [Skill] where [sStatus] = 1";
        int id;
        int status;
        String name;
        String detail;
        String image;
        Skill s;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("sId");
                name = rs.getString("sName");
                detail = rs.getString("sDetail");
                image = rs.getString("sImage");
                status = rs.getInt("sStatus");
                s = new Skill(id, name, detail, image, status);
                list.add(s);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return list;
    }

    @Override
    public ArrayList<Skill> getSkillByName(String sName) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Skill> list = new ArrayList<>();
        String sql = "select * from [Skill] where sName like ?";
        int id;
        int status;
        String name;
        String detail;
        String image;
        Skill s;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+sName+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("sId");
                name = rs.getString("sName");
                detail = rs.getString("sDetail");
                image = rs.getString("sImage");
                status = rs.getInt("sStatus");
                s = new Skill(id, name, detail, image, status);
                list.add(s);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return list;
    }

    //viet thang
    @Override
    public Skill getSkillById(int sId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Skill skill = new Skill();

        String sql = "select * from [Skill] where sId=" + sId;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                skill.setId(rs.getInt("sId"));
                skill.setName(rs.getString("sName"));
                skill.setDetail(rs.getString("sDetail"));
                skill.setStatus(rs.getInt("sStatus"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return skill;
    }

    /**
     * Insert new Rating into the database
     *
     */
    @Override
    public void insert(Skill x) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into [Skill] values (?,?,?,1)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, x.getName());
            ps.setString(2, x.getDetail());
            ps.setString(3, x.getImage());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

   
    /**
     * find duplicate skill in database
     * 
     * @return a boolean object
     */
    @Override
    public boolean findDupSkill(String sName) throws Exception {
        ArrayList<Skill> sList = getAllSkill();
        for (Skill s : sList) {
            if (sName.equalsIgnoreCase(s.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateSkill(Skill skill) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [Skill] SET [sName] = ? ,[sDetail] = ? ,"
                + "[sImage] = ? ,[sStatus] = ? WHERE [sId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, skill.getName());
            ps.setString(2, skill.getDetail());
            ps.setString(3, skill.getImage());
            ps.setInt(4, skill.getStatus());
            ps.setInt(5, skill.getId());
            
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

}
