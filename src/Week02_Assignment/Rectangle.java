package Week02_Assignment;

public class Rectangle extends Shape {
    // Attributes
    public int width, height;

    // Constructor
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public Rectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    // Methods
    public int getArea() {
        return this.width * this.height;
    }

    public static void main(String[] args) {
        Rectangle R1 = new Rectangle(10, 6, "blue");
        System.out.printf("The area of this %s rectangle is: %d\n", R1.color, R1.getArea());
    }
}
