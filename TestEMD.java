package JavaFinalReport;

import javax.swing.*;
import java.util.Scanner;

public class TestEMD {
    //    /**
//     * len代表陣列的當前下標
//     */
    static int len = 0;
    static Employee[] emp = new Employee[100];
    static Scanner sc = new Scanner(System.in);
    //    /**
//     * 增加新經銷商
//     */


    public void addEmployee() {
        Employee em = null;
        JOptionPane.showMessageDialog(null, "增加經銷商");
        String id = JOptionPane.showInputDialog("請輸入經銷商編號：");
        try {
            int a = Integer.parseInt(id);
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "輸入錯誤" + "請輸入整數");
        }
        String name1 = JOptionPane.showInputDialog("請輸入經銷商姓名：");
        String job = JOptionPane.showInputDialog("請輸入經銷商級別(團購VIP、普通VIP、中級經銷商、總代經銷商)：");
        if(job.equals("團購VIP")) {
            em = new TGEmployee();
        } else if(job.equals("普通VIP")) {
            em = new PTEmployee();
        } else if(job.equals("中級經銷商")) {
            em = new ZJEmployee();
        } else if(job.equals("總代經銷商")) {
            em = new ZDEmployee();
        } else {
            JOptionPane.showMessageDialog(null,"輸入錯誤，請輸入正確級別名稱如：團購VIP、普通VIP、中級經銷商、總代經銷商。");
        }
        String name2 = JOptionPane.showInputDialog("請輸入經銷商上級姓名：");
//在此作一下邏輯判斷，根據job的不同，建立不同的Employee子類


        em.setID(id);
        em.setName1(name1);
        em.setJob(job);
        em.setName2(name2);
//len先加1後使用，變為emp[0]
        emp[len] = em;
        printEmployee(emp[len]);
        JOptionPane.showMessageDialog(null,"新增成功！");
        len++;
    }
    /**
     * 刪除經銷商
     */
    public void deleteEmployee() {
        JOptionPane.showMessageDialog(null,"刪除經銷商");
//設定一個boolean型別的flg標誌，若查詢不到則為false
        boolean flg = false;
        String name1 = JOptionPane.showInputDialog("請輸入經銷商姓名：");
        for(int i=0; i<=len; i++  ) {
//若查詢成功，則把emp[i]陣列後面的指標往前移一位，覆蓋掉當前的指向物件
            if(emp[i].getName1().equals(name1)) {
                printEmployee(emp[i]);
                for(int j=i; j<=len; j++  ) {
                    emp[j] = emp[j + 1];
                }
//前移後，最後一位置空，len--
                emp[len] = null;
                len--;
                JOptionPane.showMessageDialog(null,"刪除成功！");
                flg = true;
                break;
            }
        }
        if(!flg) {
            JOptionPane.showInputDialog("查無此人，請重新輸入：");
            deleteEmployee();
        }
    }
    //    /**
//     * 修改經銷商資訊
//     * @param args
//     * @return
//     */
    public void updateEmployee() {
        JOptionPane.showMessageDialog(null,"修改經銷商資訊");
//設定一個boolean型別的flg標誌，若查詢不到則為false
        boolean flg = false;
        String name1 = JOptionPane.showInputDialog("請輸入經銷商姓名：");;
        for(int i=0; i<=len; i++  ) {
            if(emp[i].getName1().equals(name1)) {
                printEmployee(emp[i]);
                JOptionPane.showMessageDialog(null,"請按照提示輸入修改資訊");
                emp[i].setID(JOptionPane.showInputDialog("請輸入經銷商編號："));

                emp[i].setName1(JOptionPane.showInputDialog("請輸入經銷商姓名："));
                emp[i].setJob(JOptionPane.showInputDialog("請輸入經銷商級別(團購VIP、普通VIP、中級經銷商、總代經銷商)："));
                emp[i].setName2(JOptionPane.showInputDialog("請輸入經銷商上級姓名："));
//修改完成後列印一下
                printEmployee(emp[i]);
                JOptionPane.showMessageDialog(null,"修改成功！");
                flg = true;
                break;
            }
        }
        if(!flg) {
            JOptionPane.showInputDialog("查無此人，請重新輸入：");
            updateEmployee();
        }
    }
    //    /**
//     * 根據姓名查詢經銷商資訊
//     * @param args
//     */
    public void findEmployee() {
        JOptionPane.showMessageDialog(null,"查詢經銷商");
//設定一個boolean型別的flg標誌，若查詢不到則為false
        boolean flg = false;
        String name1 = JOptionPane.showInputDialog("請輸入經銷商姓名：");
        for( int i=0; i<len; i++ ) {
            if(emp[i].getName1().equals(name1)) {
                printEmployee(emp[i]);
                JOptionPane.showMessageDialog(null,"查詢成功！");
                flg = true;
                break;
            }
        }
        if(!flg) {
            JOptionPane.showInputDialog("查無此人，請重新輸入：");
            findEmployee();
        }
    }
    //    /**
//     * 列印經銷商資訊
//     * @param args
//     */
    public void printEmployee(Employee em) {
        JOptionPane.showMessageDialog(null," 編號： " + em.getID() + "\n" + " 姓名： " + em.getName1() + "\n" + " 級別： " + em.getJob()  + "\n" + " 上級姓名 : " + em.getName2());
    }

    public TestEMD(){
        JOptionPane.showMessageDialog(null,"1. 增加 " + "\n" + "2. 刪除 " + "\n" + "3. 修改 " + "\n" + "4. 查詢 " + "\n" + "5. 退出 ");
//業務選擇
        label : while(true) {
            TestEMD te = null;
            int select = Integer.parseInt(JOptionPane.showInputDialog("請選擇業務："));
            switch (select) {
                case 1: //新增新經銷商
                    te.addEmployee();
                    break;
                case 2: //刪除經銷商
                    te.deleteEmployee();
                    break;
                case 3: //修改經銷商資訊
                    te.updateEmployee();
                    break;
                case 4: //根據姓名查詢經銷商資訊
                    te.findEmployee();
                    break;
                case 5: //退出
                    JOptionPane.showMessageDialog(null,"退出成功！");
                    break label;
                default:
                    JOptionPane.showMessageDialog(null,"您輸入的數字不正確！");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        TestEMD te = new TestEMD();
    }
}