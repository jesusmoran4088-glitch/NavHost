package udg.cuvalles.mynavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home(
    onNavigateProfile: (id: String, name: String) -> Unit
) {
    var userId by rememberSaveable { mutableStateOf("") }
    var userName by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home App",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = userId,
            onValueChange = { userId = it },
            label = { Text("ID Usuario") }
        )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Nombre de Usuario") }
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (userId.isNotBlank() && userName.isNotBlank()) {
                    onNavigateProfile(userId, userName)
                }
            },
            enabled = userId.isNotBlank() && userName.isNotBlank()
        ) {
            Text("Ir al Perfil")
        }
    }
}