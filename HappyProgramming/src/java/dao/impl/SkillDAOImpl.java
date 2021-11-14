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
     * Get all Skill in the database
     *
     * @return a list <code>Skill</code> object
     * @throws java.lang.Exception
     */
    @Override

    public ArrayList<Skill> getAllSkill() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //get informations from database
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
                s = new Skill(id, name, detail, image);
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

    public ArrayList<Skill> getTrendingSkill() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //get informations from database
        ArrayList<Skill> list = new ArrayList<>();
        String sql = "SELECT Top 5 Skill.sId,Skill.sName,Skill.sImage,Skill.sStatus, COUNT(Skill.sId) AS \"Total\"\n"
                + "                 FROM [PRJ_SWP].[dbo].[RequestSkill] as Trend,Skill\n"
                + "                  Where Trend.sId = Skill.sId\n"
                + "                  GROUP BY Skill.sId, Skill.sName, Skill.sImage,Skill.sStatus\n"
                + "                  Order by total DESC";
        int id;
        String name;
        String detail = null;
        String image;
        int total;
        int status;
        Skill s;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("sId");
                name = rs.getString("sName");
                image = rs.getString("sImage");
                total = rs.getInt("Total");
                status = rs.getInt("sStatus");
                s = new Skill(id, name, detail, image, status, total);
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

    /**
     * Get all Skill of the user in the database
     *
     * @return a list <code>Skill</code> object
     */
    @Override
    public int getTotalSkill() {
        String sql = "select COUNT (*) from dbo.Skill";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //get informations from database
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    /**
     * Paging skill
     *
     * @param index is an int number
     * @return a list <code>Skill</code> object
     */
    @Override
    public ArrayList<Skill> pagingSkill(int index) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Skill> list = new ArrayList<>();
        String sql = "select * from \n"
                + "(select ROW_NUMBER() over (order by sId asc) as r, * from dbo.Skill) \n"
                + "as x\n"
                + "where r between ? and ?";
        //get informations from database
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, index * 8 - 7);
            ps.setInt(2, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Skill(rs.getInt("sId"), rs.getString("sName"), rs.getString("sDetail"), rs.getString("sImage"), rs.getInt("sStatus")));

            }
        } catch (Exception e) {
        }

        return list;

    }

    /**
     * Paging skill
     *
     * @param index is an int number
     * @return a list <code>Skill</code> object
     */
    @Override
    public ArrayList<Skill> pagingSkillSorted(int index) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Skill> list = new ArrayList<>();
        String sql = "select * from \n"
                + "             (select ROW_NUMBER() over (order by sName asc) as r, * from dbo.Skill)\n"
                + "               as x\n"
                + "              where r between ? and ?";
        //get informations from database
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, index * 8 - 7);
            ps.setInt(2, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Skill(rs.getInt("sId"), rs.getString("sName"), rs.getString("sDetail"), rs.getString("sImage"), rs.getInt("sStatus")));

            }
        } catch (Exception e) {
        }

        return list;

    }

    /**
     * Get all Active Skill of the user in the database
     *
     * @return a list <code>Skill</code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<Skill> getActiveSkill() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Skill> list = new ArrayList<>();
        String sql = "select * from [Skill] where [sStatus] = 1 order by [sName] asc";
        int id;
        int status;
        String name;
        String detail;
        String image;
        Skill s;
        try {
            //get informations from database
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

    /**
     * Get all Skill and sorted by name in the database
     *
     * @return a list <code>Skill</code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<Skill> getAllSkillSorted() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //get informations from database
        ArrayList<Skill> list = new ArrayList<>();
        String sql = "SELECT  * FROM [PRJ_SWP].[dbo].[Skill] Order By sName";
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
                s = new Skill(id, name, detail, image);
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

    /**
     * Find Skill in the database
     *
     * @param sName. It is a <code>java.lang.String</code>
     * @return a list <code>Skill</code> object
     * @throws java.lang.Exception
     */
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
            //get informations from database
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + sName + "%");
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

    /**
     * Find skill by Id in db
     *
     * @param sId .It is an int number
     * @return a list <code>Skill</code> object
     * @throws Exception
     */
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
                skill.setImage(rs.getString("sImage"));
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
     * @param x is a <code>Skill</code> object
     * @throws java.lang.Exception
     */
    @Override
    public void insert(Skill x) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into [Skill] values (?,?,?,1)";
        try {
            //get informations from database
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
     * check the skill has existed in db or not
     *
     * @param sName .It is a <code>java.lang.String</code>
     * @return boolean value
     * @throws Exception
     */
    @Override
    public boolean findDupSkill(String sName) throws Exception {
        ArrayList<Skill> sList = getAllSkill();
        for (Skill s : sList) {
            if (sName.equalsIgnoreCase(s.getName())) { //check name of new skill has existed in db or not
                return true;
            }
        }
        return false;
    }

    /**
     * Update a Skill
     *
     * @param skill it is an <code>Skill</code> object
     * @throws Exception
     */
    @Override
    public void updateSkill(Skill skill) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [Skill] SET [sName] = ? ,[sDetail] = ? ,"
                + "[sImage] = ? ,[sStatus] = ? WHERE [sId] = ?";
        try {
            //get informations from database
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

    /**
     * Find Skill in the database
     *
     * @param txtSearch. It is a <code>java.lang.String</code>
     * @return a list <code>Skill</code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<Skill> searchSkill(String txtSearch) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //get informations from database
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
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("sId");
                name = rs.getString("sName");
                detail = rs.getString("sDetail");
                image = rs.getString("sImage");
                s = new Skill(id, name, detail, image);
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

    /**
     * Update Skill Detail by Skill detail
     *
     * @param sId it is a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public Skill getSkillDetail(int sId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id;
        String name;
        String detail;
        String image;
        String link;
        int status;
        Skill skill = null;

        String sql = "select * from [Skill] where sId = ?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sId);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("sId");
                name = rs.getString("sName");
                detail = rs.getString("sDetail");
                image = rs.getString("sImage");
                link = rs.getString("sLink");
                status = rs.getInt("sStatus");
                skill = new Skill(id, name, detail, image, link, status);
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

    @Override
    public ArrayList<Skill> pagingActiveSkill(int index) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Skill> list = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [sId]) \n"
                + "AS RowNum, * FROM [Skill] WHERE [sStatus] = 1) a WHERE \n"
                + "RowNum between ? and ? order by [sName] asc";
        //get informations from database
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, index * 8 - 7);
            ps.setInt(2, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Skill(rs.getInt("sId"), rs.getString("sName"), rs.getString("sDetail"), rs.getString("sImage"), rs.getInt("sStatus")));
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
    public ArrayList<Skill> getSkillByNameFilterPaging(int index, String name) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Skill> list = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [sId]) \n"
                + "AS RowNum, * FROM [Skill] WHERE [sName] like ? and [sStatus] = 1) a WHERE \n"
                + "RowNum between ? and ? order by [sName] asc";
        //get informations from database
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+name+"%");
            ps.setInt(2, index * 8 - 7);
            ps.setInt(3, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Skill(rs.getInt("sId"), rs.getString("sName"), rs.getString("sDetail"), rs.getString("sImage"), rs.getInt("sStatus")));
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
    public int getTotalSkillFilterName(String name) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int total = 0;
        String sql = "SELECT COUNT([sId]) as 'total' FROM [Skill] "
                + "WHERE [sName] like ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+name+"%");
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
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
