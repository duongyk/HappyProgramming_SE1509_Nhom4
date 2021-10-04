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
import entity.User;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class implements from class interface UserDAOImpl. <br>
 * This class contains method to query select data from the table Rating.<br>
 * There are
 *
 * @author
 */
public class UserDAOImpl extends DBContext implements dao.UserDAO {

    @Override
    public ArrayList<User> getUserList() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> t = new ArrayList<>();
        String sql = "select * from [User]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            User x;
            while (rs.next()) {
                x = new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"), rs.getString("uAvatar"), rs.getInt("uRole"));
                t.add(x);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return (t);
    }

    @Override
    public User getUserById(int uId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [User] WHERE [uId] = " + uId;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"), rs.getString("uAvatar"), rs.getInt("uRole"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    @Override
    public User getUser(String xName, String xPass) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from [User] where username=? and password=?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xName);
            ps.setString(2, xPass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"), rs.getString("uAvatar"), rs.getInt("uRole"));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    @Override
    public User checkAccount(String xName) throws Exception { // check xem tài khoản này đã tồn tại trong db chưa
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from [User] where username=? ";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xName);// neu user co roi thi se tra ve 1 object con chua co thi tra ve null        
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"), rs.getString("uAvatar"), rs.getInt("uRole"));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    @Override
    public void signUp(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " insert into [User]  values (?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getMail());
            ps.setString(5, user.getPhone());
            ps.setDate(6, user.getDob());
            ps.setString(7, user.getGender());
            ps.setString(8, user.getAvatar());
            ps.setInt(9, user.getRole());

            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }

    }

    //viet thang
    @Override
    public int updateUserInfo(int uid, User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int status = 0;

        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy-MM-dd");

        String stringDOB = sdf.format(user.getDob());

        String sql = "update [User]"
                + " set fullname='" + user.getFullname() + "'"
                + " ,uMail='" + user.getMail() + "'"
                + " ,uPhone='" + user.getPhone() + "'"
                + " ,DOB='" + stringDOB + "'"
                + " ,gender='" + user.getGender() + "'"
                + " ,uAvatar='" + user.getAvatar() + "'"
                + " where uId='" + uid + "'";

        //System.out.println(xSql);
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            status = ps.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }

        return status;
    }

    @Override
    public ArrayList<User> getUserByRole(int uRole) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from [User] where [uRole] = '" + uRole + "'";
        int id;
        String username, password, fullname, mail, phone, gender, avatar;
        Date dob;
        User u;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("uId");
                username = rs.getString("username");
                password = rs.getString("password");
                fullname = rs.getString("fullname");
                mail = rs.getString("uMail");
                phone = rs.getString("uPhone");
                dob = rs.getDate("DOB");
                gender = rs.getString("gender");
                avatar = rs.getString("uAvatar");
                u = new User(id, username, password, fullname, mail, phone, dob, gender, avatar);
                list.add(u);
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

}