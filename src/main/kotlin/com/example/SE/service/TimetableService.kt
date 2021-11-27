package com.example.SE.service

import com.example.SE.domain.Timetable
import org.springframework.stereotype.Service

@Service
interface TimetableService {
    fun getAllTimetables(): List<Timetable>?
    fun getTimetable(id: Long): Timetable?
}