public class Area {

    public static void main(String[] args) {

        int lado = 5;
        int baseRect = 8;
        int alturaRect = 4;
        int baseTri = 6;
        int alturaTri = 3;
        double radio = 2.5;
        double pi = 3.1416;

        int areaCuadrado = lado * lado;
        int areaRectangulo = baseRect * alturaRect;
        int areaTriangulo = (baseTri * alturaTri) / 2;
        double areaCirculo = pi * radio * radio;

        System.out.println("Área del cuadrado: " + areaCuadrado);
        System.out.println("Área del rectángulo: " + areaRectangulo);
        System.out.println("Área del triángulo: " + areaTriangulo);
        System.out.println("Área del círculo: " + areaCirculo);
    }
}
