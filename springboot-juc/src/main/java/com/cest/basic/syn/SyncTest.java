package com.cest.basic.syn;

public class SyncTest {

   public synchronized void test() {

   }

   public void test2() {
       synchronized (this) {

       }
   }
}
