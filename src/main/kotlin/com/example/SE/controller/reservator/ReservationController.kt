package com.example.SE.controller.reservator

import com.example.SE.service.ReservationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest

@Controller
class ReservationController {
    @Autowired
    private lateinit var reservationService: ReservationService
    var Rnum: Long =0

    @GetMapping("/reservations")
    private fun getReservations(): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body(reservationService.getAllReservations())
    }

    @GetMapping("/reservation")
    private fun getReservationInfo(model:Model, httpServletRequest: HttpServletRequest): String {
        var id: String = httpServletRequest.getParameter("Num1");
        var information = reservationService.getReservation(id.toLong());
        model.addAttribute("Rno", information?.Rno)
        model.addAttribute("Poster",information?.Poster)
        model.addAttribute("Mname",information?.Mname)
        model.addAttribute("Tname",information?.Tname)
        model.addAttribute("Sno",information?.Sno)
        model.addAttribute("Headcount",information?.Headcount)
        model.addAttribute("Tdate",information?.Tdate)
        model.addAttribute("Ttime",information?.Ttime)
        Rnum = information?.Rno!!
        return "reservationInfo"
    }

    @GetMapping("/deleteRe")
    private fun deleteReservation(): String{
        reservationService.deleteReservation(Rnum)
        return "main"
    }
}