package org.example;

import net.jqwik.api.Example;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
//import static org.assertj.core.api.Assertions.

public class ExampleBasedTests
{
    @Example
    void squareRootOf16is4()
    {
        Assertions.assertThat(Math.sqrt(16)).isCloseTo(4.0, Offset.offset(0.01) );
    }

    @Example
    boolean add1plus3is4() {
        return (1+3)==4;
    }
}
