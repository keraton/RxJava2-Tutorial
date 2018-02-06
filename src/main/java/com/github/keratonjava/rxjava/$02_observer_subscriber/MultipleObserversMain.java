package com.github.keratonjava.rxjava.$02_observer_subscriber;

import io.reactivex.Observable;

import static com.github.keratonjava.rxjava.Comments.$;

public class MultipleObserversMain {


    public static void  main(String... args) {

        $("What happen when we have multiple observers? ");

        Observable<String> observable = Observable.create(s -> {
            System.out.println("Create");

            s.onNext("Hello");
        });

        // 1
        observable.subscribe(s -> System.out.println("1 " + s));
        // 2
        observable.subscribe(s -> System.out.println("2 " + s));

        $("Cache Operator ");
        Observable observableWithCache = Observable.create(s -> {
            System.out.println("Create");

            s.onNext("Hello");
        }).cache();

        // 1
        observableWithCache.subscribe(s -> System.out.println("1 " + s));
        // 2
        observableWithCache.subscribe(s -> System.out.println("2 " + s));




    }
}
