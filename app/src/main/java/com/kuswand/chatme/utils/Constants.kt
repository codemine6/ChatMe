package com.kuswand.chatme.utils

object Constants {
    val EMAIL_PATTERN = """^([a-z\d.-]+)@([a-z\d-]+)\.([a-z]{2,8})(\.[a-z]{2,8})?$""".toRegex()
    val PASSWORD_PATTERN = """^[\d\w@-]{6,20}$""".toRegex()
}