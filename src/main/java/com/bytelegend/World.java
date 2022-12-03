package com.bytelegend;

import java.lang.reflect.Field;

public class World {
    /**
     * `Cat` has a `walk()` method. `Fish` has a `swim()` method. Now a `Turtle` wants to reuse
     * `walk()` and `swim()` methods, but Java does not allow multiple inheritance, how to solve
     * this problem? This kind of requirement in object-oriented system is called `mixin`. It can be
     * solved by interface default method.
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        new Cat("Tom").walk();
//        new Fish("Nemo").swim();
//        new Turtle("Turtle").walk();
//        new Turtle("Turtle").swim();

        Cat cat = new Cat("T");
        Field[] fields = Cat.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].get(cat));
        }



    }

}

//abstract class WalkingAnimal {
//    private final String name;
//
//    public WalkingAnimal(String name) {
//        this.name = name;
//    }
//
//    public void walk() {
//        System.out.println(name + " is walking");
//    }
//}

//abstract class SwimmingAnimal {
//    private final String name;
//
//    public SwimmingAnimal(String name) {
//        this.name = name;
//    }
//
//    public void swim() {
//        System.out.println(name + " is swimming");
//    }
//}

class Cat extends Animal implements Walking {
    public Cat(String name) {
        super(name);
        System.out.print(name);
    }


}

class Fish extends Animal implements Swimming {
    public Fish(String name) {
        super(name);
        System.out.print(name);
    }


}


interface Swimming {
    default void swim() {
        System.out.println(" is swimming");
    }
}
interface Walking {
    default void walk() {
        System.out.println(" is walking");
    }
}
abstract class Animal {
    public final String name;
    public Animal(String name) {
        this.name = name;
    }
}

class Turtle extends Animal implements Swimming, Walking {


    public Turtle(String name) {
        super(name);
        System.out.print(name);
    }
}

