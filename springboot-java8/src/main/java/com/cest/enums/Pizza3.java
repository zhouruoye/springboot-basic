package com.cest.enums;

import lombok.Data;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Pizza3 {

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses =
            EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery() + " days");
    }

    public static List<Pizza3> getAllUndeliveredPizzas(List<Pizza3> input) {
        return input.stream().filter(
                (s) -> undeliveredPizzaStatuses.contains(s.getStatus()))
                .collect(Collectors.toList());
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
                    .deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    public static EnumMap<PizzaStatus, List<Pizza3>> groupPizzaByStatus(List<Pizza3> pizzaList) {
        EnumMap<PizzaStatus, List<Pizza3>> pzByStatus =
                new EnumMap<PizzaStatus, List<Pizza3>>(PizzaStatus.class);

        for (Pizza3 pz : pizzaList) {
            PizzaStatus status = pz.getStatus();
            if (pzByStatus.containsKey(status)) {
                pzByStatus.get(status).add(pz);
            } else {
                List<Pizza3> newPzList = new ArrayList<Pizza3>();
                newPzList.add(pz);
                pzByStatus.put(status, newPzList);
            }
        }
        return pzByStatus;
    }


    public static void main(String[] args) {
        List<Pizza3> pzList = new ArrayList<>();
        Pizza3 pz1 = new Pizza3();
        pz1.setStatus(Pizza3.PizzaStatus.DELIVERED);

        Pizza3 pz2 = new Pizza3();
        pz2.setStatus(Pizza3.PizzaStatus.ORDERED);

        Pizza3 pz3 = new Pizza3();
        pz3.setStatus(Pizza3.PizzaStatus.ORDERED);

        Pizza3 pz4 = new Pizza3();
        pz4.setStatus(Pizza3.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        List<Pizza3> undeliveredPzs = Pizza3.getAllUndeliveredPizzas(pzList);
        System.out.println(undeliveredPzs.toString());
    }
}
