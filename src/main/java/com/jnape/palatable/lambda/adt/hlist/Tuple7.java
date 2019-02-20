package com.jnape.palatable.lambda.adt.hlist;

import com.jnape.palatable.lambda.adt.hlist.HList.HCons;
import com.jnape.palatable.lambda.adt.product.Product7;
import com.jnape.palatable.lambda.functor.Applicative;
import com.jnape.palatable.lambda.functor.Bifunctor;
import com.jnape.palatable.lambda.monad.Monad;
import com.jnape.palatable.lambda.traversable.Traversable;

import java.util.function.Function;

import static com.jnape.palatable.lambda.functions.builtin.fn1.Constantly.constantly;

/**
 * A 7-element tuple product type, implemented as a specialized HList. Supports random access.
 *
 * @param <_1> The first slot element type
 * @param <_2> The second slot element type
 * @param <_3> The third slot element type
 * @param <_4> The fourth slot element type
 * @param <_5> The fifth slot element type
 * @param <_6> The sixth slot element type
 * @param <_7> The seventh slot element type
 * @see Product7
 * @see HList
 * @see SingletonHList
 * @see Tuple2
 * @see Tuple3
 * @see Tuple4
 * @see Tuple5
 * @see Tuple6
 */
public class Tuple7<_1, _2, _3, _4, _5, _6, _7> extends HCons<_1, Tuple6<_2, _3, _4, _5, _6, _7>> implements
        Product7<_1, _2, _3, _4, _5, _6, _7>,
        Monad<_7, Tuple7<_1, _2, _3, _4, _5, _6, ?>>,
        Bifunctor<_6, _7, Tuple7<_1, _2, _3, _4, _5, ?, ?>>,
        Traversable<_7, Tuple7<_1, _2, _3, _4, _5, _6, ?>> {

    private final _1 _1;
    private final _2 _2;
    private final _3 _3;
    private final _4 _4;
    private final _5 _5;
    private final _6 _6;
    private final _7 _7;

    Tuple7(_1 _1, Tuple6<_2, _3, _4, _5, _6, _7> tail) {
        super(_1, tail);
        this._1 = _1;
        _2 = tail._1();
        _3 = tail._2();
        _4 = tail._3();
        _5 = tail._4();
        _6 = tail._5();
        _7 = tail._6();
    }

    @Override
    public <_0> Tuple8<_0, _1, _2, _3, _4, _5, _6, _7> cons(_0 _0) {
        return new Tuple8<>(_0, this);
    }

    @Override
    public _1 _1() {
        return _1;
    }

    @Override
    public _2 _2() {
        return _2;
    }

    @Override
    public _3 _3() {
        return _3;
    }

    @Override
    public _4 _4() {
        return _4;
    }

    @Override
    public _5 _5() {
        return _5;
    }

    @Override
    public _6 _6() {
        return _6;
    }

    @Override
    public _7 _7() {
        return _7;
    }

    @Override
    public Tuple7<_2, _3, _4, _5, _6, _7, _1> rotateL7() {
        return tuple(_2, _3, _4, _5, _6, _7, _1);
    }

    @Override
    public Tuple7<_7, _1, _2, _3, _4, _5, _6> rotateR7() {
        return tuple(_7, _1, _2, _3, _4, _5, _6);
    }

    @Override
    public Tuple7<_2, _3, _4, _5, _6, _1, _7> rotateL6() {
        return tuple(_2, _3, _4, _5, _6, _1, _7);
    }

    @Override
    public Tuple7<_6, _1, _2, _3, _4, _5, _7> rotateR6() {
        return tuple(_6, _1, _2, _3, _4, _5, _7);
    }

    @Override
    public Tuple7<_2, _3, _4, _5, _1, _6, _7> rotateL5() {
        return tuple(_2, _3, _4, _5, _1, _6, _7);
    }

    @Override
    public Tuple7<_5, _1, _2, _3, _4, _6, _7> rotateR5() {
        return tuple(_5, _1, _2, _3, _4, _6, _7);
    }

    @Override
    public Tuple7<_2, _3, _4, _1, _5, _6, _7> rotateL4() {
        return tuple(_2, _3, _4, _1, _5, _6, _7);
    }

    @Override
    public Tuple7<_4, _1, _2, _3, _5, _6, _7> rotateR4() {
        return tuple(_4, _1, _2, _3, _5, _6, _7);
    }

    @Override
    public Tuple7<_2, _3, _1, _4, _5, _6, _7> rotateL3() {
        return tuple(_2, _3, _1, _4, _5, _6, _7);
    }

    @Override
    public Tuple7<_3, _1, _2, _4, _5, _6, _7> rotateR3() {
        return tuple(_3, _1, _2, _4, _5, _6, _7);
    }

    @Override
    public Tuple7<_2, _1, _3, _4, _5, _6, _7> invert() {
        return tuple(_2, _1, _3, _4, _5, _6, _7);
    }

    @Override
    public <_7Prime> Tuple7<_1, _2, _3, _4, _5, _6, _7Prime> fmap(Function<? super _7, ? extends _7Prime> fn) {
        return Monad.super.<_7Prime>fmap(fn).coerce();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <_6Prime> Tuple7<_1, _2, _3, _4, _5, _6Prime, _7> biMapL(Function<? super _6, ? extends _6Prime> fn) {
        return (Tuple7<_1, _2, _3, _4, _5, _6Prime, _7>) Bifunctor.super.biMapL(fn);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <_7Prime> Tuple7<_1, _2, _3, _4, _5, _6, _7Prime> biMapR(Function<? super _7, ? extends _7Prime> fn) {
        return (Tuple7<_1, _2, _3, _4, _5, _6, _7Prime>) Bifunctor.super.biMapR(fn);
    }

    @Override
    public <_6Prime, _7Prime> Tuple7<_1, _2, _3, _4, _5, _6Prime, _7Prime> biMap(
            Function<? super _6, ? extends _6Prime> lFn,
            Function<? super _7, ? extends _7Prime> rFn) {
        return new Tuple7<>(_1(), tail().biMap(lFn, rFn));
    }

    @Override
    public <_7Prime> Tuple7<_1, _2, _3, _4, _5, _6, _7Prime> pure(_7Prime _7Prime) {
        return tuple(_1, _2, _3, _4, _5, _6, _7Prime);
    }

    @Override
    public <_7Prime> Tuple7<_1, _2, _3, _4, _5, _6, _7Prime> zip(
            Applicative<Function<? super _7, ? extends _7Prime>, Tuple7<_1, _2, _3, _4, _5, _6, ?>> appFn) {
        return Monad.super.zip(appFn).coerce();
    }

    @Override
    public <_7Prime> Tuple7<_1, _2, _3, _4, _5, _6, _7Prime> discardL(
            Applicative<_7Prime, Tuple7<_1, _2, _3, _4, _5, _6, ?>> appB) {
        return Monad.super.discardL(appB).coerce();
    }

    @Override
    public <_7Prime> Tuple7<_1, _2, _3, _4, _5, _6, _7> discardR(
            Applicative<_7Prime, Tuple7<_1, _2, _3, _4, _5, _6, ?>> appB) {
        return Monad.super.discardR(appB).coerce();
    }

    @Override
    public <_7Prime> Tuple7<_1, _2, _3, _4, _5, _6, _7Prime> flatMap(
            Function<? super _7, ? extends Monad<_7Prime, Tuple7<_1, _2, _3, _4, _5, _6, ?>>> f) {
        return pure(f.apply(_7).<Tuple7<_1, _2, _3, _4, _5, _6, _7Prime>>coerce()._7());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <_7Prime, App extends Applicative, TravB extends Traversable<_7Prime, Tuple7<_1, _2, _3, _4, _5, _6, ?>>, AppB extends Applicative<_7Prime, App>, AppTrav extends Applicative<TravB, App>> AppTrav traverse(
            Function<? super _7, ? extends AppB> fn, Function<? super TravB, ? extends AppTrav> pure) {
        return fn.apply(_7).fmap(_7Prime -> fmap(constantly(_7Prime))).<TravB>fmap(Applicative::coerce).coerce();
    }

    /**
     * Given a value of type <code>A</code>, produced an instance of this tuple with each slot set to that value.
     *
     * @param a   the value to fill the tuple with
     * @param <A> the value type
     * @return the filled tuple
     * @see Tuple2#fill
     */
    public static <A> Tuple7<A, A, A, A, A, A, A> fill(A a) {
        return tuple(a, a, a, a, a, a, a);
    }
}