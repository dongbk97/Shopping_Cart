package com.example.giohangdemo.test;

import com.example.giohangdemo.domain.Oder;
import com.example.giohangdemo.repository.IOderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    @Autowired
  static  IOderRepository iOderRepository;

    public static void main(String[] args) {
//        HashMap<Integer, String> map = new HashMap<Integer, String>();
//        // add elements to map
//        map.put(1, "Java");
//        map.put(3, "C++");
//        map.put(2, "PHP");
//        map.put(4, "Python");
//        map.put(2, "PHP đã sửa");
//        // show map
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }
//        List<Integer> listPage= IntStream.range(1, 10)
//                .boxed()
//                .collect(Collectors.toList());
//
//
//
//        for (Integer aa:listPage) {
//            System.out.println(aa);
//        }

//        for (int i = 1; i <= listPage.size(); i++) {
//            System.out.println(listPage.get(i));
//        }



//        List<Oder> list=iOderRepository.getOder("dongbk");
//
//
//        list.stream().forEach(x->x.getProduct().getName());


    }

}
