package com.example.se.domain

import javax.persistence.*

@Entity
@Table(name="Theater")
data class Theater(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Tno")
        var Tno: Long? = null,
        var TheaterName: String
)