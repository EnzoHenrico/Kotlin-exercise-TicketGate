package control

import bussines.GuestBusiness
import entity.Guest

class TicketGate {

    private val guestBusiness: GuestBusiness = GuestBusiness()

    init {
        println("---------- Portaria iniciada! ----------")
        println(this.control())
    }

    private fun control(): String {
        val age = Console.readInt("Qual sua idade? ")
        val guest = Guest(age)

        // Check Age
        if (!guestBusiness.isAgeValid(guest.age)) {
            return "Negado. Menores de idade não são permitidos"
        }

        // Check if ticket type is valid
        guest.ticketType = Console.readString("Qual o tipo do convite? ")
        if (!guestBusiness.isTicketTypeValid(guest.ticketType)) {
            return "Negado. Tipo de convite inválido"
        }

        // Check if ticket code is valid
        guest.ticketCode = Console.readString("Digite o código do convite: ")
        if (!guestBusiness.isGuestValid(guest)) {
            return "Negado. Código de convite inválido"
        }

        return "--------------------\n     Welcome :)\n--------------------"
    }
}