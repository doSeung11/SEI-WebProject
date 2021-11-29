package com.example.se.service

import com.example.SE.domain.*
import com.example.SE.repository.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.web.WebAppConfiguration
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.transaction.Transactional

@DataJpaTest
@WebAppConfiguration
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ResorvatorServiceTests {

    @Autowired
    private lateinit var movieRepository: MovieRepository
    @Autowired
    private lateinit var reservationRepository: ReservationRepository
    @Autowired
    private lateinit var screenroomRepository: ScreenroomRepository
    @Autowired
    private lateinit var theaterRepository: TheaterRepository
    @Autowired
    private lateinit var timetableRepository: TimetableRepository

    @Test
    fun getAllMovie() {
        var movies = movieRepository.findAllBy()
        var info = movieRepository.findById(1).orElse(null)

        if (movies != null) {
            assertThat(movieRepository.findById(1).orElse(null)).isEqualTo(movies[0])
        }
    }

    @Test
    fun getMovie() {
        var id = 1
        var information = movieRepository.findById(id.toLong()).orElse(null)

        if (information != null) {
            assertEquals("이터널스",information.MovieName)
        }
    }

    @Test
    fun getReservation() {
        var rR: Reservation = reservationRepository.findById(123456789).orElse(null)
        var mR: Movie = movieRepository.findById(rR.Mno).orElse(null)
        var tR: Theater = theaterRepository.findById(rR.Tno).orElse(null)
        var ttR: Timetable = timetableRepository.findById(rR.TimeNo).orElse(null)
        var reservationInfo = ReservationInfo(rR.Rno, mR.Poster, mR.MovieName, tR.TheaterName, ttR.sno, rR.Headcount, ttR.tdate, ttR.ttime)

        assertEquals(reservationInfo.Rno, 123456789)
        assertEquals(reservationInfo.Mname, "이터널스")

    }

    @Test
    fun deleteReservation() {
        reservationRepository.deleteById(123456789)
        assertEquals(reservationRepository.findById(123456789).orElse(null), null)
    }

    @Test
    fun saveReservation() {
        var movieNum: String = "3"
        var theaterNum: String = "2"
        var timeNum: String = "1"
        var headCount: String = "3"
        var name: String = "홍길현"
        var birthDate: String = "2000-05-05"
        var pNum: String = "010-3456-4657"

        var reservationNo: Long = 123456786

        var Bdate: LocalDate = LocalDate.parse(birthDate, DateTimeFormatter.ISO_DATE)
        var newReservation = Reservation(reservationNo, name, pNum, Bdate, headCount.toInt(), theaterNum.toLong(), movieNum.toLong(), timeNum.toLong())

        reservationRepository.save(newReservation)

        assertEquals(reservationRepository.findById(123456786).orElse(null).MemberName,"홍길현")
    }

    @Test
    fun getAllScreenrooms() {
        var room = screenroomRepository.findAllBy()

        room?.get(0)?.let { assertEquals(it.Tno, 1) }
        room?.get(0)?.let { assertEquals(it.Sno, 1) }
    }

    @Test
    fun getAllTheaters() {
        var theater = theaterRepository.findAllBy()

        theater?.get(0)?.let { assertEquals(it.Tno, 1) }
        theater?.get(0)?.let { assertEquals(it.TheaterName, "강동") }
    }

    @Test
    fun getAllTimetables() {
        var timetable = timetableRepository.findAllBy()
        timetable?.get(0)?.let { assertEquals(it.tno, 1) }
        timetable?.get(0)?.let { assertEquals(it.mno, 1) }
    }

    @Test
    fun getTimeNo() {
    }
}
