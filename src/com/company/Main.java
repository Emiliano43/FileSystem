package com.company;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(4));
        shapes.add(new Square(5));
        shapes.add(new Triangle(4, 5 , 6));
        shapes.add(new Rectangle(3, 4));

        FileOperations<Shape> converter = new FiguresWriter("shapes.json");
        try {
            converter.putToFile(shapes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            List<Shape> shapesFromFile = converter.getFromFile();
            shapesFromFile.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
