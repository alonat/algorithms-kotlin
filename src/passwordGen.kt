import java.util.*

/*
* The password is hard to crack if it contains at least A uppercase letters, at least B lowercase letters,
* at least C digits, and includes exactly N symbols. Also, a password cannot contain two or more same characters
* coming one after another. For a given numbers A, B, C, N you should output a password that matches these requirements.
* It is guaranteed A, B, C, and N are non-negative integers and A + B + C <= N.
* Keep in mind, that any parameter can be equal to zero.
* It means that it's ok if the password doesn't contain symbols of such type.
* */

fun setFromArr (arr: CharRange, n: Int): String {
    if (n == 0) return ""
    var str = arr.random().toString()
    while (str.length < n) {
        val nextChar = arr.random()
        if (nextChar != str.last()) {
            str += nextChar
        }
    }

    return str
}

fun main() {
    val scanner = Scanner(System.`in`)
    val upL = scanner.nextInt()
    val lowL = scanner.nextInt()
    val dCount = scanner.nextInt()
    val pasLength = scanner.nextInt()

    val upperCase = ('A'..'Z')
    val lowerCase = ('a'..'z')
    val digits = ('0'..'9')

    var password = ""

    password += setFromArr(upperCase, upL)
    password += setFromArr(lowerCase, lowL)
    password += setFromArr(digits, dCount)

    if (password.length < pasLength) {
        password += setFromArr(upperCase, pasLength - password.length)
    }

    println(password)
}
