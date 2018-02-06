package com.github.keratonjava.rxjava.$05_Operators;

import io.reactivex.Observable;

import static com.github.keratonjava.rxjava.Comments.$;

public class OperatorsCompositionMain {


    public static void  main(String... args) {

        $("Merge with operators");
        Observable<Integer> obs1 = Observable.just(1, 2, 3);
        Observable<Integer> obs2 = Observable.just(2, 4, 6);

        obs1.mergeWith(obs2)
                .subscribe(System.out::println);


    }
}
