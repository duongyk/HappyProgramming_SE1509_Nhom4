/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0                         First Deploy<br>
 */
package dao.impl;

import context.DBContext;
import dao.UserDAO;
import entity.Skill;
import entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements from class interface UserSkillDAOImpl. <br>
 * This class contains method to query select data from the table UserSkill.<br>
 * There are
 *
 * @author
 */
public class UserSkillDAOImpl extends DBContext implements dao.UserSkillDAO {

    /**
     * Get all Skill of the Mentor in the database
     *
     * @param uid of the mentor
     * @return list of all skills of the mentor
     */
    @Override
    public ArrayList<Skill> getAll_Skill_Mentor(int uid) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Skill> skillList = new ArrayList<>();
        SkillDAOImpl skilldao = new SkillDAOImpl();

        Skill skill = new Skill();
        String sql = "select * from UserSkill where uId='" + uid + "'";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                skill = skilldao.getSkillById(rs.getInt("sId"));
                skillList.add(skill);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
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
    public ArrayList<String> getAll_Id_Skill_Mentor(int uId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> skill_Id_List = new ArrayList<>();
        String sql = "select * from UserSkill where uId='" + uId + "'";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                skill_Id_List.add(rs.getString("sId"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
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
    public int updateMentorSkill(int uId, String[] skill_ids) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int status = 0;
        String sql = "delete from UserSkill where uId='" + uId + "'";
        try {

            //delete all skill of mentor
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            status = ps.executeUpdate();
            // update with new skill
            String sql_insert = "insert into UserSkill (uId,sId,usStatus)"
                    + " values (?,?,'1')";
            
            for (String skill_id : skill_ids) {
                PreparedStatement ps2 = conn.prepareStatement(sql_insert);
                ps2.setInt(1,uId);
                ps2.setString(2, skill_id);
                status = ps2.executeUpdate();
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return status;
    }

    /**
     * Get all Skill of the User(Mentee/Mentor) in the database
     *
     * @param uId is a <code>java.lang.Integer</code>
     * @return list of all skills of the mentor
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<Skill> getAllSkillUser(int uId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Skill> sList = new ArrayList<>();
        SkillDAOImpl skillDAO = new SkillDAOImpl();
        String sql = "SELECT * FROM [UserSkill] where [uId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uId);
            rs = ps.executeQuery();

            while (rs.next()) {
                sList.add(skillDAO.getSkillById(rs.getInt("sId")));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return sList;
    }

    /**
     * Update new Skills of the User in the database
     *
     * @param uId it is <code>java.lang.Integer</code>
     * @param sIdList is a list of <code>java.lang.Integer</code>
     * @throws java.lang.Exception
     */
    @Override
    public void updateUserSkill(int uId, ArrayList<Integer> sIdList) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlDelete = "DELETE FROM [UserSkill] where [uId] = ?";
        String sqlInsert = "INSERT INTO [UserSkill] ([uId],[sId],[usStatus])"
                + " VALUES (?,?,1)";
        try {
            conn = getConnection();
            // Delete
            ps = conn.prepareStatement(sqlDelete);
            ps.executeUpdate();
            // Insert new
            ps = conn.prepareStatement(sqlInsert);
            ps.setInt(1, uId);
            for (int sId : sIdList) {
                ps.setInt(2, sId);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Get all User and Skill that User is Mentor in the database
     *
     * @return list of <code>UserSkill</code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<UserSkill> getMentorSkill() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<UserSkill> usList = new ArrayList<>();
        UserDAO userDAO = new UserDAOImpl();
        String sql = "SELECT * FROM [UserSkill]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Check if User role is Mentor (uRole==2) or not
                if (userDAO.getUserById(rs.getInt("uId")).getRole() == 2) {
                    usList.add(new UserSkill(rs.getInt("uId"), rs.getInt("sId"),
                            rs.getString("uId")));
                }
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return usList;
    }

    /**
     * Get total number of Skill that User have
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * @throws java.lang.Exception
     */
    @Override
    public int getTotalSkill(int mId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int total = 0;
        String sql = "SELECT COUNT([sId]) as 'totalSkill' FROM [UserSkill] "
                + "WHERE [uId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("totalSkill");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return total;
    }
}
