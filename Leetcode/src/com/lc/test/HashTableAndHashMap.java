package com.lc.test;

import java.util.*;

public class HashTableAndHashMap {


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(2);
        Thread t1 = new Thread(() -> {
           for(int i=0;i<10000;i++){
               new Thread(()->{
                  map.put(UUID.randomUUID().toString(),"");
               }).start();
           }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        print.start();
    }


}

class wirteThread extends Thread {
    private Hashtable<Character, Integer> hashMap;

    public wirteThread(Hashtable<Character, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            this.hashMap.put((char) ('a' + i), i);
            System.out.println(hashMap.get((char)('a'+i)));
        }
    }
}

class printThread extends Thread {
    private Hashtable<Character, Integer> hashMap;

    public printThread(Hashtable<Character, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        super.run();
        Set<Character> keys = hashMap.keySet();
        for (Object key : keys) {
            int value = hashMap.get(key);
            System.out.println(value);
        }
    }
}
