package com.cest.basic.base;

public class DCL {

    private static DCL dcl;

    private static DCL getInstance() {
        if(dcl == null) {
            synchronized (DCL.class) {
                if(dcl == null) {
                    dcl = new DCL();
                }
            }
        }
        return dcl;
    }
}
