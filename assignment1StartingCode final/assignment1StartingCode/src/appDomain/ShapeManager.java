package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import appDomain.SortingAlgorithms.BubbleSort;
import appDomain.SortingAlgorithms.HeapSort;
import appDomain.SortingAlgorithms.InsertionSort;
import appDomain.SortingAlgorithms.MergeSort;
import appDomain.SortingAlgorithms.QuickSort;
import appDomain.SortingAlgorithms.SelectionSort;
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.ShapeComparator;
import shapes.SquarePrism;
import shapes.TriangularPrism;

/**
 * ShapeManager.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.2 Class Description: This class reads shapes in the form
 *  of array,compares them on the bases of height, base area and volume, 
 *  Short the shapes using selected algorithm and print the first sorted 
 *  value and last sorted value, and every thousandth value in between.
 */
public class ShapeManager {
	shapes.Shape[] shapes;
	String filename = "";
    String comparisonType = "";
    String sortingAlgorithm = "";
    
    
    public void shortedList() {
    	for (int i = 0; i < shapes.length; i++) {
            if (i == 0 || i == shapes.length - 1 || i % 1000 == 0) {
                System.out.printf("%d. %s%n", i + 1, shapes[i]);
                
            }
        }
    }
    
	public void compareBy() {
		Comparator<shapes.Shape> comparator = ShapeComparator.COMPARE_BY_HEIGHT;
        if (comparisonType.equalsIgnoreCase("-a")) {
            comparator = ShapeComparator.COMPARE_BY_BASE_AREA;
        } else if (comparisonType.equalsIgnoreCase("-v")) {
            comparator = ShapeComparator.COMPARE_BY_VOLUME;
        }else if (comparisonType.equalsIgnoreCase("-h")) {
            comparator = ShapeComparator.COMPARE_BY_HEIGHT;
        }
        switch (sortingAlgorithm.toLowerCase()) {
        case "b":
            BubbleSort.sort(shapes, comparator);
            break;
        case "s":
            SelectionSort.sort(shapes, comparator);
            break;
        case "i":
            InsertionSort.sort(shapes, comparator);
            break;
        case "m":
            MergeSort.sort(shapes, comparator);
            break;
        case "q":
            QuickSort.sort(shapes, comparator);
            break;
        case "h":
            HeapSort.sort(shapes, comparator);
            break;
        default:
            System.out.println("Invalid sorting algorithm.");
            return;
    }
}

	
/******************************** PRIVATE METHODS 
 * @return *****************************/
	// This method reads the shape in the array.//
	public void shapesList(String[] args) {
		
		{if (args.length != 3) {
            System.out.println("");
            return;
        }
        int i= 0;
	
   	 while (i < args.length) {
   		 
   		    if ((args[i].startsWith("-f")) || (args[i].startsWith("-F"))) {
   		        filename = args[i].substring(2);
   		        if ("shapes1.txt".equals(filename) || "shapes2.txt".equals(filename) || "shapes3.txt".equals(filename)) {
   				    filename = "res/" + filename;
   				}
   		    } else if ((args[i].startsWith("-t")) || (args[i].startsWith("-T"))) {
   		        comparisonType = args[i].substring(2);
   		    } else if ((args[i].startsWith("-s")) || (args[i].startsWith("-S"))) {
   		        sortingAlgorithm = args[i].substring(2);
   		    } else {
   		        System.err.println("Invalid command line argument: " + args[i]);
   		        return;
   		    }
   		    i++;
   	 }
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int shapeCount = Integer.parseInt(br.readLine());
            shapes = new shapes.Shape[shapeCount];
            String[] lineParts;
            String shapeType;
            double height, length;
            int index = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                lineParts = line.split("\\s+");
                if (lineParts.length > 0) {
                    shapeType = lineParts[0];
                    height = Double.parseDouble(lineParts[1]);

                    switch (shapeType) {
                        case "Cylinder":
                            double radius1 = Double.parseDouble(lineParts[2]);
                            shapes[index] = new Cylinder(height, radius1);
                            break;
                        case "Cone":
                            double radius11 = Double.parseDouble(lineParts[2]);
                            shapes[index] = new Cone(height, radius11);
                            break;
                        case "OctagonalPrism":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new OctagonalPrism(height, length);
                            break;
                        case "PentagonalPrism":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new PentagonalPrism(height, length);
                            break;
                        case "SquarePrism":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new SquarePrism(height, length);
                            break;
                        case "TriangularPrism":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new TriangularPrism(height, length);
                            break;
                        case "Pyramid":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new Pyramid(height, length);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid shape type");
                    }
                    index++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data file");
            e.printStackTrace();
            return;
        }


	}
}}