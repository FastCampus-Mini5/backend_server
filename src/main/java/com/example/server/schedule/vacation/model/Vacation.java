package com.example.server.schedule.vacation.model;

import com.example.server.schedule.Status;
import com.example.server.schedule.vacation.enums.Reason;
import com.example.server.user.model.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "vacation_tb")
@Entity
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Reason reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Id
    @Column(nullable = false)
    private Timestamp startDate;

    @Column(nullable = false)
    private Timestamp endDate;

    private Timestamp approvalDate;

    @CreationTimestamp
    private Timestamp createdDate;

    @PrePersist
    protected void onCreate() {
        status = Status.PENDING;
    }
}