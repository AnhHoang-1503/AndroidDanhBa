package com.example.danhba

data class ItemModel(var name: String, var phone: String, var email: String, val imageThumb: Int = 0, val imageLarge: Int = 0) {
    var selected = false
}