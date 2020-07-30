package com.cest.enums;

public enum  PizzaDeliveryStrategy {

    EXPRESS {
        @Override
        public void deliver(Pizza3 pz) {
            System.out.println("Pizza will be delivered in express mode");
        }
    },
    NORMAL {
        @Override
        public void deliver(Pizza3 pz) {
            System.out.println("Pizza will be delivered in normal mode");
        }
    };

    public abstract void deliver(Pizza3 pz);
}
