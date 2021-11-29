package com.example.SE.repository

import com.example.SE.domain.Timetable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalTime

@Repository
interface TimetableRepository : CrudRepository<Timetable, Long>{
    fun findAllBy(): List<Timetable>?
    fun findFirstByTnoAndMnoAndSnoAndTdateAndTtime(tno: Long, mno: Long, sno: Long, tdate: LocalDate, ttime: LocalTime): Timetable?
}