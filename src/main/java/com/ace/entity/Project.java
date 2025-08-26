package com.ace.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Project extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String title;
    public String description;
    @ElementCollection
    public List<String> techStack;
    public String status;
    public LocalDateTime createdAt;
    public LocalDateTime dueDate;

}
