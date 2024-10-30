package com.hbvk.jep473;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Tests for [JEP 473](https://openjdk.org/jeps/473): Stream Gatherers (Second Preview).
///
/// Functionally, there seem to be no differences between [JEP 461](https://openjdk.org/jeps/461) (first preview)
/// and [JEP 473](https://openjdk.org/jeps/473) (second preview).
/// The tests below are the same as the [Jep461GathererTest](https://github.com/hbvk/java22/blob/master/src/test/java/com/hbvk/jep461/Jep461GathererTest.java)
/// that was included in my included in my [Java 22 test](https://github.com/hbvk/java22).
@SuppressWarnings("preview")
class Jep473GathererTest {

    /// The same test was also included in my [Java 22 test](https://github.com/hbvk/java22).
    @Test
    void testScanPredefinedGatherer() {
        // example from javadoc in Gatherers
        List<String> numberStrings = Stream
                .of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .gather(Gatherers.scan(() -> "", (string, number) -> string + number))
                .toList();
        assertEquals(
                List.of("1", "12", "123", "1234", "12345", "123456", "1234567", "12345678", "123456789", "1234567890"),
                numberStrings);
    }

    /// Implementation of an example from in [JEP 461](https://openjdk.org/jeps/461).
    ///
    /// The same test was also included in my [Java 22 test](https://github.com/hbvk/java22).
    @Test
    void testDistinctByCustomGatherer() {
        var result = Stream.of("foo", "bar", "baz", "quux")
                .gather(distinctBy(String::length))
                .toList();
        assertEquals(2, result.size());
    }

    static <T, A> Gatherer<T, ?, T> distinctBy(Function<? super T, ? extends A> classifier) {
        final Gatherer.Integrator<HashMap<A, List<T>>, T, T> integrator = (state, element, downstream) -> {
            A apply = classifier.apply(element);
            state.computeIfAbsent(apply, _ -> new ArrayList<>()).add(element);
            if (state.get(apply).size() == 1) {
                downstream.push(element);
            }
            return true;
        };
        return Gatherer.ofSequential(HashMap::new, integrator);
    }

}
