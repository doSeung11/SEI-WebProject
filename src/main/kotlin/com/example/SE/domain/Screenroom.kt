package com.example.SE.domain

import javax.persistence.*

@Entity
@Table(name="Screenroom")
data class Screenroom(
        var Tno: Long,
        @Id @Column(name = "Sno") var Sno: Long,
        var Seat: Long
)