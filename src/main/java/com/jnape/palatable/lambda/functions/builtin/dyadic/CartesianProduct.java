package com.jnape.palatable.lambda.functions.builtin.dyadic;

import com.jnape.palatable.lambda.functions.DyadicFunction;
import com.jnape.palatable.lambda.functions.MonadicFunction;
import com.jnape.palatable.lambda.iterators.CombinatorialIterator;
import com.jnape.palatable.lambda.tuples.Tuple2;

public final class CartesianProduct<A, B> implements DyadicFunction<Iterable<A>, Iterable<B>, Iterable<Tuple2<A, B>>> {

    @Override
    public final Iterable<Tuple2<A, B>> apply(final Iterable<A> as, final Iterable<B> bs) {
        return () -> new CombinatorialIterator<>(as.iterator(), bs.iterator());
    }

    public static <A, B> CartesianProduct<A, B> cartesianProduct() {
        return new CartesianProduct<>();
    }

    public static <A, B> MonadicFunction<Iterable<B>, Iterable<Tuple2<A, B>>> cartesianProduct(Iterable<A> as) {
        return CartesianProduct.<A, B>cartesianProduct().apply(as);
    }

    public static <A, B> Iterable<Tuple2<A, B>> cartesianProduct(final Iterable<A> as, final Iterable<B> bs) {
        return CartesianProduct.<A, B>cartesianProduct(as).apply(bs);
    }
}