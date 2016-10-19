package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Дарья on 26-Aug-16.
 */
public class PointTests {

  @Test
  public void testDistance1() {
    Point p1 = new Point(10, 5);
    Point p2 = new Point(20, 5);
    assert p1.distance(p2) == 10;
  }
}
