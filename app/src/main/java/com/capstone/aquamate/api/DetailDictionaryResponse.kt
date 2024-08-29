package com.capstone.aquamate.api

import com.capstone.aquamate.DetailDictionary
import java.lang.Error

data class DetailDictionaryResponse(
    val error: Boolean,
    val message: String?,
    val dictionary: DetailDictionary?
)

