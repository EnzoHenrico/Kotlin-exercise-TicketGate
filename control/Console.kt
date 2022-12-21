package control

class Console private constructor(){
    companion object {
        fun readInt(message: String): Int {
            print(message)
            var input = readLine()?.toIntOrNull() ?: 0

            while (input <= 0 ) {
                print("Invalid value, try again: ")
                input = readLine()?.toIntOrNull() ?: 0
            }
            return input
        }

        fun readString(message: String): String {
            print(message)
            var input: String = readLine().toString()

            while (input == "") {
                print("Invalid value, try again: ")
                input = readLine().toString()
            }
            return input.lowercase()
        }
    }
}