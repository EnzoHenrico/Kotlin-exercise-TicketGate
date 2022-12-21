package control

import bussines.GuestBusiness
import entity.Guest

class TicketGate {

    private val guestBusiness: GuestBusiness = GuestBusiness()

    init {
        println("---------- Gates Open! ----------")
        println(this.control())
    }

    private fun control(): String {
        val age = Console.readInt("Your age? ")
        val guest = Guest(age)

        // Check Age
        if (!guestBusiness.isAgeValid(guest.age)) {
            return "Denied. Minors are not allowed"
        }

        // Check if ticket type is valid
        guest.ticketType = Console.readString("Insert invite type: ")
        if (!guestBusiness.isTicketTypeValid(guest.ticketType)) {
            return "Denied. Ticket type invalid"
        }

        // Check if ticket code is valid
        guest.ticketCode = Console.readString("Insert invite code: ")
        if (!guestBusiness.isGuestValid(guest)) {
            return "Denied. Ticket code invalid"
        }

        return "--------------------\n     Welcome :)\n--------------------"
    }
}