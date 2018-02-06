package com.github.keratonjava.rxjava.$05_Operators;

import io.reactivex.Observable;

import static com.github.keratonjava.rxjava.Comments.$;

public class OperatorsTransformationMain {


    public static void  main(String... args) {

        $("Map operators");
        Observable.range(1, 10)
                .map(i -> i * 2)
                .subscribe(System.out::println);

        $("Scan operators");
        Observable.range(1, 10)
                .scan((i, j) -> i + j)
                .subscribe(System.out::println);

        $("TODO What is scan do ?");
        $("TODO Pick an transformer operator and do some test");

    }
}
