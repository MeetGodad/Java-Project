package shapes;

import java.util.Comparator;

/**
 * ShapeComparator.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class description: this class compares the shape based on their height, area and volume
 */
public class ShapeComparator implements Comparator<Shape> {
    public static final Comparator<Shape> COMPARE_BY_HEIGHT = new ShapeComparator(ShapeComparator::compareByHeight);
    public static final Comparator<Shape> COMPARE_BY_BASE_AREA = new ShapeComparator(ShapeComparator::compareByBaseArea);
    public static final Comparator<Shape> COMPARE_BY_VOLUME = new ShapeComparator(ShapeComparator::compareByVolume);

    private Comparator<Shape> comparator;

    private ShapeComparator(Comparator<Shape> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(Shape s1, Shape s2) {
        return comparator.compare(s1, s2);
    }
    
    /******************************** PRIVATE METHODS *****************************/
    //private method to compare.
    private static int compareByHeight(Shape s1, Shape s2) {
        return Double.compare(s1.getHeight(), s2.getHeight());
    }

    private static int compareByBaseArea(Shape s1, Shape s2) {
        return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
    }

    private static int compareByVolume(Shape s1, Shape s2) {
        return Double.compare(s1.calcVolume(), s2.calcVolume());
    }
}
