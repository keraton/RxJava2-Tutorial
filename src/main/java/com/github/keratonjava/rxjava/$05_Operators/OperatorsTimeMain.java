package com.github.keratonjava.rxjava.$05_Operators;

import io.reactivex.Observable;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.github.keratonjava.rxjava.Comments.$;

public class OperatorsTimeMain {


    public static void main(String... args) throws InterruptedException {

        $("Timer");
        Observable
                .timer(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);


        TimeUnit.SECONDS.sleep(5);

        $("Interval");
        Observable
                .interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(10);

        $("TODO Debounce only emit an item from an Observable if a particular timespan has passed without it emitting another item");

//        Observable
//                .create(s -> new Thread(() -> {
//                            String end = null;
//
//                            while (!"end".equals(end)) {
//                                Scanner in = new Scanner(System.in);
//                                String next = in.next();
//                                s.onNext(next);
//                                end = next;
//
//                            }
//                        }).start()
//                )
//
//                //.debounce(1, TimeUnit.SECONDS)
//                .subscribe(s -> System.out.println("debounce " + s));
//
//        System.out.println("Start");
//
//        TimeUnit.HOURS.sleep(1);
    }
}
