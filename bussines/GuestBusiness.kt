package bussines

import entity.Guest

class GuestBusiness {

    private val validTypes: Map<String, String> = mapOf(Pair("comum", "xt"), Pair("premium", "xl"), Pair("luxo", "xl"))
//    private val validTypes: List<String> = listOf("comum", "premium", "luxo")


    fun isAgeValid(age: Int): Boolean = age > 18

    fun isTicketTypeValid(ticketType: String): Boolean = this.validTypes.contains(ticketType)

//    fun isGuestValid(guest: Guest): Boolean =
//        when(guest.ticketType) {
//            "premium", "luxo" -> guest.ticketCode.startsWith("xl")
//            "comum" -> guest.ticketCode.startsWith("xt")
//            else -> false
//        }
    fun isGuestValid(guest: Guest): Boolean {
        val validCode: String = validTypes[guest.ticketType] ?: ""

        return guest.ticketCode.startsWith(validCode)
    }
}