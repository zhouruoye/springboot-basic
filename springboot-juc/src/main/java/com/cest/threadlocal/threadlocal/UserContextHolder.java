package com.cest.threadlocal.threadlocal;

import com.cest.threadlocal.pojo.User;

public class UserContextHolder {

    public static ThreadLocal<User> userMsg = new ThreadLocal();
}
