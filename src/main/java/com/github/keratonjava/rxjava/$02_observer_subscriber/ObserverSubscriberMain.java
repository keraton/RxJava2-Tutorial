package com.github.keratonjava.rxjava.$02_observer_subscriber;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import static com.github.keratonjava.rxjava.Comments.$;

public class ObserverSubscriberMain {


    public static void  main(String... args) {

        $("Observer can handle onNext, onComplete, onError");
        Observable.just("Hello", "World")
                .subscribe(s -> System.out.println("onNext " + s),
                           s -> System.out.println("oError " + s),
                           () -> System.out.println("onComplete")
                );

        // Or we can do this way
        Observable.just("Hello", "World")
                .subscribe(new Observer<String>() {

                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        $("Difference between observer and subscriber");

        $("Subscriber cancel");
        // Cancel
        Flowable.just("Hello", "World")
                .subscribe(new Subscriber<String>() {

                    public Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        // I have this
                        this.subscription = subscription;
                        subscription.request(1);
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                        subscription.request(1);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });

        $("TODO Subscriber modify request number");

    }
}
