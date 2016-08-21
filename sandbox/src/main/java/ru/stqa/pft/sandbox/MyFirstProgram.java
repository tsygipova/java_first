package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    Point p1 = new Point();
    p1.x = 0.5;
    p1.y = 7.32;
    Point p2 = new Point();
    p2.x = 8.9;
    p2.y = 4;
    System.out.println("p1 = " + p1.x + "," + p1.y);
    System.out.println("p2 = " + p2.x + "," + p2.y);
    System.out.println("Расстояние между двумя точками на плоскости" + " = " + distance(p1,p2));

  }

  public static double distance(Point p1, Point p2) {
   return Math.sqrt(Math.pow(p2.x - p1.x,2) + Math.pow(p2.y-p1.y,2));
  }
}