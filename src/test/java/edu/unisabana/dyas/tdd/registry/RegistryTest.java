package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void testValidVoter() {
        Person person = new Person("Pepito", 0000, 25, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void testDeceasedPerson() {
        Person person = new Person("Ana", 1111, 40, Gender.FEMALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void testUnderagePerson() {
        Person person = new Person("Angel", 2222, 15, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void testDuplicateId() {
        Person person1 = new Person("Santiago", 3333, 19, Gender.MALE, true);
        Person person2 = new Person("Angela", 3333, 20, Gender.FEMALE, true);
        registry.registerVoter(person1); 
        RegisterResult result = registry.registerVoter(person2); 
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void testInvalidGender() {
        Person person = new Person("Felipe", 4444, 20, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_GENDER, result);
    }
}