package io.github.vprud

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform