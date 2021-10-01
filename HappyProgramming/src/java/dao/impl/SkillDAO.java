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

import context.MyDAO;
import entity.Skill;
import java.util.ArrayList;

/**
 * This class implements from class interface SkillDAO. <br>
 * This class contains method to query select data from the table Skill.<br>
 * There are Get all Skill in the database, , Get skill by name, Get skill by
 * ID, Insert new Skill into the database,Find duplicate skill
 *
 * @author giangnvthe150748
 */
public class SkillDAO extends MyDAO implements dao.SkillDAO {

    /**
     * Get all Skill of the user in the database
     *
     * @return a list <code>Skill</code> object
     */
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

    //viet thang
    @Override
    public Skill getSkillById(String sId) {
        Skill skill = new Skill();

        xSql = "select * from [Skill] where sId='" + sId + "'";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            if (rs.next()) {
                skill.setId(rs.getInt("sId"));
                skill.setName(rs.getString("sName"));
                skill.setDetail(rs.getString("sDetail"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return skill;
    }

    /**
     * Insert new Rating into the database
     *
     */
    @Override
    public void insert(Skill x) {
        xSql = "insert into [Skill] values (?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setString(2, x.getDetail());
            ps.setString(3, x.getImage());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    /**
     * find duplicate skill in database
     * 
     * @return a boolean object
     */
    @Override
    public boolean findDupSkill(String sName) {
        ArrayList<Skill> sList = getAllSkill();
        for (Skill s : sList) {
            if (sName.equalsIgnoreCase(s.getName())) {
                return true;
            }
        }
        return false;
    }

}
