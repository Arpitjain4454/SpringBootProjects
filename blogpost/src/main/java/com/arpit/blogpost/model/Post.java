package com.arpit.blogpost.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "update_date", nullable = true)
    private Timestamp updateDate;

    @Column(name = "post_data")
    private String postData;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
