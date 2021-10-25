package edu.uaslp;


import edu.uaslp.list.MyIndexOutOfBoundException;
import edu.uaslp.list.List;
import edu.uaslp.list.linkedlist.LinkedList;

public class Main {


    public static void main(String[] args) {

        List<String> alumnos = new LinkedList<>();

        alumnos.add("Ivan");
        alumnos.add("Israel");


        try{
            String nombre = alumnos.getAt(0);

            System.out.println(nombre);

            nombre = alumnos.getAt(10);

            System.out.println(nombre);
        } catch(MyIndexOutOfBoundException ex){
            System.out.println("No pude obtener el nombre");
        }


    }

}
