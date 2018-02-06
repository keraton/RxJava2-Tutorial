package com.github.keratonjava.rxjava.$03_create_observable;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

import static com.github.keratonjava.rxjava.Comments.$;

public class CreateObservableMain {


    public static void  main(String... args) {
        $("We have seen create, just, defer");

        $("Creation operators");
        Observable.never().subscribe(System.out::println);

        Observable.error(new Exception()).subscribe(System.out::println,
                                     s -> System.out.println("Error" + s));

        Observable.empty().subscribe(System.out::println);

        $("Transform from sequence");
        Observable.fromArray("Hello", "World").subscribe(System.out::println);

        List<String> list = Arrays.asList("Hello", "World");
        Observable.fromIterable(list).subscribe(System.out::println);

        $("TODO Create from Callable/Future");


    }
}
