package triangle;
import java.awt.geom.Point2D;

/**
 *
 * @author dscivi1
 */
abstract public class Polygon {
    
    public Point2D.Double[] vertices;
    
    public Polygon()
    {
        vertices = null;
    }
    
    public Polygon(Point2D.Double[] points)
    {
        vertices = points;
    }
    
    public double distance(Point2D.Double p1, Point2D.Double p2)
    {
        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
    }
    
    abstract public double area();
    
    public double perimeter()
    {
        double n = vertices.length - 1;
        double perimeter = 0;
        for (int i = 0; i < n; i++)
        {
            perimeter += distance(vertices[i], vertices[i+1]);
        }
        perimeter += distance(vertices[2], vertices[0]);
        return perimeter;
    }
    
}