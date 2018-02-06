Observable (ElasticSearch) : Flowable
	|
	 .. onNext(), onError(), onComplete()
	|
	—> Push —> Observer
				  |
				(Cached)
				  |
				(Operator : filter, map, reduce)
				  |
				 —> Subscriber
						—> Observable (MongoDB/Redis) : Single
									|
									—> Push —> Observer
												|
												—> Subscriber
														—> Observable (Slack) : Completable
				 —> Subscriber :: just log

Non blocking !!

Not in the program
——————————
Maybe (Return Single or Zero)
Observable (UI Based)

Reactive X
RxJava : java implementation of reactiveX

Observable Stream
Stream =>  Sequence Date/Events.
Observable => Emit element, error or termination state.

Design Pattern
Iterator
Observer
But asynchrone and undefined

RxJava
Observable/Flowable : the publisher, the one who push the data
Observer/Subscriber
Operator

But in 2.x Observer is used to subscribe to an Observable, and Subscriber is used to subscribe to a Flowable. And if you want to be able to unsubscribe, you need to use ResourceObserver and ResourceSubscriber respectively.



Observable
The source the data (emit the data)
Example : Observable.just

Observer
Consume the data
The interface has three methods : onNext, onError, onCompleted
Demo

Subscriber (Rx1) / Flowable (Rx2) (??? to verify)
+ Can have onSubscribe(Disposable) ; toDispose
Cancellation process : backpresure
Demo

Hot Cold Observable
Hot : emit directly
Cold : Wait for a subscriber
Demo

Creating Observable
just() : emit array or single items
defer() : lazy to create observable
empty() : doesn’t emit any item
never() : never emit any item (testing purpose)
error() : emit error directly.
create() : Custom observable

Transform Sequence to Observable
fromIterable()
fromArray()
fromCallable()
fromFuture()

Infinite Iength
Interval()
range()
timer()

Type of observable
Observable<T> : emit 0 - n item
Single<T> : emit single item
Flowable<T> : emit 0 - n item with backpresure, more than 10 000 elements
Maybe<T> : 0 or 1 item
Completable : never return a value

Backpresure strategy
BUFFER
DROP
ERROR
LATEST
MISSING

Cache operator
Cache before emit
Be careful of memory

Disposable interface/implementation
cancel()
request()
dispose()

Subject
Both Observer/Observable
AsyncSubject
BehaviorSubject
ReplaySubject
PublishSubject

Operators
Observable creation operators
Operators for transforming Observable
Observable filtering operators
Observable creation operator by combining two Observables
Error handling operators
Utility operators
Conditional operators
Mathematical and aggregate operators
Backpressure operators
Connectable observable operators
Conversion operators

Operator examples
buffer()
flatMap()
groupBy()
map()
scan()  … like reduce
window()
filter()
debounce()
distinct()
distinctUntilChanged()
elementAt()
first()
never()
empty()
last()
ignore()
sample()
skip()
skipLast()
take()
takeLast()

Combining Observables
merge()
combineLatest()
startWith()
and()
then()
when()
switchIfEmpty()
zip()
join()

Conditional Operators
all()
amb()
contains()
defaultIfEmpty()
sequenceEqual()
takeWhile()

Mathematical operator
average()
concat()
count()
max()
min()
reduce()
sum()

And others
...





