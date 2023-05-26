package com.inventory.inventoryManagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String operation;

    //@ManyToOne
   // @JoinColumn(name = "product_id", nullable = false)
    private Integer productId;
    @Column(nullable = false)
    private LocalDateTime dateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd:HH:mm")
    public LocalDateTime getCreatedDate() {
        return dateTime;
    }


}
