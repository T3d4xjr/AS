package com.example.act1_unidad7_notificacionesmanag;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    private static final String CHANNEL_ID = "canal_notificaciones";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel();
        }


        // Configurar botón para enviar una notificación
        Button notifyButton = findViewById(R.id.notifyButton);
        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();  // Llamar al método para enviar la notificación
            }
        });

        // Solicitar permisos para notificaciones en Android 13 o superior
        requestNotificationPermission();
    }


    /**
     * Crear un canal de notificación (solo para Android 8.0 y superior)
     */
    private void createNotificationChannel() {

            CharSequence name = "Canal de Notificaciones";
            String description = "Descripción del canal";
            int importance = NotificationManager.IMPORTANCE_HIGH; // Cambiado a PRIORIDAD ALTA
            NotificationChannel channel = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                channel = new NotificationChannel(CHANNEL_ID, name, importance);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel.setDescription(description);
            }

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(channel);
            }

    }
    /**
     * Enviar una notificación al hacer clic en el botón
     */
    private void sendNotification() {



        // Construir la notificación
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background) // Icono de la notificación
                .setContentTitle("Visita nuestro sitio web")
                .setContentText("Haz clic aquí para más información.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true); // La notificación se elimina al hacer clic


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return; // Salir si no se concedieron permisos
        }


        notificationManagerCompat.notify(1, builder.build());

    }
    // Método para solicitar permiso de notificaciones
    private void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }
    }
    // Método para manejar la respuesta de solicitud de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido
            } else {
                // Permiso denegado
            }
        }
    }
}
