package com.bytelegend;

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

abstract class WalkingAnimal {
    private final String name;

    public WalkingAnimal(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println(name + " is walking");
    }
}

abstract class SwimmingAnimal {
    private final String name;

    public SwimmingAnimal(String name) {
        this.name = name;
    }

    public void swim() {
        System.out.println(name + " is swimming");
    }
}

class Cat extends WalkingAnimal {
    public Cat(String name) {
        super(name);
    }
}

class Fish extends SwimmingAnimal {
    public Fish(String name) {
        super(name);
    }
}

/*
interface Swimming {
    default void swim();
}
interface Walking {
    default void walk();
}
abstract class Animal {
    private final String name;
    public Animal(String name) {
        this.name = name;
    }
}

class Turtle extends Animal implements Swimming, Walking {
}
*/
