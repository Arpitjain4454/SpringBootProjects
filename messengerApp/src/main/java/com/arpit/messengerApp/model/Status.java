package com.arpit.messengerApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_status")
public class Status {
    @Id
    @SequenceGenerator(name = "status_sequence",
            sequenceName = "status_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "status_sequence"
    )
    @Column(name = "status_id")
    private Long statusId;
    @Column(name = "status_name")
    private String statusName;
    @Column(name = "status_description")
    private String statusDescription;

}
