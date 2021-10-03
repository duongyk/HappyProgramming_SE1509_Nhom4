/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        DuongVV          First Deploy<br>
 */
package dao.impl;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class implements from class interface RequestSkillDAOImpl. <br>
 * This class contains method to query select data from the table
 * RequestSkill.<br>
 * There are
 *
 * @author
 */
public class RequestSkillDAOImpl extends DBContext implements dao.RequestSkillDAO {

    @Override
    public int getRequestMaxId() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int n = 0;
        String sql = "select MAX(rId) as id from [Request]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            n = rs.getInt(1);

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return n;
    }

    @Override
    public int skillRequest(int sId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int n = 0;
        RequestSkillDAOImpl dao = new RequestSkillDAOImpl();
        int maxId = dao.getRequestMaxId();
        String sql = "INSERT INTO [RequestSkill](rId,[sId]) VALUES (" + maxId + " ," + sId + ")";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            n = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return n;
    }

}
