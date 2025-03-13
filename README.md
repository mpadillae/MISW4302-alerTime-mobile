<p align="center">
  <img src="https://github.com/user-attachments/assets/da944ba0-b226-4238-b483-12bd755c6cd4" alt="alerTime">
</p>

# Android Application - Setup and Execution Guide

## Requisitos previos
Para levantar este proyecto necesitarás:
- Android Studio Ladybug | 2024.2.1 o superior.
- SDK de Android.
- Variable de entorno `ANDROID_HOME` apuntando al SDK.
- JDK 11 o superior.
- Gradle 7.0 o superior.

## Compilación del proyecto
1. Abre el proyecto en Android Studio.
2. Sincroniza el proyecto con los archivos de Gradle haciendo clic en `File > Sync Project with Gradle Files` en la barra de menú.
3. Compila el proyecto seleccionando `Build > Make Project` en la barra de menú.

## Generar APK
1. En Android Studio, ve a `Build > Build Bundle(s) / APK(s) > Build APK(s)`.
2. El APK se generará y lo encontrarás en el directorio `app/build/outputs/apk/`.

## Ejecutar la aplicación
1. Conecta un dispositivo Android vía USB o inicia un emulador de Android.
2. Haz clic en el botón `Run` en la barra de herramientas o selecciona `Run > Run 'app'` en el menú.
3. Elige el dispositivo de destino y haz clic en `OK`.