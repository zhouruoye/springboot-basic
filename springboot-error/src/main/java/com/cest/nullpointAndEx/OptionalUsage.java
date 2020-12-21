package com.cest.nullpointAndEx;

import lombok.Data;
import lombok.ToString;

import java.util.Optional;

/**
 * optional使用方法
 */
public class OptionalUsage {

    @Data
    @ToString
    public static class User {
        private String name;
    }

    public static User createNewUser() {
        return new User();
    }

    public static void main(String[] args) {
        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);

        // 存在即返回 空则提供默认值
        optionalUser.orElse(new User());

        // 存在即返回 空则由函数提供默认值
        optionalUser.orElseGet(() -> createNewUser());

        // 存在即返回 空则抛出异常
//        optionalUser.orElseThrow(RuntimeException::new);

        // 如果存在 --> isPresent
        System.out.println(optionalUser.isPresent());

        // 如果存在就进行处理
        optionalUser.ifPresent(n -> System.out.println(n));

    }
}
