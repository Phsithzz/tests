package com.example.shopcafe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.rounded.DoNotDisturbOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EditScreen(navController: NavController,   sharedViewModel: SharedViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        val sizeOption = listOf("S", "M", "L")
        var selectedOption by remember { mutableStateOf(sizeOption[0]) }

        var detail by remember { mutableStateOf("") }
        var amount by remember { mutableStateOf(1) }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f),
            painter = painterResource(id = R.drawable.milktea),
            contentDescription = "Milk Tea Photo",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "ชานมข้าวหอม", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Rice Milk Tea", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "ขนาด:", fontSize = 20.sp)
            sizeOption.forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option }
                    )
                    Text(text = option)

                }

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "รายละเอียดเพิ่มเติม", fontSize = 20.sp)
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = detail,
            onValueChange = { detail = it },
            label = { Text("เช่น หวานน้อย, เพิ่มช๋อต") })

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "จำนวน: ")

            IconButton(onClick = {
                if (amount > 0) amount--
            }) {
                Icon(
                    imageVector = Icons.Rounded.DoNotDisturbOn,
                    contentDescription = "Icon Add"
                )
            }
            Text(text = "$amount", modifier = Modifier.padding(horizontal = 64.dp))
            IconButton(onClick = {
                amount++
            }) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Icon Minus"
                )
            }

        }



        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .clickable {
                    sharedViewModel.setOrder(
                        size = selectedOption,
                        num = amount,
                        note = detail
                    )
                    navController.navigate("confirm")
                }
                .fillMaxWidth()
                .background(Color(0xff5DD3B6))
                .padding(15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("ใส่ตะกร้า", color = Color.White)
        }


    }
}
