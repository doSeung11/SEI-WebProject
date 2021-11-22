package com.example.SE.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="Reservation")
data class Reservation(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var Rno: Long? = null,
        var MemberName:String,
        var MemberPnum:String,
        var MemberBdate: LocalDate,
        var Headcount: Int,
        @JoinColumn(name = "Tno") var Tno: Long,
        @JoinColumn(name = "Mno") var Mno: Long,
        @JoinColumn(name = "TimeNo") var TimeNo: Long
)

