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

class Cat extends Animal implements Walking {
    public Cat(String name) {
        super(name);
    }
}

class Fish extends Animal implements Swimming{
    public Fish(String name) {
        super(name);
    }
}

class Turtle extends Animal implements Swimming, Walking {
    public Turtle(String name) {
        super(name);
    }
}

interface Swimming extends NameExtraction{
    default void swim() {
        System.out.println(getName() + " is swimming");
    }
}
interface Walking extends NameExtraction{
    default void walk() {
        System.out.println(getName() + " is walking");
    }
}

interface NameExtraction {
    String getName();
}
abstract class Animal implements NameExtraction {
    private final String name;
    public Animal(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }
}
