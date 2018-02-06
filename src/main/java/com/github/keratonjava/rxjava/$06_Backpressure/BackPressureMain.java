package com.github.keratonjava.rxjava.$06_Backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.github.keratonjava.rxjava.Comments.$;

public class BackPressureMain {


    public static void  main(String... args) throws InterruptedException {
        $("How to cancel Flowable ");

//        Flowable.create((FlowableOnSubscribe<String>) flowableEmitter -> {
//            new Thread(
//                    () -> {
//                        int i = 0;
//                        while (! flowableEmitter.isCancelled()) {
//                            System.out.println("Emit ");
//                            flowableEmitter.onNext(Integer.toString(i++));
//
//                            try {
//                                TimeUnit.SECONDS.sleep(1);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//            ) .start();
//
//        }, BackpressureStrategy.BUFFER)
//                .subscribe(new Subscriber<String>() {
//
//                    public Subscription subscription;
//                    int counter = 0;
//
//                    @Override
//                    public void onSubscribe(Subscription subscription) {
//                        this.subscription = subscription;
//                        subscription.request(1);
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext " +s);
//                        if (counter == 1) {
//                            System.out.println("Cancelled");
//                            subscription.cancel();
//                        }
//                        else {
//                            subscription.request(1);
//                        }
//                        counter++;
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.out.println("Completed");
//                    }
//                });

        $("Back pressure strategy Buffer ");
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


        Flowable.create((FlowableOnSubscribe<String>) flowableEmitter -> {
            new Thread(
                    () -> {
                        int i = 0;
                        while (!flowableEmitter.isCancelled()) {
                            int s = i++;
                            System.out.println("Emmit " +s);
                            flowableEmitter.onNext(Integer.toString(s));

                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ) .start();

        }, BackpressureStrategy.BUFFER)
                .subscribe(new Subscriber<String>() {

                    public Subscription subscription;
                    int counter = 0;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(1);
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext " +s);
                        if (counter == 1) {
                            System.out.println("Delayed");

                            // Wait one second before call the next
                            scheduler.schedule(() -> {
                                System.out.println("Request");

                                subscription.request(1);

                            }, 2, TimeUnit.SECONDS);
                        }
                        else {
                            subscription.request(1);
                        }
                        counter++;
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });


        //$("TODO Back pressure strategy Drop ");


        //$("TODO Back pressure strategy Latest ");

        TimeUnit.HOURS.sleep(1);
    }
}
