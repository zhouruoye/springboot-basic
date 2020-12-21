package com.cest.nullpointAndEx;

import lombok.extern.slf4j.Slf4j;

/**
 * java异常本质
 * 1 使用异常，而不是返回码(或类似)，因为异常会更加的详细
 * 2 主动捕获检查性异常，并对异常信息进行反馈(日志或标记)
 * 3 保持代码整洁，一个方法中不要有多个try catch或者嵌套的 try catch
 * 4 捕获更加具体的异常，而不是通用的Exception
 * 5 合理的设计自定义的异常类
 */
@Slf4j
public class ExceptionProcess {

    private static class User {

    }

    /**
     * 抛出异常
     */
    private void throwException() {
        User user = null;

        if (user == null) {
            throw new NullPointerException();
        }
    }

    /**
     *  不能捕获的异常 --> 抛出的异常和捕获的异常不对应
     */
    private void unCatchException() {
        try {
            throwException();
        } catch (ClassCastException e) {
            log.info("-----enter into unCatchException ClassCastException--------");
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getName());
        }
    }

    /**
     * 可以捕获的异常
     */
    private void catchException() {
        try {
            throwException();
        } catch (ClassCastException e) {
            log.info("-----enter into catchException ClassCastException--------");
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getName());
        } catch (NullPointerException e) {
            log.info("-----enter into catchException NullPointerException--------");
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getName());
        }
    }


    public static void main(String[] args) {
        ExceptionProcess exceptionProcess = new ExceptionProcess();
        exceptionProcess.catchException();
        exceptionProcess.unCatchException();
    }
}
