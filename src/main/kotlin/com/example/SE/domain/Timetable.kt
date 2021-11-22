package com.example.SE.domain

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name="Timetable")
data class Timetable(
        @Id @JoinColumn(name = "Tno") var Tno: Long,
        @Id @JoinColumn(name = "Mno") var Mno: Long,
        @Id @Column(name = "TimeNo") var TimeNo: Long,
        @JoinColumn(name = "Sno") var Sno: Long,
        var Tdate: LocalDate,
        var Ttime: LocalTime,
        var ReSeat: Int
)