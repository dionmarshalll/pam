package com.example.pam.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pam.R
import com.example.pam.ui.theme.PamTheme

@Composable
fun AvatarScreen(navController: NavController) {

    // State
    var showBrows by remember { mutableStateOf(true) }
    var showEyes by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        // Add aset
        Box(
            modifier = Modifier.size(450.dp),
            contentAlignment = Alignment.Center
        ) {
            // Kepala base
            Image(
                painter = painterResource(id = R.drawable.kepala),
                contentDescription = "Kepala Avatar",
                modifier = Modifier.fillMaxSize()
            )

            if (showBrows) {
                Image(
                    painter = painterResource(id = R.drawable.alis),
                    contentDescription = "Alis",
                    modifier = Modifier
                        .size(width = 180.dp, height = 60.dp)
                        .offset(y = (-50).dp)
                )
            }

            if (showEyes) {
                Image(
                    painter = painterResource(id = R.drawable.mata),
                    contentDescription = "Mata",
                    modifier = Modifier
                        .size(width = 200.dp, height = 60.dp)
                        .offset(y = (-3).dp)
                )
            }

            if (showNose) {
                Image(
                    painter = painterResource(id = R.drawable.hidung),
                    contentDescription = "Hidung",
                    modifier = Modifier
                        .size(width = 50.dp, height = 50.dp)
                        .offset(y = 40.dp)
                )
            }

            if (showMouth) {
                Image(
                    painter = painterResource(id = R.drawable.bibir),
                    contentDescription = "Bibir",
                    modifier = Modifier
                        .size(width = 100.dp, height = 50.dp)
                        .offset(y = 90.dp)
                )
            }
        }
        // Kontrol Checkbox tidak berubah
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PartCheckbox(
                label = "Alis",
                checked = showBrows,
                onCheckedChange = { showBrows = it }
            )
            PartCheckbox(
                label = "Mata",
                checked = showEyes,
                onCheckedChange = { showEyes = it }
            )
            PartCheckbox(
                label = "Hidung",
                checked = showNose,
                onCheckedChange = { showNose = it }
            )
            PartCheckbox(
                label = "Bibir",
                checked = showMouth,
                onCheckedChange = { showMouth = it }
            )
        }


        // Tombol kembali
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simpan & Kembali ke Profil")
        }
    }
}

@Composable
fun PartCheckbox(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 1.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(text = label)
    }
}


@Preview(showBackground = true)
@Composable
fun AvatarScreenPreview() {
    PamTheme {
        AvatarScreen(navController = rememberNavController())
    }
}

