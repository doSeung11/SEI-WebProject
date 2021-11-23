package com.example.se.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="Movie")
data class Movie(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Mno")
        var Mno: Long? = null,
        var MovieName:String,
        var ReleaseDate: LocalDate,
        @Column(length = 500)
        var Description: String,
        var Genre: String,
        var Age: Int,
        var RunningTime: Int,
        @Column(nullable = true)
        var Poster: String? = null,
        var Video: String

)
