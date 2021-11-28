package com.example.SE.domain

import java.time.LocalDate
import java.time.LocalTime

class ReservationInfo {
    var Rno: Long = 0
    var Poster: String? = null
    var Mname: String = ""
    var Tname:String = ""
    var Sno:Long =0
    var Headcount: Int =0
    var Tdate: LocalDate = LocalDate.now()
    var Ttime:LocalTime = LocalTime.now()

    constructor(Rno:Long, Poster: String?, Mname:String?, Tname:String, Sno:Long, Headcount:Int, Tdate:LocalDate, Ttime:LocalTime){
        this.Rno = Rno
        this.Poster = Poster
        if (Mname != null) {
            this.Mname = Mname
        }
        this.Tname = Tname
        this.Sno = Sno
        this.Headcount = Headcount
        this.Tdate = Tdate
        this.Ttime = Ttime
    }
}