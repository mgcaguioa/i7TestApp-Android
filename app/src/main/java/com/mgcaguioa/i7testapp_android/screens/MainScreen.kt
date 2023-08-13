package com.mgcaguioa.i7testapp_android.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mgcaguioa.i7testapp_android.MainNavOption

@Composable
fun MainScreen(
    navController: NavController,
    vm: MainViewModel = hiltViewModel(),
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (i in 1..4) {
            val btn = "Button $i"
            Button(
                onClick = {
                    vm.saveAction(btn)
                    navController.navigate(MainNavOption.ActionLogsScreen.name)
                },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = btn,
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 8.dp,
                    )
                )
            }
        }
    }
}