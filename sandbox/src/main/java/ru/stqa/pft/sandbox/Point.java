package ru.stqa.pft.sandbox;

/**
 * Created by Дарья on 21-Aug-16.
 */
public class Point {

  public double x;
  public double y;

  public Point(double x,double y) {
    this.x = x;
    this.y = y;
  }

  public static void main(String args[]) {
    Point p1 = new Point(0.5, 7.32);
    Point p2 = new Point(8.9, 4);
    System.out.println("p1 = " + p1.x + ", " + p1.y);
    System.out.println("p2 = " + p2.x + ", " + p2.y);

  }
  public double distance(Point p) {
    double dx = this.x - p.x;
    double dy = this.y - p.y;
    return Math.sqrt(dx*dx + dy*dy);

  }

  public double distance(Point p) {
    return distance(p.x, p.y);
  }
}

//class PointDist {