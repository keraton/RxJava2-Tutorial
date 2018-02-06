package com.github.keratonjava.rxjava.$01_observable;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

import static com.github.keratonjava.rxjava.Comments.$;

public class ObservableMain {

    public static void main(String... args) {

        $("Only with Just");
        Observable.just("Hello", "World")
                    .subscribe(System.out::println);

        $("Lazy /defer");
        Observable<String> observable = Observable.defer(() -> {
            System.out.println("Lazy invocation");
            return Observable.just("Hello");
        });

        System.out.println("Me first");
        observable.subscribe(System.out::println);

        $("Create basic");
        Observable.create( observer -> {
            observer.onNext("Hello");
            observer.onNext("World");
            observer.onComplete();
        })
        .subscribe(System.out::println);

        $("TODO use basic to create observable from this list");
        List<String> list = Arrays.asList("Alpha", "Beta", "Gamma");


        $("TODO use on Error to stop when the Beta");


    }
}
