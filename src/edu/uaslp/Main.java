package edu.uaslp;

import edu.uaslp.list.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList libros = new LinkedList();
        LinkedList alumnos = new LinkedList();

        libros.add(1);
        libros.add(3);
        libros.add(43);
        libros.add(32);

        alumnos.add(43);
        alumnos.add(22);


        libros.insert(100, 0);
        libros.insert(200, 4);
        libros.insert(300, 2);


        libros.delete(2);


        System.out.println("Libros size:" + libros.getSize());
        System.out.println("Alumnos size:" + alumnos.getSize());


        System.out.println("Libros en posición 3 :" + libros.getAt(3));

        libros.print();

    }
}
