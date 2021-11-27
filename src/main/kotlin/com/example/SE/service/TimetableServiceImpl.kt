package com.example.SE.service

import com.example.SE.domain.Timetable
import com.example.SE.repository.TimetableRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TimetableServiceImpl constructor(@Autowired private val timetableRepository: TimetableRepository): TimetableService{
    override fun getAllTimetables(): List<Timetable>? =
            timetableRepository.findAllBy()

    override fun getTimetable(id: Long): Timetable? =
            timetableRepository.findById(id).orElse(null)
}