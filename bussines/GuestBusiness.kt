package bussines

import entity.Guest

class GuestBusiness {

    private val validTypes: Map<String, String> = mapOf(Pair("standard", "xt"), Pair("premium", "xl"), Pair("deluxe", "xl"))

    fun isAgeValid(age: Int): Boolean = age > 18

    fun isTicketTypeValid(ticketType: String): Boolean = this.validTypes.contains(ticketType)

    fun isGuestValid(guest: Guest): Boolean {
        val validCode: String = validTypes[guest.ticketType] ?: ""

        return guest.ticketCode.startsWith(validCode)
    }
}