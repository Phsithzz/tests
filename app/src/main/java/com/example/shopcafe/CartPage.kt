package com.example.shopcafe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

@Composable
fun CartDetail(
    sharedViewModel: SharedViewModel,
    navController: NavController,
    orderViewModel: OrderViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        val size = sharedViewModel.size
        val amount = sharedViewModel.num
        val detail = sharedViewModel.note
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f),
            painter = painterResource(id = R.drawable.milktea),
            contentDescription = "Milk Tea Photo",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "รายการที่สั่ง", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Row(

        ) {
            Text(text = "ขนาด: ", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "$size", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(

        ) {
            Text(text = "จำนวน: ", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "$amount", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(

        ) {
            Text(text = "รายละเอียดเพิ่มเติม: ", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "$detail", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    orderViewModel.insertOrder(
                        size = size,
                        num = amount,
                        note = detail
                    )
                    navController.navigate("home")
                }
            ) {
                Text(text = "สั่งเลย", color = Color.White)
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    navController.navigate("home")
                }
            ) {
                Text(text = "ยกเลิก", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

    }
}