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
@Table(name = "chat_history")
public class ChatHistory {

    @Id
    @SequenceGenerator(name = "chat_sequence",
            sequenceName = "chat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "chat_sequence"
    )
    @Column(name = "chat-id")
    private int chatId;
    @JoinColumn(name = "to_user_id")
    @ManyToOne
    private Users to;

    @JoinColumn(name = "from_user_id")
    @ManyToOne
    private Users from;
    private String message;

    @Column(name = "created_date")
    private Timestamp createDate;
    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;

}
