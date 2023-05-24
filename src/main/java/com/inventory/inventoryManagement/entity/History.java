package com.inventory.inventoryManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String operation; // Operation type: "ADD", "REMOVE", "UPDATE", "DELETE"

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDateTime date;
}
