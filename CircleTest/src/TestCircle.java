public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("radius"+circle.radius+" is "+circle.getArea());

        Circle circle2 = new Circle(25);
        System.out.println("radius"+circle2.radius+" is "+circle2.getArea());

        Circle circle3 = new Circle(125);
        System.out.println("radius"+circle3.radius+" is "+circle3.getArea());

        circle2.radius=100;
        System.out.println("radius"+circle2.radius+" is "+circle2.getArea());

    }

}
