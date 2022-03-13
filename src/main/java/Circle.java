public class Circle {

    // Метод определения площади окружности
    public double calculateAreaOfCircle(double radius) {
        double area = Math.ceil(Math.PI * Math.pow(radius, 2) * 100) / 100;
        return area;
    }

    // Метод определения длины окружности
    public double calculateLengthOfCircle(double radius) {
        double length = Math.ceil(2 * Math.PI * radius * 100) / 100;
        return length;
    }

    // Метод определения радиуса вписанной в квадрат окружности
    public double calculateRadiusOfInnerCircle(double sideOfExternalSquare) {
        double radius = Math.ceil(sideOfExternalSquare / 2 * 100) / 100;
        return radius;
    }

    // Метод определения радиуса описанной около квадрата окружности
    public double calculateRadiusOfExternalCircle(double sideOfInnerSquare) {
        double radius = Math.ceil(sideOfInnerSquare * Math.sqrt(2) / 2 * 100) / 100;
        return radius;
    }

}
