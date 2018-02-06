package com.github.keratonjava.rxjava.$04_observable_types;

import io.reactivex.Single;

import static com.github.keratonjava.rxjava.Comments.$;

public class ObervableTypeMain {


    public static void  main(String... args) {

        $("We have seen Observable and Flowable");
        $("Both emit iterable");
        $("Single : Emit once");
        Single.just("I'm Single").subscribe(System.out::println);

        $("TODO Create Single from operator create");
        $("TODO Maybe : Emit once/nothing");

        $("TODO Completable : Emit nothing but to signal of something");
    }
}
