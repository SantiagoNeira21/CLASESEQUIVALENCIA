package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set;

public class Registry {
    private Set<Integer> registeredIds = new HashSet<>();

    public RegisterResult registerVoter(Person p) {
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }
        if (p.getAge() > 120) {
            return RegisterResult.INVALID_AGE;
        }
        if (registeredIds.contains(p.getId())) {
            return RegisterResult.DUPLICATED;
        }
        if (p.getGender() == Gender.UNIDENTIFIED) {
            return RegisterResult.INVALID_GENDER;
        }
        
        registeredIds.add(p.getId());
        return RegisterResult.VALID;
    }
}