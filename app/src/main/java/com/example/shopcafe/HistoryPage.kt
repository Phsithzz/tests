package com.example.shopcafe

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HistoryPage(viewModel: OrderViewModel,navController: NavController){
    val order by viewModel.drinks.collectAsState(initial = emptyList())
    LazyColumn {
        items(order){orders->
            Card(modifier = Modifier.padding(10.dp).fillMaxWidth()) {

                Row (modifier = Modifier.padding(8.dp)) {
                    Text(text = "Size :${orders.size},Qty:${orders.num}, Note: ${orders.note}", fontWeight = FontWeight.Bold)
                    IconButton(
                        onClick = {
                            navController.navigate("edit/${orders.id}")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit, contentDescription = "editIcon"
                        )

                    }
                    IconButton(
                        onClick = {
                            viewModel.removeOrder(orders)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete, contentDescription = "deleteIcon"
                        )
                    }
                }
            }

        }
    }
}