/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.MyDAO;
import entity.Skill;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public class RequestSkillDAO extends MyDAO implements dao.RequestSkillDAO{
    @Override
    public int getRequestMaxId() {
        int n = 0;
        xSql = "select MAX(rId) as id from [Request]";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            rs.next();
            n = rs.getInt(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
    public ArrayList<Skill> getList() {
        ArrayList<Skill> sList = new ArrayList<>();
        xSql = "select * from [Skill]";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("sId");
                Skill s = new Skill(id);
                sList.add(s);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sList;
    }
    
    @Override
    public int skillRequest(int sId) {
        int n = 0;
        RequestSkillDAO dao = new RequestSkillDAO();
        int maxId = dao.getRequestMaxId();
        xSql = "insert into [RequestSkill](rId,[sId]) values ("+ maxId +" ,"+ sId +")";
        try {
            ps = con.prepareStatement(xSql);
            n = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
//    public static void main(String[] args) {
//        RequestSkillDAO dao = new RequestSkillDAO();
////        ArrayList<Skill> list = dao.getList();
////        for (Skill x : list) {
////            System.out.println(x.getsId());
////        }
//        System.out.println(dao.getList());
//    }
}
