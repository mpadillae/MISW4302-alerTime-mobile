package com.mfpe.alertime.model

data class Alarm (
    val id: Int,
    val name: String,
    val subtitle: String,
    val isEnabled: Boolean
)