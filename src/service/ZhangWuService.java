package service;

import dao.ZhangWuDao;
import domain.ZhangWu;

/**
 * Created by hust on 2018/2/19.
 */
public class ZhangWuService {

    ZhangWuDao zhangWuDao = new ZhangWuDao();

    public int addZhangWu(ZhangWu zw) {
        return zhangWuDao.addZhangWu(zw);
    }
}
