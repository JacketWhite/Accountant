package org.adam.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(generator = "uuid-gen")
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @Type(type = "pg-uuid")
    private UUID id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
