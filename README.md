# RxJava 2

* Reactive Manifesto
    * Event Driven
    * Elastic
    * Resilience
    * Responsive
* Basic
    * Observable
    * Observer
    * Operator
* Push not pull
* Observable
    * just
    * defer
    * create
    * multi-threads
    * Hot-Cold
* Observer / Subscriber
    * Multiple Observer
    * cache
* Create observable
    * Operators
        * just() : emit array or single items
        * defer() : lazy to create observable
        * empty() : doesn’t emit any item
    * Transforming
        * fromIterable()
        * fromArray()
* Observable type
    * Observable
    * Single
    * Flowable
    * Maybe
    * Completable
* Operators
    * Marble diagram
        * http://rxmarbles.com/
    * Rx Operators
        * http://reactivex.io/documentation/operators.html
    * Operator Creational
    * Operator : conditional
    * Operator : transformation
    * Operator : composition
    * Operator : mathematical
* Backpressure
    * Buffer
    * Fail
    * Last
    * First