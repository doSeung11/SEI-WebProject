package com.example.SE.domain

import javax.persistence.*

@Entity
@Table(name="Screenroom")
data class Screenroom(
        @Id @Column(name = "Sno") var Sno: Long,
        @Id @JoinColumn(name = "Tno") var Tno: Long
)