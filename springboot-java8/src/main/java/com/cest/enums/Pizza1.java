package com.cest.enums;

import lombok.Data;

@Data
public class Pizza1 {

    private PizzaStatus status;

    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    public boolean isDeliverable() {
        if (getStatus() == PizzaStatus.READY) {
            return true;
        }
        return false;
    }

    /**
     * switch
     * @return
     */
    public int getDeliveryTimeInDays() {
        switch (status) {
            case ORDERED: return 5;
            case READY: return 2;
            case DELIVERED: return 0;
        }
        return 0;
    }


    public static void main(String[] args) {
        Pizza1 pizza = new Pizza1();

        System.out.println(pizza.getStatus() == PizzaStatus.DELIVERED);

        // java.lang.NullPointerException
//        System.out.println(pizza.getStatus().equals(PizzaStatus.DELIVERED));

        boolean deliverable = pizza.isDeliverable();
        System.out.println(deliverable);

        pizza.setStatus(PizzaStatus.ORDERED);
        boolean deliverable1 = pizza.isDeliverable();
        System.out.println(deliverable1);
    }
}
