package com.pavan;

import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> areaList;

    public static void main(String[] args) throws Exception {
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    initializeDefaultList();
                    break;
                case 2:
                    sortArrayList();
                    break;
                case 3:
                    sortCustomListObjects();
                    break;
                case 4:
                    compareArrayList();
                    break;
                case 10:
                    quit = true;
                    break;
                default:
                    System.out.println("Illegal Input");
                    break;
            }
        }
    }

    private static void compareArrayList() {
        List<String> list1 = new ArrayList<>(Arrays.asList("foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon",
                "Magarpatta", "Hinjawadi", "ShivajiNagar", "Wakad", "Hadapsar", "Hinjawadi", "BalewadiHighStreet", "Yerawada", "Bavdhan",
                "KalyaniNagar", "Baner", "KoregaonPark", "PimpleSaudagar"));


        List<String> list2 = new ArrayList<>(Arrays.asList("PimpleSaudagar", "foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon",
                "Magarpatta", "Hinjawadi", "ShivajiNagar", "Wakad", "Hadapsar", "Hinjawadi", "BalewadiHighStreet", "Yerawada", "Bavdhan",
                "KalyaniNagar", "Baner"));


        System.out.println();
        System.out.println("isEqual = " + list1.equals(list2));
        System.out.println();
        System.out.println(list1);
        System.out.println(list2);

        System.out.println();
        System.out.println("size of list 1 = " +list1.size());
        System.out.println("size of list 2 = " +list2.size());
        System.out.println("Remove additional element from list 1 ");

        List<String> list3 = new ArrayList<>(list1);
        // list3.removeAll(list2);
        System.out.println("size of list 3 = " +list3.size());
        System.out.println("size of list 2 = " +list2.size());
        list3.retainAll(list2);
        System.out.println(list3);

        System.out.println("size of list 3 = " +list3.size());
        System.out.println("size of list 2 = " +list2.size());

    }

    private static void sortCustomListObjects() {
        Employee e1 = new Employee(10, "Pavan",  26);
        Employee e2 = new Employee(15, "Vinayak",  27);
        Employee e3 = new Employee(70, "Sameer",  26);
        Employee e4 = new Employee(5, "Sauarabh",  28);
        Employee e5 = new Employee(13, "Satyam",  25);
        Employee e6 = new Employee(52, "SATISH",  85);
        Employee e7 = new Employee(2, "ABC",  2);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);

        System.out.println(employees);

        Collections.sort(employees);

        System.out.println();
        System.out.println("Using Comparable : (compareTo(Object o)) -> Default Sorting by Id");
        System.out.println(employees);

        System.out.println();

        System.out.println("Using Comparator : NameComparator ->");
        Collections.sort(employees, new NameComparator());
        System.out.println(employees);


        System.out.println();

        System.out.println("Using Java 8 Age Sort Comparator.comparing method : ");

        employees.sort(Comparator.comparing(employee -> employee.getAge()));
        System.out.println(employees);

        System.out.println();
        System.out.println("Sorting By Name Java 8");
        employees.sort(Comparator.comparing(e -> e.getName().toLowerCase()));
        System.out.println(employees);



    }

    private static void initializeDefaultList() throws Exception {
        String[] stringArray = {"foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon", "Magarpatta",
                "Hinjawadi", "Shivaji Nagar", "Wakad", "Hadapsar", "Hinjawadi", "Balewadi High Street", "Yerawada", "Bavdhan",
                "Kalyani Nagar", "Baner", "Koregaon Park", "Pimple Saudagar"};


        areaList = new ArrayList<>(Arrays.asList(stringArray));
        System.out.println("Size of Default ArrayList :" + areaList.size());
        System.out.println(areaList);


        System.out.println("ArrayList areaList.size() : " + areaList.size());

        System.out.println("List without generic type given will be considered as ArrayList of Objects");
        System.out.println(" List list = new ArrayList<>(); ");
        List list = new ArrayList<>();
        list.add(1);
        list.add("1");

        System.out.println(list.toString()); // [1, 1]

        System.out.println("list.get(0) + list.get(1) = "+ list.get(0) + list.get(1)); // = 11
        System.out.println("list.get(0).getClass() => " + list.get(0).getClass()); // class java.lang.Integer
        System.out.println("list.get(1).getClass() => " + list.get(1).getClass()); // class java.lang.String


        System.out.println("Java 1.7 + ArrayList Default Capacity changes from 10 to 0 Lazy Initialization");

        ArrayList al = new ArrayList();
        System.out.print("No element : "); getCapacity(al); // No element : Size:  0, Capacity:  0
        al.add( "Pavan" );
        System.out.print("1 element : ");  getCapacity(al); // 1 element : Size:  1, Capacity: 10

        al.add("2");
        al.add("3");
        al.add("4");
        al.add("5");
        System.out.print("5 element : ");  getCapacity(al); // 5 element : Size:  5, Capacity: 10

        al.add("6");
        al.add("7");
        al.add("8");
        al.add("9");
        System.out.print("9 element : ");  getCapacity(al); // 9 element : Size:  9, Capacity: 10
        al.add("10");
        System.out.print("10 element : ");  getCapacity(al); // 10 element : Size: 10, Capacity: 10
        al.add("11");
        System.out.print("11 element : ");  getCapacity(al); // 11 element : Size: 11, Capacity: 15


    }

    private static void getCapacity(ArrayList<?> l) throws  Exception{
        Field dataField = ArrayList.class.getDeclaredField( "elementData" );
        dataField.setAccessible( true );
        System.out.format( "Size: %2d, Capacity: %2d%n", l.size(), ( (Object[]) dataField.get( l ) ).length );
    }

    public static void sortArrayList() {

        //List<String> areaList1 = new ArrayList<>(areaList);

        List<String> areaList1 = new ArrayList<>(Arrays.asList("foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon",
                "Magarpatta", "Hinjawadi", "ShivajiNagar", "Wakad", "Hadapsar", "Hinjawadi", "BalewadiHighStreet", "Yerawada", "Bavdhan",
                "KalyaniNagar", "Baner", "KoregaonPark", "PimpleSaudagar"));

        List<String> areaList2 = new ArrayList<>(areaList1);

        List<String> areaList3 = new ArrayList<>(areaList1);
        List<String> sortedList1 = new ArrayList<>(areaList1);


        //Sort using List.sort() method
        System.out.println("Sort using List.sort() method");
        areaList1.sort(Comparator.comparing(String::toString));
        System.out.println(areaList1);

        //areaList1.sort(Comparator.comparing(String::toString).reversed());
        //System.out.println(areaList1);

        System.out.println();
        // Sort Using Collections.sort() method
        System.out.println("Sort Using Collections.sort() method gives wrong results when list contains UpperCase and LowerCase strings");
        Collections.sort(areaList2);

        System.out.println();

        System.out.println("Use Collections.sort(list, String.CASE_INSENSITIVE_ORDER) method to sort list containing UpperCase and LowerCase strings");
        Collections.sort(areaList2, String.CASE_INSENSITIVE_ORDER);
        System.out.println(areaList2);


        System.out.println();
        System.out.println("Sort using Java 8");
        List<String> sortedList = areaList3.stream().sorted(Comparator.comparing(String::toString)).collect(Collectors.toList());
        System.out.println(sortedList);



        sortedList1.sort((s1, s2)->s1.compareToIgnoreCase(s2));
        System.out.println(sortedList1);


    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To Initialize ArrayList with Default Values");
        System.out.println("\t 2 - To sort ArrayList");
        System.out.println("\t 3 - To sort Custom Employee ArrayList");
        System.out.println("\t 4 - To compare ArrayList");
        System.out.println("\t 10 - To quite an application");
    }
}

