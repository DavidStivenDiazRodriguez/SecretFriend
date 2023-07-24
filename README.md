# App Prueba tecnica GCA

Bienvenido a la aplicación de amigo secreto. Esta es una app para registrar participantes con sus opciones de regalo y asignar un amigo secreto de forma aleatoria.

## Características

- Registro de usuario con opcion de regalo.
- Asignacion de amigo secreto.
- Informacion registrada del amigo secreto.

## Requisitos Previos

- Dispositivo Android o emulador con Android 7.0 (API 24) o superior.

## Bibliotecas Utilizadas

- [Retrofit] (implementation "com.squareup.retrofit2:retrofit:2.9.0"): Para la petición REST.
  [GSon] (implementation "com.squareup.retrofit2:converter-gson:2.9.0"): Para convertir el formato Json en un modelo de datos fácil para poder trabajar con él.
- [Coroutine] (implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6"): Para getionar tareas asincrónicas

## Servicios consumidos

- http://20.253.245.188:8080/api/user
- http://20.253.245.188:8080/api/user/{id}: El identificador debe ser el username del participante que selecciona el amigo.

## Contacto

david972934@gmail.com.