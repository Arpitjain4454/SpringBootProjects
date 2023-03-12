package com.arpit.messengerApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_users")
public class Users {
    @Id
    @SequenceGenerator(name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "email_id",
            nullable = false
    )
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "gender")
    private String gender;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "updated_date")
    private Timestamp updatedDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;

}