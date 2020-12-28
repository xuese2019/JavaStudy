package com.xuesemofa.resp;

import java.util.Date;

public class main {

    public static void main(String[] args) {
        Resp success = new Resp.Builder(200, "成功").build();
        System.out.println(success);
        Resp build = new Resp.Builder(200, "成功").data("token").build();
        System.out.println(build);

        System.out.println(System.identityHashCode(success));
        System.out.println(System.identityHashCode(build));

        System.out.println(Resp.OK);
        System.out.println(Resp.ERROR);

        Boolean aBoolean = Boolean.valueOf("1");
        new Date();

    }
}
