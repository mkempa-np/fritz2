package dev.fritz2.components.model
import dev.fritz2.lenses.Lenses

@Lenses
data class Person (
    val _id: String = "",
    val id: Int = 0,
    val fullName: String = "",
    val birthday:String = "",
    val email: String = "",
    val mobile: String = "",
    val phone: String = "",
    val address: Address = Address()
)


@Lenses
data class Address(
    val street: String = "",
    val houseNumber: String = "",
    val postalCode: String = "",
    val city: String = "",
)