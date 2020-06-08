package com.cest.threadlocal.user;

import com.cest.threadlocal.pojo.User;
import com.cest.threadlocal.threadlocal.UserContextHolder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserController {

    public static void main(String[] args) {
        new UserController().getUsers();
    }

    /**
     * 获取用户信息
     */
    public void getUsers(){
        User user = new User();
        user.setName("王二");
        log.info("将{}放入threadlocal",user.getName());
        UserContextHolder.userMsg.set(user);

        new Service1().service();
    }
}

@Slf4j
class Service1 {

    public void service() {
        log.info("Service你的名字是:{}",UserContextHolder.userMsg.get().toString());
        new Service2().service();
    }
}

@Slf4j
class Service2 {

    public void service() {
        log.info("Service2你的名字是:{}",UserContextHolder.userMsg.get().toString());
        new Service3().service();
    }
}

@Slf4j
class Service3 {

    public void service() {
        log.info("Service3你的名字是:{}",UserContextHolder.userMsg.get().toString());
    }
}
