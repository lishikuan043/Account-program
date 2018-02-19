package dao;

import domain.ZhangWu;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tools.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hust on 2018/2/19.
 * 具体实现层类
 */
public class ZhangWuDao {

    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    public int addZhangWu(ZhangWu zw) {
        String sql = "INSERT INTO gjp_zhangwu(flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?)";
        Object[] param = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
        int line = 0;
        try {
            line = queryRunner.update(sql,param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

    public int editZhangWu(ZhangWu zw) {
        String sql = "UPDATE gjp_zhangwu SET flname=?, money=?,zhangHu=?,createtime=?,description=? WHERE zwid=?";
        Object[] param = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
        int line = 0;
        try {
            line = queryRunner.update(sql,param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

    public int deleteZhangWu(int i) {
        String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?";
        int line = 0;
        try {
            line = queryRunner.update(sql,i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

    public List<ZhangWu> selectAll() {
        String sql = "SELECT * FROM gjp_zhangwu";
        List<ZhangWu> zhangWuList = new ArrayList<>();
        try {
            zhangWuList = queryRunner.query(sql,new BeanListHandler<ZhangWu>(ZhangWu.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zhangWuList;
    }

    public List<ZhangWu> select(String start, String end) {
        String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
        Object[] param = {start,end};
        List<ZhangWu> zhangWuList = new ArrayList<>();
        try {
            zhangWuList = queryRunner.query(sql,new BeanListHandler<ZhangWu>(ZhangWu.class),param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zhangWuList;
    }
}
