package Lab2;

public class Example8 {
    public static void main(String[] args) {
        Animal dog = new Dog("Шарик", 3, "Овчарка");
        Animal cat = new Cat("Мурзик", 2, "Сухой корм");
        Animal bird = new Bird("Кеша", 1, true);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}

class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Животное издает звук");
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void makeSound() {
        System.out.println("Собака " + name + " говорит: Гав-гав");
    }
}

class Cat extends Animal {
    private String food;

    public Cat(String name, int age, String food) {
        super(name, age);
        this.food = food;
    }

    public void makeSound() {
        System.out.println("Кошка " + name + " говорит: Мяу");
    }
}

class Bird extends Animal {
    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    public void makeSound() {
        System.out.println("Птица " + name + " говорит: Чирик");
    }
}
