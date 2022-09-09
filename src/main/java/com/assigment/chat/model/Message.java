package com.assigment.chat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;
    @Column(name = "message", nullable = false)
    private String message;
    @Column(name = "sent_date_time", nullable = false)
    private LocalDateTime sentDateTime;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}
