package dao;

import domain.ZhangWu;
import org.apache.commons.dbutils.QueryRunner;
import tools.JDBCUtils;

import java.sql.SQLException;

/**
 * Created by hust on 2018/2/19.
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
}
