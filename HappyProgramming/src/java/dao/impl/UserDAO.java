/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.MyDAO;
import entity.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Duong
 */
public class UserDAO extends MyDAO implements dao.UserDAO {

    @Override
    public ArrayList<User> getUserList() {
        ArrayList<User> t = new ArrayList<>();
        xSql = "select * from [User]";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            User x;
            while (rs.next()) {
                x = new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"), rs.getString("uAvatar"), rs.getInt("uRole"));
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    
    @Override
    public User getUserById(int uId) {
        xSql = "SELECT * FROM [User] WHERE [uId] = " + uId;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"), rs.getString("uAvatar"), rs.getInt("uRole"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(String xName, String xPass) {

        xSql = "select * from [User] where username=? and password=?";

        try {
            ps = con.prepareStatement(xSql);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    @Override
    public User checkAccount(String xName) { // check xem tài khoản này đã tồn tại trong db chưa

        xSql = "select * from [User] where username=? ";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xName);// neu user co roi thi se tra ve 1 object con chua co thi tra ve null        
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("uMail"), rs.getString("uPhone"),
                        rs.getDate("dob"), rs.getString("gender"), rs.getString("uAvatar"), rs.getInt("uRole"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void signUp(User user){
        xSql=" insert into [User]  values (?,?,?,?,?,?,?,?,?)" ;
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
         try {
            ps = con.prepareStatement(xSql);
            ps.setString(1,user.getUsername()); 
            ps.setString(2,user.getPassword()); 
            ps.setString(3,user.getFullname());
            ps.setString(4,user.getMail());
            ps.setString(5,user.getPhone());
            ps.setDate(6,user.getDob());
            ps.setString(7,user.getGender()); 
            ps.setString(8,user.getAvatar()); 
            ps.setInt(9, user.getRole());
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    //viet thang
    @Override
    public int updateUserInfo(int uid, User user) {
        int status = 0;
        
        SimpleDateFormat sdf = 
                  new SimpleDateFormat("yyyy-MM-dd");
        
        String stringDOB = sdf.format(user.getDob());
        
        xSql = "update [User]"
                +" set fullname='"+user.getFullname()+"'"
                    +" ,uMail='"+user.getMail()+"'"
                    +" ,uPhone='"+user.getPhone()+"'"
                    +" ,DOB='"+stringDOB+"'"
                    +" ,gender='"+user.getGender()+"'"
                +" where uId='"+uid+"'";
        
        //System.out.println(xSql);
        
       try {
            ps = con.prepareStatement(xSql);
            
            status = ps.executeUpdate();
                 
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    @Override
    public ArrayList<User> getUserByRole(int uRole) {
        ArrayList<User> list = new ArrayList<>();
        xSql = "select * from [User] where [uRole] = '"+ uRole +"'";
        int id;
        String username, password, fullname, mail, phone, gender, avatar;
        Date dob;
        User u;
        try {
            ps = con.prepareCall(xSql);
            rs = ps.executeQuery();
            while(rs.next()) {
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
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}