package com.fy.dao;

import com.fy.model.Item;
import com.fy.util.DBCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public List<Item> findItemAll() {
        List<Item> items = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "select * from item";
            ps = DBCommon.getPreparedStatement(sql, con);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDestr(rs.getString("destr"));
                item.setNum(rs.getInt("num"));
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return items;
    }

    @Override
    public int addItem(Item item) {
        Connection con = null;
        PreparedStatement ps = null;
        int addCount = 0;

        try {
            con = DBCommon.getConnection();
            String sql = "insert into item(name, destr, num) values(?, ?, ?)";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, item.getName());
            ps.setString(2, item.getDestr());
            ps.setInt(3, item.getNum());
            addCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return addCount;
    }

    @Override
    public int deleteItem(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        int deleteCount = 0;

        try {
            con = DBCommon.getConnection();
            String sql = "delete from item where id=?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setInt(1, id);
            deleteCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return deleteCount;
    }

    @Override
    public Item getItem(int id) {
        Item item = new Item();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "select * from item where id=?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setInt(1, id);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDestr(rs.getString("destr"));
                item.setNum(rs.getInt("num"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return item;
    }

    @Override
    public int updateItem(Item item) {
        Connection con = null;
        PreparedStatement ps = null;
        int updateCount = 0;

        try {
            con = DBCommon.getConnection();
            String sql = "update item set name=?,destr=?,num=? where id=?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, item.getName());
            ps.setString(2, item.getDestr());
            ps.setInt(3, item.getNum());
            ps.setInt(4, item.getId());
            updateCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return updateCount;
    }
}
