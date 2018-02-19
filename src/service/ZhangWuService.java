package service;

import dao.ZhangWuDao;
import domain.ZhangWu;

import java.util.List;

/**
 * Created by hust on 2018/2/19.
 * 服务层类
 */
public class ZhangWuService {

    ZhangWuDao zhangWuDao = new ZhangWuDao();

    public int addZhangWu(ZhangWu zw) {
        return zhangWuDao.addZhangWu(zw);
    }

    public int editZhangWu(ZhangWu zw) {
        return zhangWuDao.editZhangWu(zw);
    }

    public int deleteZhangWu(int i) {
        return zhangWuDao.deleteZhangWu(i);
    }

    public List<ZhangWu> selectAll() {
        return zhangWuDao.selectAll();
    }

    public List<ZhangWu> select(String start, String end) {
        return zhangWuDao.select(start,end);
    }
}
