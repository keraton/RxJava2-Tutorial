package com.github.keratonjava.rxjava.$05_Operators;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

import static com.github.keratonjava.rxjava.Comments.$;

public class OperatorConditionalMain {


    public static void  main(String... args) {
        Observable intObs = Observable.range(0, 100);

        $("TODO Operator : Filter only the even number");
        intObs
            .filter(ints -> true)
            .subscribe(System.out::println);


        $("TODO Operator : Find the first divisible by 3 and 5");



    }
}
