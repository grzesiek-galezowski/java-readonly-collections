# Java readonly collection

* Lightweight readonly collection wrappers for Java. Inspired by read-only interfaces from C#.

## Read-only vs unmodifiable

* Unmodifiable collections contain modifying operations, but throw exceptions when they are invoked. Read-only collections do not contain modifying operations.

## Read-only vs immutable (e.g. Vavr)

* Immutable collections contain methods such as `add`, but instead of modifying the data, they return new collection. Read-only collections do not directly contain such operations (although if someone wants, it can be achieved with streams)
* Immutable collections have the guarantee that they cannot change. A read-only collection is merely a view on a collection that can be changed by whoever holds the non-read-only reference.

## Usage example

```java
List<Integer> list = ...;
someone.doSomething(readonly(list));
```

