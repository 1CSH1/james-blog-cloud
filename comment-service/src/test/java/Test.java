/**
 * @Author: James-CSH
 * @Date: 10/29/17 5:23 PM
 */
public class Test {

    public static void main(String[] args) {
        test02();
    }


    public static void test01() {
        String a = "1;2;3;4;5;6;7;";
        String[] b = a.split(";");
        for (int i = 0; i < b.length; i++) {
            System.out.println(i + b[i]);
        }
    }

    public static void test02() {
        String content = "[reply]asdfasdf[reply]sadf哈哈哈";
        System.out.println(content.substring(content.lastIndexOf("[reply]") + 7));
    }

}
