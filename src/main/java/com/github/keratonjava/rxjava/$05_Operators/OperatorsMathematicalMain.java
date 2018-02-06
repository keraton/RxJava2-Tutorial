package com.github.keratonjava.rxjava.$05_Operators;

import io.reactivex.Observable;

import static com.github.keratonjava.rxjava.Comments.$;

public class OperatorsMathematicalMain {


    public static void  main(String... args) {

        $("Count operators");
        Observable.range(1, 10)
                    .count()
                    .subscribe(System.out::println);

        Observable.range(1, 10)
                .reduce((x, y) -> x + y )
                .subscribe(System.out::println);

        $("TODO use max, min, sum operators");

    }
}
