package org.example;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.*;
import org.assertj.core.api.Assertions;

import java.util.List;

public class PropertyBasedTests
{
    @Property
    public boolean absoluteValueOfAllNumbersIsPositive( @ForAll @Positive int anInteger) {
        int abs = BagOfCatsUtils.abs(anInteger);
        boolean result = abs > 0;
        return result;
    }

    @Property
    public void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(@ForAll @AlphaChars @NotEmpty String s1, @ForAll @AlphaChars @NotEmpty String s2 )
    {
        String conc = BagOfCatsUtils.concat( s1, s2 );
        Assertions.assertThat(conc.length()).isGreaterThan(s1.length());
        Assertions.assertThat(conc.length()).isGreaterThan(s2.length());
    }

    @Property
    public void uniqueInList(@ForAll @Size(5) List<@IntRange(min=0,max=10) @UniqueElements Integer> aList) {
        Assertions.assertThat(aList).doesNotHaveDuplicates();
        Assertions.assertThat(aList).allMatch(anInt -> anInt >= 0 && anInt <= 10);
    }
}
