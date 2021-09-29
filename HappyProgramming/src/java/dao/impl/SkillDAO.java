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
public class SkillDAO extends MyDAO implements dao.SkillDAO {

    @Override
    public ArrayList<Skill> getAllSkill() {
        ArrayList<Skill> list = new ArrayList<>();
        xSql = "select * from [Skill]";
        int id;
        String name, detail, image;
        Skill s;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("sId");
                name = rs.getString("sName");
                detail = rs.getString("sDetail");
                image = rs.getString("sImage");
                s = new Skill(id, name, detail, image);
                list.add(s);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Skill> getSkillByName(String sName) {
        ArrayList<Skill> list = new ArrayList<>();
        xSql = "select * from [Skill] where sName like '% " + sName + "%'";
        int id;
        String name, detail;
        Skill s;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("sId");
                name = rs.getString("sName");
                detail = rs.getString("sDetail");
                s = new Skill(id, name, detail);
                list.add(s);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //viet thang
    @Override
    public Skill getSkillById(String sId) {
        Skill skill = new Skill();

        xSql = "select * from [Skill] where sId='" + sId + "'";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            if (rs.next()) {
                skill.setsId(rs.getInt("sId"));
                skill.setsName(rs.getString("sName"));
                skill.setsDetail(rs.getString("sDetail"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return skill;
    }

    public void insert(Skill x) {
        xSql = "insert into [Skill] values (?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getsName());
            ps.setString(2, x.getsDetail());
            ps.setString(3, x.getsImage());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean findDupSkill(String sName) {
        ArrayList<Skill> sList = getAllSkill();
        for (Skill s : sList) {
            if (sName.equalsIgnoreCase(s.getsName())) {
                return true;
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        SkillDAO u = new SkillDAO();
//        ArrayList<Skill> x= u.getAllSkill();
//        for (Skill s: x){
//            System.out.println(s.getsName()+" "+s.getsId());
//        }
//    }
}
