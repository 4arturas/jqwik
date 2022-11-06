package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Project
{
    String name;
    List<User> members;
    public Project(String name)
    {
        assert name != null && name.length() > 0;
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember( User member )
    {
        assert member != null;
        assert this.members != null;
        assert this.members.size() <= 10;
        if ( members.size() >= 10 )
            throw new RuntimeException("Maximum number of 10 members already reached");

        Stream<User> l = this.members.stream().filter(m -> m.email.equals(member.email));
        if (l.findAny().isPresent())
            throw new RuntimeException("Member with email " + member.email + " already exists");

        this.members.add(member);
    }

    public boolean isMember( User user )
    {
        List<User> users = members.stream().filter( (u) -> u.email.equals(user.email) ).collect(Collectors.toList());
        assert users.size() > 0;
        return users.size() > 0;
    }

}
