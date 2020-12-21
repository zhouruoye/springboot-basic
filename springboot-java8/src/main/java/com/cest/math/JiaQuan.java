package com.cest.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

public class JiaQuan {

    static Map<Double,Integer> map = new HashMap<>();

    static List<Container> containers = new ArrayList<>();

    static {
        map.put(2D, 4400);
        map.put(3D, 1575);
        map.put(4D, 755);
        map.put(5D, 462);
        map.put(6D, 310);
        map.put(7D, 186);
        map.put(8D, 117);
        map.put(9D, 78);
        map.put(10D, 58);
        map.put(11D, 45);
        map.put(12D, 33);
        map.put(13D, 25);
        map.put(14D, 13);
        map.put(15D, 7);
        map.put(16D, 8);
        map.put(17D, 4);
        map.put(18D, 4);
        map.put(19D, 3);
        map.put(20D, 1);
        map.put(21D, 4);
        map.put(22D, 1);
        map.put(23D, 1);
        map.put(25D, 1);

        map.forEach((k,v) -> {
            Container container = new Container();
            container.setRownum(k.intValue());
            container.setNumAstCgy(v.doubleValue());
            containers.add(container);
        });

    }

    public static void main(String[] args) {
        List<Container> list = containers;

        list.sort((s1,s2) -> s1.getRownum() - s2.getRownum());

        double total = getTotal(list);
        System.out.println("加权总数是" + total);

        for (int i = 0; i < list.size(); i++) {
            List<Container> listNew = list.subList(0, i+1);
            double totalNew = getTotal(listNew);
            System.out.println("当前总数是:" + totalNew);
            System.out.println(totalNew/total + "  " + list.get(i));
            if(totalNew/total * 100 > 90) {
                System.out.println("haha");
            }
        }

//        double weightedAverage =
//                map.entrySet().stream().collect(averagingWeighted(Map.Entry::getKey, Map.Entry::getValue));
//
//
//        System.out.println(weightedAverage);
    }

    public void mathAverage(List<Container> list) {



    }

    public static double getTotal(List<Container> list) {
        int num = 0;
        for (Container container : list) {
            num += container.getRownum() * container.getNumAstCgy();
        }
        return num;
    }

    static <T> Collector<T,?,Double> averagingWeighted(ToDoubleFunction<T> valueFunction, ToIntFunction<T> weightFunction) {
        class Box {
            double num = 0;
            long denom = 0;
        }
        return Collector.of(
                Box::new,
                (b, e) -> {
                    b.num += valueFunction.applyAsDouble(e) * weightFunction.applyAsInt(e);
                    b.denom += weightFunction.applyAsInt(e);
                },
                (b1, b2) -> { b1.num += b2.num; b1.denom += b2.denom; return b1; },
                b -> b.num / b.denom
        );
    }
}
