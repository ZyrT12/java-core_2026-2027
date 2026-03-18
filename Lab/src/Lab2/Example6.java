package Lab2;

public class Example6 {
    public static void main(String[] args) {
        Figure circle = new Circle(5);
        Figure square = new Square(4);
        Figure triangle = new Triangle(3, 4, 5);

        System.out.println("Круг: S = " + circle.getArea() + ", P = " + circle.getPerimeter());
        System.out.println("Квадрат: S = " + square.getArea() + ", P = " + square.getPerimeter());
        System.out.println("Треугольник: S = " + triangle.getArea() + ", P = " + triangle.getPerimeter());
    }
}

interface Figure {
    double getArea();
    double getPerimeter();
}

class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }
}

class Square implements Figure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
}

class Triangle implements Figure {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }
}
