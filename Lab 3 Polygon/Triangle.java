package triangle;
import java.awt.geom.Point2D;

/**
 *
 * @author dscivi1
 */
public class Triangle extends Polygon{
    
    public Triangle(Point2D.Double[] points)
    {
        super(points);
    }
    
    public double area()
    {
        Point2D.Double first, second, third;
        first = vertices[0];
        second = vertices[1];
        third = vertices[2];
        double s = ((distance(first, second)) + (distance(second, third)) + (distance(first, third))) / 2;
        double a = Math.sqrt(s*(s - distance(first, second))*(s - distance(second, third))*(s - distance(first, third)));
        return a;
    }
    
    public String toString()
    {
        String string = "{ ";
        for (int i = 0; i < 3; i++)
        {
            string += "(" + vertices[i].x + " " + vertices[i].y + ")";
            if (i < 2)
            {
                string += ", ";
            }
        }
        string += " }";
        return string;
    }
    
}