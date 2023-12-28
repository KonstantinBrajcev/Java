package Pharmacy;
import java.util.*;

public class PharmacyMain {
    public static void main(String[] args) {
        Component Pinicilin = new Component("Pinicilin", "10mg", 100);
        Component Salt = new Component("Salt", "4mg", 30);
        Component Sugar = new Component("Sugar", "12mg", 123);
        Component Ftor = new Component("Ftor", "8mg", 85);
        Component Aurum = new Component("Aurum", "45mg", 185);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.addComponents(Pinicilin, Sugar, Aurum);

        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.addComponents(Pinicilin, Sugar);

        Pharmacy pharmacy2 = new Pharmacy();
        pharmacy2.addComponents(Salt, Sugar, Ftor);

        Pharmacy pharmacy3 = new Pharmacy();
        pharmacy3.addComponents(Salt, Pinicilin, Aurum);

        Set<Pharmacy> result1 = new HashSet<>();
        result1.add(pharmacy);
        result1.add(pharmacy1);
        result1.add(pharmacy2);
        result1.add(pharmacy3);
        System.out.println(result1.size());


        IterablePharmacy pharmacy4 = new IterablePharmacy();
        pharmacy4.addComponents(Pinicilin, Salt);

        IterablePharmacy pharmacy5 = new IterablePharmacy();
        pharmacy5.addComponents(Pinicilin, Salt);

        IterablePharmacy pharmacy6 = new IterablePharmacy();
        pharmacy6.addComponents(Salt, Sugar, Aurum);

        IterablePharmacy pharmacy7 = new IterablePharmacy();
        pharmacy7.addComponents(Salt, Pinicilin);

        Set<IterablePharmacy> result = new HashSet<>();
        result.add(pharmacy4);
        result.add(pharmacy5);
        result.add(pharmacy6);
        result.add(pharmacy7);
        System.out.println(result.size());
        System.out.println(pharmacy5.compareTo(pharmacy1));

    }
}