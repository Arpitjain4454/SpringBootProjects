package com.arpit.studentPortal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.hibernate.annotations.BatchSize;

import org.springframework.validation.annotation.Validated;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Age is mandatory")
    @Min(value = 18, message = "Age should not be less than 18")
    private Integer age;

    @NotNull(message = "Phone number is mandatory")
    @Pattern(regexp = "\\d{10}", message = "Phone number should be 10 digits")
    private String phoneNumber;

    @NotNull(message = "Branch is mandatory")
    private String branch;

    @NotNull(message = "Department is mandatory")
    private String department;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "student")
    private List<Book> books = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    @OneToOne(mappedBy = "student")
    private Laptop laptop;

}

