package view;

import domain.ZhangWu;
import service.ZhangWuService;

import java.util.List;
import java.util.Scanner;

/**
 * Created by hust on 2018/2/19.
 */
public class MainView {

    private ZhangWuService zhangWuService = new ZhangWuService();

    public void run() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("---------------管家婆家庭记账系统---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    addZhangWu();
                    break;
                case 2:
                    editZhangWu();
                    break;
                case 3:
                    deleteZhangWu();
                    break;
                case 4:
                    selectZhangWu();
                    break;
                case 5:
                    System.out.println("系统关闭！");
                    flag = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入[1-5]：");
            }
        }
    }

    private void selectZhangWu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.查询所有　2.按条件查询");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                selectAll();
                break;
            case 2:
                select();
                break;
            default:
                System.out.println("输入错误！");
        }
    }

    private void select() {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入查询起始时间：");
        String start = in.next();
        System.out.print("请输入查询结束时间：");
        String end = in.next();
        List<ZhangWu> zhangWuList = zhangWuService.select(start,end);
        print(zhangWuList);
    }

    private void selectAll() {
        List<ZhangWu> zhangWuList = zhangWuService.selectAll();
        print(zhangWuList);
    }

    private void print(List<ZhangWu> zhangWuList) {
        System.out.println("ID\t\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
        for (ZhangWu zw : zhangWuList) {
            System.out.println(zw.getZwid() + "\t\t\t" + zw.getFlname() + "\t\t"
                    + zw.getZhanghu() + "\t\t" + zw.getMoney() + "\t\t"
                    + zw.getCreatetime() + "\t\t" + zw.getDescription());
        }
    }

    private void deleteZhangWu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改账务编号：");
        int num = zhangWuService.deleteZhangWu(scanner.nextInt());
        if (num == 1) {
            System.out.println("账务删除成功！");
        } else {
            System.out.println("账务删除失败！");
        }
    }

    private void editZhangWu() {
        Scanner scanner = new Scanner(System.in);
        ZhangWu zw = new ZhangWu();
        System.out.println("请输入需要修改账务编号：");
        zw.setZwid(scanner.nextInt());
        System.out.println("请输入分类名称：");
        zw.setFlname(scanner.next());
        System.out.println("请输入账户名称：");
        zw.setZhanghu(scanner.next());
        System.out.println("请输入金额：");
        zw.setMoney(scanner.nextDouble());
        System.out.println("请输入创建时间：");
        zw.setCreatetime(scanner.next());
        System.out.println("请输入说明：");
        zw.setDescription(scanner.next());
        int num = zhangWuService.editZhangWu(zw);
        if (num == 1) {
            System.out.println("账务修改成功！");
        } else {
            System.out.println("账务修改失败！");
        }
    }

    private void addZhangWu() {
        Scanner scanner = new Scanner(System.in);
        ZhangWu zw = new ZhangWu();
        System.out.println("请输入分类名称：");
        zw.setFlname(scanner.next());
        System.out.println("请输入账户名称：");
        zw.setZhanghu(scanner.next());
        System.out.println("请输入金额：");
        zw.setMoney(scanner.nextDouble());
        System.out.println("请输入创建时间：");
        zw.setCreatetime(scanner.next());
        System.out.println("请输入说明：");
        zw.setDescription(scanner.next());
        int num = zhangWuService.addZhangWu(zw);
        if (num == 1) {
            System.out.println("账务添加成功！");
        } else {
            System.out.println("账务添加失败！");
        }
    }
}
