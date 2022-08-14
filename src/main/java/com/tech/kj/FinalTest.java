package com.tech.kj;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FinalTest {
    public static void main(String[] args) {
        //1,1,2,2,2,3,4,4
        //1-2
        //2-3
        //3-1
        //4-2
        List<Integer> integers = new ArrayList();
        integers.add(1);
        integers.add(1);
        integers.add(2);
        integers.add(2);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(4);

         int min = integers.stream().min((e1,e2)-> e1-e2).orElseThrow(NoSuchElementException::new);
        int max = integers.stream().max((e1,e2)-> e1-e2).orElseThrow(NoSuchElementException::new);
        int max2 = integers.stream().max(Comparator.comparing(Integer:: intValue)).orElseThrow(NoSuchElementException::new);
        System.out.println(max2);

        Map<Integer,Integer> frq = new HashMap<>();
        integers.stream().peek(item-> frq.put(item,1))
                .peek(item-> {
                    if(frq.get(item) != null ){
                        int c = frq.get(item);
                        frq.put(item, ++c);
                        return;
                    }
                    frq.put(item, 1);
                })
                .collect(Collectors.toList());

        System.out.println(frq);

        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream() .mapToInt((x) -> x) .summaryStatistics();


        System.out.println(stats);

        Map<Integer, Long> result;
        result = integers.stream().collect(Collectors.groupingBy(each->identity(each), Collectors.counting())
                 );

        System.out.println(result);

    }
    public static int identity(int item){
        return item;
    }

    public static int counting(){
        /*int counter = 0;
        for(int each: arr){
            if(each==item){
                counter++;
            }
        }*/
        return -1;
    }

}

