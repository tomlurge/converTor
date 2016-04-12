package converTor.stuff;

import java.awt.*;


public enum EnumTest {
  // The ; is mandatory for enums that have parameters
  TRIANGLE(3), SQUARE(4), PENTAGON(5), HEXAGON(6);
  private Shape shape;

  public Shape getShape() {
    return shape;
  }
  private EnumTest(int sides) {
    switch (sides) {
      case 3:
        // We assume that we have some general constructors
        // for shapes that take the side length and
        // angles in degrees as parameters
        shape = new Rectangle(1,60);
        break;
      case 4:
        shape = new Rectangle(1,1); break;
      case 5:
        shape = new Rectangle(1,1); break;
      case 6:
        shape = new Rectangle(120,120); break;
    }
  }
}