package com.example.cleanarchitecturenotesapp.feauturenote.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cleanarchitecturenotesapp.feauturenote.domain.util.NoteOrder
import com.example.cleanarchitecturenotesapp.feauturenote.domain.util.OrderType

@Composable
fun OrderSelection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChanged :(NoteOrder) -> Unit
){
    Column(modifier) {
        Row(modifier.fillMaxWidth()) {
           DefaultRadioButton(
               text = "Title",
               selected = noteOrder is NoteOrder.Title,
               onSelect = {onOrderChanged(NoteOrder.Title(noteOrder.orderType))}
           )
            Spacer(modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = noteOrder is NoteOrder.Date,
                onSelect = {onOrderChanged(NoteOrder.Date(noteOrder.orderType))}
            )
            Spacer(modifier.width(8.dp))
            DefaultRadioButton(
                text = "Color",
                selected = noteOrder is NoteOrder.Color,
                onSelect = {onOrderChanged(NoteOrder.Color(noteOrder.orderType))}
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = {onOrderChanged(noteOrder.copy(OrderType.Descending))}
            )
            Spacer(modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = {onOrderChanged(noteOrder.copy(OrderType.Descending))}
            )
        }
    }

}