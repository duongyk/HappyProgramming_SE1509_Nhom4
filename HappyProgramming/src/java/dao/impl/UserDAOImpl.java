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
import dao.RatingDAO;
import dao.RequestSkillDAO;
import dao.UserDAO;
import dao.UserSkillDAO;
import entity.Skill;
import entity.User;
import entity.UserSkill;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements from class interface UserDAOImpl. <br>
 * This class contains method to query select data from the table Rating.<br>
 * There are
 *
 * @author
 */
public class UserDAOImpl extends DBContext implements dao.UserDAO {

    /**
     * Delete an User
     *
     * @param uId id of user
     * @return number of user deleted
     * @throws Exception
     */
    @Override
    public int deleteUser(int uId) throws Exception {
        int deleted = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "delete from [User] where uId=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, uId);

            deleted = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        
        return deleted;
    }
    
    /**
     * Get all the User
     *
     * @return list of <code>User</code> object
     * @throws Exception
     */
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

    /**
     * Get a user by his/ger ID
     *
     * @param uId it is a <code>java.lang.Integer</code>
     * @return a <code>User</code> object
     * @throws Exception
     */
    @Override
    public User getUserById(int uId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [User] WHERE [uId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uId);
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

    /**
     * Get User by username and password
     *
     * @param xName it is a <code>java.lang.String</code>
     * @param xPass it is a <code>java.lang.String</code>
     * @return a User it is a <code>User</code> object
     * @throws Exception
     */
    @Override
    public User getUser(String xName, String xPass) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select*from [User] where username COLLATE Latin1_General_CS_AS = ?  and password  COLLATE Latin1_General_CS_AS = ? ";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xName);
            ps.setString(2, xPass);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"), rs.getString("uAvatar"), rs.getInt("uRole"));
                user.setStatus(rs.getInt("uStatus"));
                return user;
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

    /**
     * Check if the account existed or not
     *
     * @param xName is a <code>java.lang.String</code>
     * @return a <code>User</code> object
     * @throws Exception
     */
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
    /**
     * Create and insert new User account into the database
     *
     * @param user it is a <code>User</code> object
     * @throws Exception
     */
    @Override
    public void signUp(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " insert into [User]  values (?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(10, user.getStatus());

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
     * change password
     *
     * @param uMail, newPass
     * @return null
     * @throws Exception
     */
    @Override
    public User changePass(String uMail, String newPass) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [user] SET password=? WHERE uMail =?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPass);
            ps.setString(2, uMail);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * Update user information
     *
     * @param uId it is a <code>java.lang.Integer</code>
     * @param user it is a <code>User</code> object
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
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
                + " set fullname=?"
                + " ,uMail=?"
                + " ,uPhone=?"
                + " ,DOB=?"
                + " ,gender=?"
                + " ,uAvatar=?"
                + " where uId=?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getMail());
            ps.setString(3, user.getPhone());
            ps.setString(4, stringDOB);
            ps.setString(5, user.getGender());
            ps.setString(6, user.getAvatar());
            ps.setInt(7, uid);

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

    /**
     * Get list of User with the same role
     *
     * @param uRole it is a <code>java.lang.Integer</code>
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<User> getUserByRole(int uRole) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from [User] where [uRole] = ?";
        int id;
        String username;
        String password;
        String fullname;
        String mail;
        String phone;
        String gender;
        String avatar;
        int role;
        int status;
        Date dob;
        User u;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uRole);
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
                status = rs.getInt("uStatus");
                role = rs.getInt("uRole");
                u = new User(id, username, password, fullname, mail, phone, dob, gender, avatar, role, status);
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

    /**
     * Get list of Mentee with the username like txtSearch
     *
     * @param txtSearch
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    public ArrayList<User> searchMentee(String txtSearch) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT * FROM [PRJ_SWP].[dbo].[User] where uRole = '1' and fullname like ?";
        int id;
        String username, password, fullname, mail, phone, gender, avatar;
        Date dob;
        User u;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
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

    /**
     * Update user information
     *
     * @param email it is a <code>java.lang.String</code>
     * @return a <code>User</code> object
     * @throws Exception
     */
    @Override
    public User getUserByEmail(String email) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select * from [User] where uMail = ?";
        String username;
        String password;
        String fullname;
        String mail;
        String phone;
        String gender;
        String avatar;
        String verify;
        Date dob;
        User user = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                username = rs.getString("username");
                password = rs.getString("password");
                fullname = rs.getString("fullname");
                mail = rs.getString("uMail");
                phone = rs.getString("uPhone");
                dob = rs.getDate("DOB");
                gender = rs.getString("gender");
                avatar = rs.getString("uAvatar");
                user = new User(username, password, fullname, mail, phone, dob, gender, avatar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return user;
    }

    /**
     * Get user and reset that user password in database
     *
     * @param user it is a <code>User</code> object
     * @param password it is a String
     * @return a <code>User</code> object
     * @throws Exception
     */
    @Override
    public User resetPassword(User user, String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "update [User] set [password] = ? where uMail = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, user.getMail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * Update user information into database
     *
     * @param user it is a <code>User</code> object
     * @throws Exception
     */
    @Override
    public void updateUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "update [User] set [fullname] = ?"
                + ",[uMail] = ?"
                + ", [uPhone] = ?"
                + ", [DOB] = ?"
                + ", [gender] = ?"
                + ", [uAvatar] = ?"
                + " where [uId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getMail());
            ps.setString(3, user.getPhone());
            ps.setDate(4, user.getDob());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getAvatar());
            ps.setInt(7, user.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Get all the Mentee listed by Name
     *
     * @return list of <code>User</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<User> getMenteeListSorted() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> t = new ArrayList<>();
        String sql = "select * from [User] where [uRole] = 1 order by [fullname]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            User x;
            while (rs.next()) {
                x = new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"), rs.getString("uAvatar"), rs.getInt("uRole"), rs.getInt("uStatus"));
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

    /**
     * Get list of User with the same role by page
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param uRole it is a <code>java.lang.Integer</code>
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<User> getUserByRolePaging(int index, int uRole) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [uId]) "
                + "AS RowNum, * FROM [User] WHERE [uRole] = ?) a WHERE "
                + "RowNum between ? and ?";
        User user;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uRole);
            ps.setInt(2, index * 8 - 7);
            ps.setInt(3, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("uId"), rs.getString("username"),
                        rs.getString("password"), rs.getString("fullname"),
                        rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"),
                        rs.getString("uAvatar"), rs.getInt("uRole"), rs.getInt("uStatus"));
                list.add(user);
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
     * Get list of User with the same role by page and sorted by fullname
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param uRole it is a <code>java.lang.Integer</code>
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<User> getSortedUserByRolePaging(int index, int uRole) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [fullname] ASC) "
                + "AS RowNum, * FROM [User] WHERE [uRole] = ?) a WHERE "
                + "RowNum between ? and ? ";
        User user;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uRole);
            ps.setInt(2, index * 8 - 7);
            ps.setInt(3, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("uId"), rs.getString("username"),
                        rs.getString("password"), rs.getString("fullname"),
                        rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"),
                        rs.getString("uAvatar"), rs.getInt("uRole"), rs.getInt("uStatus"));
                list.add(user);
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
     * Get list of User with the same role by page after Filter by name
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param uRole it is a <code>java.lang.Integer</code>
     * @param name it is a <code>java.lang.String</code>
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<User> getUserByRoleFilterPaging(int index, int uRole, String name) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [uId])"
                + "AS RowNum, * FROM [User] WHERE [uRole] = ? AND [fullname] "
                + "like ?) a WHERE RowNum between ? and ?";
        User user;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uRole);
            ps.setString(2, "%" + name + "%");
            ps.setInt(3, index * 8 - 7);
            ps.setInt(4, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("uId"), rs.getString("username"),
                        rs.getString("password"), rs.getString("fullname"),
                        rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"),
                        rs.getString("uAvatar"), rs.getInt("uRole"));
                list.add(user);
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
     * Get total number of User with the same role Filter by name
     *
     * @param uRole it is a <code>java.lang.Integer</code>
     * @param name it is a <code>java.lang.String</code>
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public int getTotalFilterName(int uRole, String name) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int total = 0;
        String sql = "SELECT COUNT([uId]) as 'total' FROM [User] "
                + "WHERE [uRole] = ? AND [fullname] like ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uRole);
            ps.setString(2, "%" + name + "%");
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

    /**
     * Get top Mentor by their Rating
     *
     * @return list of <code>User</code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<User> getTopMentorByRate() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        RatingDAO ratingDAO = new RatingDAOImpl();
        ArrayList<User> list = new ArrayList<>();
        ArrayList<User> mentorList = userDAO.getUserByRole(2);
        // HashMap contain rating of Mentor ((K,V)-(Mentor ID, avarage rating))
        HashMap<Integer, Double> avg = new HashMap<>();
        for (User mentor : mentorList) {
            if (ratingDAO.getAvgRate(mentor.getId()) != 0) {
                avg.put(mentor.getId(), ratingDAO.getAvgRate(mentor.getId()));
            }
        }
        // Create a list from elements of HashMap
        List<HashMap.Entry<Integer, Double>> listEntry
                = new LinkedList<>(avg.entrySet());
        // Sort the list
        Collections.sort(listEntry, (HashMap.Entry<Integer, Double> o1,
                HashMap.Entry<Integer, Double> o2)
                -> (o2.getValue()).compareTo(o1.getValue()));
        // Get list Mentor
        for (HashMap.Entry<Integer, Double> entry : listEntry) {
            list.add(userDAO.getUserById(entry.getKey()));
        }
        return list;
    }

    /**
     * Get list Mentor sorted by total number of Skill
     *
     * @return list of <code>Skill</code> object of the mentor
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<User> getTopMentorByTotalSkill() throws Exception {
        UserSkillDAO usDAO = new UserSkillDAOImpl();
        ArrayList<User> list = new ArrayList<>();
        ArrayList<UserSkill> usList = usDAO.getMentorSkill();
        // HashMap cout skill of Mentor ((K,V)-(Mentor ID, number of Skill))
        HashMap<Integer, Integer> countSkill = new HashMap<>();
        for (UserSkill us : usList) {
            if (!countSkill.containsKey(us.getuId())) {
                countSkill.put(us.getuId(), 1);
            } else {
                countSkill.put(us.getuId(), countSkill.get(us.getuId()) + 1);
            }
        }
        // Create a list from elements of HashMap
        List<HashMap.Entry<Integer, Integer>> listEntry
                = new LinkedList<>(countSkill.entrySet());
        // Sort the list
        Collections.sort(listEntry, (HashMap.Entry<Integer, Integer> o1,
                HashMap.Entry<Integer, Integer> o2)
                -> (o2.getValue()).compareTo(o1.getValue()));
        // Get list Mentor
        for (HashMap.Entry<Integer, Integer> entry : listEntry) {
            list.add(getUserById(entry.getKey()));
        }
        return list;
    }

    /**
     * Get all Mentor that teach Skill which User have in Request
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return list of <code>User</code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<User> getSuggestedMentor(int mId) throws Exception {
        UserSkillDAO usDAO = new UserSkillDAOImpl();
        RequestSkillDAO rsDAO = new RequestSkillDAOImpl();
        ArrayList<User> list = new ArrayList<>();
        ArrayList<Integer> listId = new ArrayList<>();
        // get Skill of the Mentee have in all Requests
        ArrayList<Skill> skillList = rsDAO.getSkillByMentee(mId);
        // get all Mentor-Skill
        ArrayList<UserSkill> mentorSkillList = usDAO.getMentorSkill();
        // Add Skill ID to ID list
        for (UserSkill us : mentorSkillList) {
            for (Skill s : skillList) {
                if (!listId.contains(us.getuId())) {
                    if (us.getsId() == s.getId()) {
                        listId.add(us.getuId());
                    }
                }
            }
        }
        // Add Skill to Skill list
        for (int id : listId) {
            list.add(getUserById(id));
        }
        return list;
    }

    /**
     * Get total number of User
     *
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public int getMaxUser() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int total = 0;
        String sql = "SELECT COUNT([uId]) as 'total' FROM [User]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
                return total;
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

    /**
     * Update user's Status by user's id
     *
     * @param user it is a <code>User</code> object
     * @param status it is a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public void updateUserStatusById(User user, int status) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update [User] set [uStatus] = ? where [uId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, user.getId());
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
     * Get a user by his/her registered skill id
     *
     * @param sId it is a <code>java.lang.Integer</code>
     * @return a <code>User</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<User> getRecommendMentorBySkill(int sId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        User user;
        String sql = "select top(4) u.[uId]\n"
                + "			,u.[username]\n"
                + "			,u.[password]\n"
                + "			,u.[fullname]\n"
                + "			,u.[uMail]\n"
                + "			,u.[uPhone]\n"
                + "			,u.[DOB]\n"
                + "			,u.[gender]\n"
                + "			,u.[uAvatar]\n"
                + "			,u.[uRole]\n"
                + "			,u.[uStatus]\n"
                + "			,SUM(r.[ratingAmount]) as total\n"
                + "from [User] as u \n"
                + "inner join [Rating] as r on u.[uId] = r.[toId] \n"
                + "inner join [UserSkill] as us on u.[uId] = us.[uId]\n"
                + "where us.[sId] = ? and u.[uStatus] = 1 and u.[uRole] = 2\n"
                + "group by u.[uId]\n"
                + "			,u.[username]\n"
                + "			,u.[password]\n"
                + "			,u.[fullname]\n"
                + "			,u.[uMail]\n"
                + "			,u.[uPhone]\n"
                + "			,u.[DOB]\n"
                + "			,u.[gender]\n"
                + "			,u.[uAvatar]\n"
                + "			,u.[uRole]\n"
                + "			,u.[uStatus]\n"
                + "order by [total] DESC, u.[uId] ASC";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sId);
            int id;
            String username;
            String password;
            String fullname;
            String mail;
            String phone;
            Date dob;
            String gender;
            String avatar;
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
                user = new User(id, username, password, fullname, mail, phone, dob, gender, avatar);
                list.add(user);
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
     * Get list of Mentee with the username like txtSearch
     *
     * @param txtSearch
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<User> searchMentor(String txtSearch) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT * FROM [User] where uRole = '2' and fullname like ?";
        int id;
        String username;
        String password;
        String fullname;
        String mail;
        String phone;
        String gender;
        String avatar;
        int status;
        int role;
        Date dob;
        User u;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
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
                status = rs.getInt("uStatus");
                role = rs.getInt("uRole");
                u = new User(id, username, password, fullname, mail, phone, dob, gender, avatar, role, status);
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

    /**
     * Get a user by his/her registered skill id
     *
     * @param sId it is a <code>java.lang.Integer</code>
     * @return a <code>User</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<User> getMentorBySkill(int sId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        User user;
        String sql = "select * FROM [User] inner join [UserSkill] on [User].[uId] = [UserSkill].[uId] "
                + "where [UserSkill].[sId] = ? and [User].[uStatus] = 1 and [User].[uRole] = 2";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sId);
            int id;
            String username;
            String password;
            String fullname;
            String mail;
            String phone;
            Date dob;
            String gender;
            String avatar;
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
                user = new User(id, username, password, fullname, mail, phone, dob, gender, avatar);
                list.add(user);
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
     * Get list of User whose skill id in CV the same skill id by page
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param sId it is a <code>java.lang.Integer</code>
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<User> getUserBySkillIdPaging(int index, int sId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY u.[uId]) AS RowNum, u.* FROM [User] u\n"
                + "inner join [UserSkill] us on u.[uId] = us.[uId] \n"
                + "WHERE us.[sId] = ? and u.[uRole] = 2) a WHERE a.RowNum between ? and ?";
        User user;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sId);
            ps.setInt(2, index * 8 - 7);
            ps.setInt(3, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("uId"), rs.getString("username"),
                        rs.getString("password"), rs.getString("fullname"),
                        rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"),
                        rs.getString("uAvatar"), rs.getInt("uRole"), rs.getInt("uStatus"));
                list.add(user);
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

    public int getTotalFilterSkill(int uRole, int sId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
