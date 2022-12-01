package com.bytelegend;

import java.lang.reflect.Field;

public class World {
    /**
     * `Cat` has a `walk()` method. `Fish` has a `swim()` method. Now a `Turtle` wants to reuse
     * `walk()` and `swim()` methods, but Java does not allow multiple inheritance, how to solve
     * this problem? This kind of requirement in object-oriented system is called `mixin`. It can be
     * solved by interface default method.
     */
    public static void main(String[] args) {
        new Cat("Tom").walk();
        new Fish("Nemo").swim();
        new Turtle("Turtle").walk();
        new Turtle("Turtle").swim();
    }
}



class Cat extends Animal implements  Walking {
    public Cat(String name) {
        super(name);
    }

}

class Fish extends Animal implements  Swimming {
    public Fish(String name) {
        super(name);
    }

}

interface Swimming {
    default void swim()
    {
        Field[] declaredFields = this.getClass().getSuperclass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                System.out.println(field.get(this) + " is swimming");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
interface Walking {
    default void walk()
    {
        Field[] declaredFields = this.getClass().getSuperclass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                System.out.println(field.get(this) + " is walking");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
abstract class Animal {
    public final String name;
    public Animal(String name) {
        this.name = name;
    }
}

class Turtle extends Animal implements Swimming, Walking {
    public Turtle(String name)
    {
        super(name);
    }

}
