package com.capstone.aquamate.customview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class PasswordCustomView(context: Context, attrs: AttributeSet) : TextInputEditText(context, attrs) {

    private val MIN_PASSWORD_LENGTH = 8
    private var isValid = false

    init {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                isValid = isPasswordValid(s.toString())
                if (!isValid) {
                    (parent.parent as? TextInputLayout)?.error = "Password harus memiliki setidaknya $MIN_PASSWORD_LENGTH karakter"
                } else {
                    (parent.parent as? TextInputLayout)?.error = null
                }
            }
        })
    }

    fun isValidPassword(): Boolean {
        return isValid
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length >= MIN_PASSWORD_LENGTH
    }
}