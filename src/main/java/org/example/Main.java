package org.example;


import org.example.entity.Employee;


import java.util.*;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World!");

        LinkedList<Employee> personeller = new LinkedList<>();
        personeller.add(new Employee(1, "Ahmet", "Ateş"));
        personeller.add(new Employee(2, "Mehmet", "Yılmaz"));
        personeller.add(new Employee(6, "Veli", "Öztürk"));
        personeller.add(new Employee(3, "Ayşe", "Demir"));
        personeller.add(new Employee(1, "Ahmet", "Ateş"));
        personeller.add(new Employee(4, "Fatma", "Kaya"));
        personeller.add(new Employee(5, "Ali", "Çelik"));
        personeller.add(new Employee(6, "Veli", "Öztürk"));


        System.out.println(personeller);
        System.out.println("id="+personeller.get(0).getId());
        System.out.println("tekrarlar=" + findDuplicates(personeller));
        System.out.println("------------------");
        System.out.println(findUniques(personeller));
        System.out.println("-----------------------");
        System.out.println(removeDuplicates(personeller));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       WordCounter kelimesayaci = new WordCounter();
        System.out.println(kelimesayaci);


    }
    public static List<Employee> findDuplicates(List<Employee> personeller) {
        List<Employee> tekrarlanan = new LinkedList<>();

        for (int i = 0; i < personeller.size(); i++) {
            for (int j = i + 1; j < personeller.size(); j++) {
                if (personeller.get(i).getId() == personeller.get(j).getId()) {
                    Employee e = personeller.get(i);
                    if (!tekrarlanan.contains(e)) {
                        tekrarlanan.add(e);
                    }
                }
            }
        }

        return tekrarlanan;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> personeller) {
        Map<Integer, Employee>  tekrarlanmayanlar = new HashMap<>();

        for (int i =0; i<personeller.size();i++) {
            tekrarlanmayanlar.put(personeller.get(i).getId(), personeller.get(i));
        }
        return tekrarlanmayanlar;
    }

    public static List<Employee> removeDuplicates(List<Employee> personeller) {
        List<Employee> tekrarsiz = new LinkedList<>();

        for (int i = 0; i < personeller.size(); i++) {
            boolean duplicate = false;
            for (int j = 0; j < personeller.size(); j++) {
                if (i != j && personeller.get(i).getId() == personeller.get(j).getId()) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate && !tekrarsiz.contains(personeller.get(i))) {
                tekrarsiz.add(personeller.get(i));
            }
        }
        return tekrarsiz;
    }
}