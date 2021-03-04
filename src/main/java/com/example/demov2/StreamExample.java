package com.example.demov2;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.setCreateDate(new Date("01/01/2021"));
        customer1.setName("1");
        Customer customer2 = new Customer();
        customer2.setCreateDate(new Date("03/01/2021"));
        customer2.setName("2");
        Customer customer3 = new Customer();
        customer3.setCreateDate(new Date("01/03/2021"));
        customer3.setName("3");
        Customer customer4 = new Customer();
        customer4.setCreateDate(new Date("11/03/2021"));
        customer4.setName("4");
        Customer customer5 = new Customer();
        customer5.setCreateDate(new Date("01/07/2021"));
        customer5.setName("5");
        Customer customer6 = new Customer();
        customer6.setCreateDate(new Date("07/07/2021"));
        customer6.setName("6");
        Customer customer7 = new Customer();
        customer7.setCreateDate(new Date("01/11/2021"));
        customer7.setName("7");
        List<Customer> lst = new ArrayList<>();
        lst.add(customer1);
        lst.add(customer2);
        lst.add(customer3);
        lst.add(customer4);
        lst.add(customer5);
        lst.add(customer6);
        lst.add(customer7);

//        ListMultimap<Date, Customer> list = ArrayListMultimap.create();
//        for (Customer c : lst) {
//            list.put(c.getCreateDate(), c);
//        }
//        System.out.println(list.toString());


        Map<String, List<Customer>> moviesGenMap = lst.stream()
                .collect(Collectors.groupingBy(date -> convert(date.getCreateDate())
                        , Collectors.mapping(e -> e, Collectors.toList())));
        System.out.println(new Gson().toJson(moviesGenMap));

//        for (Map.Entry<Date, List<Customer>> entry : moviesGenMap.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
//        }

    }

    private static String convert(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
        return dateFormat.format(date);
    }
}
