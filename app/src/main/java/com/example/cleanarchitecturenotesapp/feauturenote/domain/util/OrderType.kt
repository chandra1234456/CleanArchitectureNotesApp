package com.example.cleanarchitecturenotesapp.feauturenote.domain.util

sealed class OrderType{
    object Ascending : OrderType()
    object Descending : OrderType()
}