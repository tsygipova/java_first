package ru.stqa.pft.sandbox;

/**
 * Created by Дарья on 21-Aug-16.
 */
public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p2) {
    double res = Math.sqrt((x-p2.x)*(x-p2.x+(y-p2.y)*(y-p2.y)));
    return (res);
  }
}