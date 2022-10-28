package org.example;

import net.jqwik.api.*;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.NotBlank;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.UniqueElements;
import net.jqwik.web.api.Email;
import org.assertj.core.api.Assertions;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@PropertyDefaults(tries = 1000, shrinking = ShrinkingMode.FULL)
@Tag("integration-test")
//@Disabled("for whatever reason")
public class ProjectManagementTests
{
    @Property(tries = 1000)
//    @Disabled
    void test(
            @ForAll /*@AlphaChars*/ @NotBlank String projectName,
            @ForAll @Size(max = 10) @UniqueElements List<@NotBlank @Email String> email
    ) {
        Project project = new Project(projectName);
        List<User> users  = email.stream().map(User::new).collect(Collectors.toList());
        users.forEach(project::addMember);
    }

    @Property(tries = 3)
    @Disabled
    @Label("MY LABEL")
    void aProperty( @ForAll @AlphaChars String aString) {
        System.out.println(aString);
    }
    @Property
    @Tag("fast")
    @Disabled("some reason 1")
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll  int anInteger )
    {
        return Math.abs(anInteger) >= 0;
    }

    @Property
    @Tag("slow") @Tag("involved")
    @Disabled("some reason 2")
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach( @ForAll String s1, @ForAll String s2 )
    {
        String concat = s1 + s2;
        Assertions.assertThat(concat.length()).isGreaterThan(s1.length());
        Assertions.assertThat(concat.length()).isGreaterThan(s2.length());
    }
}
