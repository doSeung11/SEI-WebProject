package com.example.SE.repository

import com.example.SE.domain.Timetable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TimetableRepository : CrudRepository<Timetable, Long>