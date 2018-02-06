package com.github.keratonjava.rxjava.$01_observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.concurrent.TimeUnit;

import static com.github.keratonjava.rxjava.Comments.$;

public class ObervableMultiThreads {


    public static void  main(String... args) {
        /**
         * Not allows calling the subscriber’s onNext() method from multiple threads concurrently
         * Violate Rx contract
         * Use different Observable and merge it later (see in the OperatorComposition)
         */

        $("MultiThread");
        Observable obs = Observable.create(
                (ObservableEmitter<Object> observer) -> {
                    Runnable r = () -> {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("Start Emit");

                            observer.onNext(10);
                            observer.onComplete();
                        } catch (InterruptedException e) {

                            observer.onError(e);
                        }
                    };
                    new Thread(r).start();
                });
        System.out.println("Observable created");

        obs.subscribe(System.out::println);
    }
}
