public class Circle {
    double radius;
    Circle(){
        radius =1.0;
    }

    Circle(double radius){
        this.radius =radius;
    }

    double getArea(){
        return radius*radius*Math.PI;
    }
}
