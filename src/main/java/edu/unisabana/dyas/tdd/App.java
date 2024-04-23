package edu.unisabana.dyas.tdd;

import edu.unisabana.dyas.tdd.registry.*;

public class App {
    public static void main(String[] args) {
       

      
        Registry registry = new Registry();

      
        Person[] people = {
            
            new Person("Ana", 1111, 40, Gender.FEMALE, false),
            new Person("Angel", 2222, 170, Gender.MALE, true),
            new Person("Santiago", 3333, 19, Gender.MALE, true),
            new Person("Angela", 3333, 20, Gender.FEMALE, true),
            new Person("Felipe", 4444, 20, Gender.UNIDENTIFIED, true)
        };

       
        for (Person person : people) {
            RegisterResult result = registry.registerVoter(person);
            switch (result) {
                case VALID:
                    System.out.println("Registration successful! " + 
                                       "Name: " + person.getName() + ", " +
                                       "ID: " + person.getId() + ", " +
                                       "Age: " + person.getAge() + ", " +
                                       "Gender: " + person.getGender() + ", " +
                                       "Alive: " + person.isAlive() +
                                       " is now a registered voter." + "\n");
                    break;
                case DEAD:
                    System.out.println("Sorry, " + person.getName() + "'s registration failed: " +
                                       "ID: " + person.getId() + ", " +
                                       "Age: " + person.getAge() + ", " +
                                       "Gender: " + person.getGender() + ", " +
                                       "Alive: " + person.isAlive() +
                                       " is deceased and cannot be registered."+ "\n");
                    break;
                case UNDERAGE:
                    System.out.println("Sorry, " + person.getName() + "'s registration failed: " +
                                       "ID: " + person.getId() + ", " +
                                       "Age: " + person.getAge() + ", " +
                                       "Gender: " + person.getGender() + ", " +
                                       "Alive: " + person.isAlive() +
                                       " is underage and cannot be registered."+ "\n");
                    break;
                case DUPLICATED:
                    System.out.println("Sorry, " + person.getName() + "'s registration failed: " +
                                       "ID: " + person.getId() + ", " +
                                       "Age: " + person.getAge() + ", " +
                                       "Gender: " + person.getGender() + ", " +
                                       "Alive: " + person.isAlive() +
                                       "'s ID number is already registered."+ "\n");
                    break;
                case INVALID_GENDER:
                    System.out.println("Sorry, " + person.getName() + "'s registration failed: " +
                                       "ID: " + person.getId() + ", " +
                                       "Age: " + person.getAge() + ", " +
                                       "Gender: " + person.getGender() + ", " +
                                       "Alive: " + person.isAlive() +
                                       " has an invalid gender and cannot be registered."+ "\n");
                    break;
                    case INVALID_AGE:
                    System.out.println("Sorry, " + person.getName() + "'s registration failed: " +
                                       "ID: " + person.getId() + ", " +
                                       "Age: " + person.getAge() + ", " +
                                       "Gender: " + person.getGender() + ", " +
                                       "Alive: " + person.isAlive() +
                                       " has an invalid age and cannot be registered."+ "\n");
                    break;
                default:
                    System.out.println("An unexpected error occurred.");
                    break;
            }
        }
    }
}
