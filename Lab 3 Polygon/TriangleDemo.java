package triangle;
import java.awt.geom.Point2D;

/**
 *
 * @author dscivi1
 */
public class TriangleDemo {
    
    public static void main(String[] args)
    {
        Point2D.Double[] points1 = { new Point2D.Double(9,9),
                                     new Point2D.Double(11,14),
                                     new Point2D.Double(13,17) };
        Point2D.Double[] points2 = { new Point2D.Double(5,6),
                                     new Point2D.Double(5,46),
                                     new Point2D.Double(14,6) };
        Triangle triangle1 = new Triangle(points1);
        System.out.println("The first triangle: " + triangle1);
        System.out.printf("perimeter: %.4f\n", triangle1.perimeter());
        System.out.printf("area: %.4f\n", triangle1.area());
        System.out.println();
        Triangle triangle2 = new Triangle(points2);
        System.out.println("The second triangle: " + triangle2);
        System.out.printf("perimeter: %.4f\n", triangle2.perimeter());
        System.out.printf("area: %.4f\n", triangle2.area());
        
    }
    
}