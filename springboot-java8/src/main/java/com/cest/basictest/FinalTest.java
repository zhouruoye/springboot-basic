package com.cest.basictest;

public class FinalTest {

    //一个常量 PI是不允许在程序中被修改的
    public static final double PI = 3.1415926;

    public static void main(String[] args) {
        new FinalTest().test(1);
    }

    /**
     * final方法，防止子类修改(重写)，据说执行效率会比不加final好
     *
     * @param i final参数 只能读取不能被改变
     */
    public final void test(final int i) {
        //i=2;
        System.out.println(i);
    }


    /**
     * FinalTest的子类，为了演示final方法和final类
     * 1.如果使用final修饰FinalTest，你会发现FinalTestSon将不能继承FinalTest
     * 2.FinalTest.test方法是用final修饰的，所以不能被复写
     *
     * @author cxy @ www.cxyapi.com
     */

    class FinalTestSon extends FinalTest {
        //public void test(final int i){}
    }

}
