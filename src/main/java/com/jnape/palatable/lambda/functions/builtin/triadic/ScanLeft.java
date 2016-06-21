package com.jnape.palatable.lambda.functions.builtin.triadic;

import com.jnape.palatable.lambda.functions.DyadicFunction;
import com.jnape.palatable.lambda.functions.MonadicFunction;
import com.jnape.palatable.lambda.functions.TriadicFunction;
import com.jnape.palatable.lambda.iterators.ScanningIterator;

import static java.util.Arrays.asList;

/**
 * Given an <code>Iterable</code> of <code>A</code>s, a starting value <code>B</code>, and a <code>{@link
 * DyadicFunction}&lt;B, A, B&gt;</code>, iteratively accumulate over the <code>Iterable</code>, collecting each
 * function application result, finally returning an <code>Iterable</code> of all the results. Note that, as the name
 * implies, this function accumulates from left to right, such that <code>scanLeft(f, 0, asList(1,2,3,4,5))</code> is
 * evaluated as 0, f(0, 1), f(f(0, 1), 2), f(f(f(0, 1), 2), 3), f(f(f(f(0, 1), 2), 3), 4), f(f(f(f(f(0, 1), 2), 3), 4),
 * 5).
 *
 * @param <A> The Iterable element type
 * @param <B> The accumulation type
 * @see FoldLeft
 */
public final class ScanLeft<A, B> implements TriadicFunction<DyadicFunction<? super B, ? super A, ? extends B>, B, Iterable<A>, Iterable<B>> {

    @Override
    public Iterable<B> apply(DyadicFunction<? super B, ? super A, ? extends B> fn, B b, Iterable<A> as) {
        return () -> new ScanningIterator<>(fn, b, as.iterator());
    }

    public static <A, B> ScanLeft<A, B> scanLeft() {
        return new ScanLeft<>();
    }

    public static <A, B> DyadicFunction<B, Iterable<A>, Iterable<B>> scanLeft(
            DyadicFunction<? super B, ? super A, ? extends B> fn) {
        return ScanLeft.<A, B>scanLeft().apply(fn);
    }

    public static <A, B> MonadicFunction<Iterable<A>, Iterable<B>> scanLeft(
            DyadicFunction<? super B, ? super A, ? extends B> fn, B b) {
        return ScanLeft.<A, B>scanLeft(fn).apply(b);
    }

    public static <A, B> Iterable<B> scanLeft(DyadicFunction<? super B, ? super A, ? extends B> fn, B b,
                                              Iterable<A> as) {
        return ScanLeft.<A, B>scanLeft(fn, b).apply(as);
    }

    public static void main(String[] args) {
        scanLeft((acc, x) -> "f(" + acc + ", " + x + ")", "0", asList(1, 2, 3, 4, 5)).forEach(System.out::println);
    }
}