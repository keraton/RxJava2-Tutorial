package com.github.keratonjava.rxjava.$01_observable;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

import static com.github.keratonjava.rxjava.Comments.$;

public class HotColdObservable {

    public static void main(String... args) throws InterruptedException {
        $("Cold Observable "); // Lazy

//        Observable.range(1, 1_000_000)
//                .observeOn(Schedulers.computation())
//                .subscribe(ComputeFunction::compute);
//
//        TimeUnit.HOURS.sleep(1);


        $("Hot Observable "); // A hot Observable begins generating items and emits them immediately when they are created

        PublishSubject<String> source = PublishSubject.create();

        source
              .observeOn(Schedulers.computation(), false, 1)
              .subscribe(ComputeFunction::compute, Throwable::printStackTrace);


        new Thread(() -> {
                int i = 0;

                while (true) {
                    try {
                        //System.out.println("Emit ");
                        source.onNext("Count "+i++);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }).start();

        TimeUnit.HOURS.sleep(1);

    }

    static class ComputeFunction {
        public static void compute(String v) {
            try {
                System.out.println("compute integer v: " + v);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
