/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.MyDAO;
/**
 *
 * @author Duong
 */
public class RequestSkillDAO extends MyDAO implements dao.RequestSkillDAO {

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

    @Override
    public int skillRequest(int sId) {
        int n = 0;
        RequestSkillDAO dao = new RequestSkillDAO();
        int maxId = dao.getRequestMaxId();
        xSql = "INSERT INTO [RequestSkill](rId,[sId]) VALUES (" + maxId + " ," + sId + ")";
        try {
            ps = con.prepareStatement(xSql);
            n = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
}
