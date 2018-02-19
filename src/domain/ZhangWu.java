package domain;

/**
 * Created by hust on 2018/2/19.
 * 账务类，javabean
 */
public class ZhangWu {

    private int zwid;
    private String flname;
    private String zhanghu;
    private double money;
    private String createtime;
    private String description;

    public int getZwid() {
        return zwid;
    }

    public void setZwid(int zwid) {
        this.zwid = zwid;
    }

    public String getFlname() {
        return flname;
    }

    public void setFlname(String flname) {
        this.flname = flname;
    }

    public String getZhanghu() {
        return zhanghu;
    }

    public void setZhanghu(String zhanghu) {
        this.zhanghu = zhanghu;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
