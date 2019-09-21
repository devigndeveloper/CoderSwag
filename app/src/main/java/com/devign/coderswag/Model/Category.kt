package com.devign.coderswag.Model

class Category (val title: String, val image: String) {

    // Force the view to show 'title' as opposed to the entire strings data
    override fun toString(): String {
        return title
    }
}