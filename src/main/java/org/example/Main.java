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
        personeller.add(new Employee(3, "Ayşe", "Demir"));
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
        if (personeller == null) return tekrarlanan;
        for (int i = 0; i < personeller.size(); i++) {
            Employee e1 = personeller.get(i);
            if (e1 == null) continue;
            for (int j = i + 1; j < personeller.size(); j++) {
                Employee e2 = personeller.get(j);
                if (e2 == null) continue;
                if (e1.equals(e2)) {
                    if (!tekrarlanan.contains(e1)) {
                        tekrarlanan.add(e1);
                    }
                    
                }
            }
        }
        return tekrarlanan;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> personeller) {
        Map<Integer, Employee>  tekrarlanmayanlar = new HashMap<>();
        if (personeller == null) return tekrarlanmayanlar;
        for (int i = 0; i < personeller.size(); i++) {
            Employee e = personeller.get(i);
            if (e == null) continue;
            tekrarlanmayanlar.put(e.getId(), e);
        }
        return tekrarlanmayanlar;
    }

    public static List<Employee> removeDuplicates(List<Employee> personeller) {
        List<Employee> tekrarsiz = new LinkedList<>();
        if (personeller == null) return tekrarsiz;
        for (int i = 0; i < personeller.size(); i++) {
            Employee e1 = personeller.get(i);
            if (e1 == null) continue;
            boolean duplicate = false;
            for (int j = 0; j < personeller.size(); j++) {
                if (i != j) {
                    Employee e2 = personeller.get(j);
                    if (e2 == null) continue;
                    if (e1.equals(e2)) {
                        duplicate = true;
                        break;
                    }
                }
            }
            if (!duplicate && !tekrarsiz.contains(e1)) {
                tekrarsiz.add(e1);
            }
        }
        return tekrarsiz;
    }
}