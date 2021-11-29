package com.example.SE.domain

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name="Timetable")
data class Timetable(
        @JoinColumn(name = "Tno") var tno: Long,
        @JoinColumn(name = "Mno") var mno: Long,
        @Id @Column(name = "TimeNo") var timeNo: Long,
        var sno: Long,
        var tdate: LocalDate,
        var ttime: LocalTime,
        var ReSeat: Int
)