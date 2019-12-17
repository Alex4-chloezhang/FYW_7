package com.fy.dao;

import com.fy.model.User;
import com.fy.util.DBCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUser(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = DBCommon.getConnection();
            String sql = "select * from user where username=? and password=?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return user;
    }
}
