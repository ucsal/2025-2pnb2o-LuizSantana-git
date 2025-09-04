package br.com.mariojp.solid.ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {

    private final Map<CustomerType, DiscountPolicy> policies;
    //mapa de policies

    public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        this.policies = policies;
        //construtor que inveta dependencias
    }

    //construtor com padrões
    public DiscountCalculator() {
        Map<CustomerType, DiscountPolicy> defaults = new HashMap<>();
        defaults.put(CustomerType.REGULAR, new RegularPolicy());
        defaults.put(CustomerType.PREMIUM, new PremiumPolicy());
        defaults.put(CustomerType.PARTNER, new PartnerPolicy());
        this.policies = defaults;
    }

    public double apply(double amount, CustomerType type) {

        if (this.policies.containsKey(type)) {
            return this.policies.get(type).apply(amount);
        } else {
            return amount;
        }
    }
}
