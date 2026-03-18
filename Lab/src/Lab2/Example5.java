package Lab2;

public class Example5 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 5);

        System.out.println("Длина: " + rectangle.getLength());
        System.out.println("Ширина: " + rectangle.getWidth());
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Периметр: " + rectangle.getPerimeter());
    }
}

class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }
}