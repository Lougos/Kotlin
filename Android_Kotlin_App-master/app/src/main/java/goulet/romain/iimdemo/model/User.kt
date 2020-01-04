package goulet.romain.iimdemo.model

import java.io.Serializable

data class User (
    val id: Int,
    val username: String,
    val name: String,
    val email: String,
    val phone: String,
    val website: String,
    val address: Address,
    val company: Company

    ): Serializable