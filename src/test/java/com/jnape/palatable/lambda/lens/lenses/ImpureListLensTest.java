package com.jnape.palatable.lambda.lens.lenses;

import com.jnape.palatable.lambda.lens.Lens;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.jnape.palatable.lambda.lens.functions.Set.set;
import static com.jnape.palatable.lambda.lens.functions.View.view;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

public class ImpureListLensTest {

    private List<String> xs;

    @Before
    public void setUp() throws Exception {
        xs = new ArrayList<String>() {{
            add("foo");
            add("bar");
            add("baz");
        }};
    }

    @Test
    public void atFocusesOnElementAtIndex() {
        Lens.Simple<List<String>, String> at0 = ImpureListLens.at(0);

        assertEquals("foo", view(at0, xs));
        assertEquals(null, view(at0, emptyList()));
        assertEquals(asList("quux", "bar", "baz"), set(at0, "quux", xs));
        assertEquals(emptyList(), set(at0, "quux", emptyList()));
    }
}