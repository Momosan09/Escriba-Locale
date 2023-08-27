# Escriba Locale

Es un programa que busca facilitar la internacionalizacion y localizacion de un juego hecho con [Libgdx](https://libgdx.com/).

## Metodo de uso
### Solo es necesario descargar el ejecutable, en caso de que quieras modificar algo del codigo para que se adapte mas a tu necesidad tambien subi el codigo
### Para ejecutar el .JAR, en una consola escribir java -jar Escriba-locale.jar (recomendio crearse un .bat que lo ejecute por vos, ver aplicado: [repo](https://github.com/Momosan09/Herreria_Enana/blob/main/comandos/ejecutar-Escriba.bat))

  1. Copiar el ejecutable descargado en el directorio /core/src/###/###/   (por defecto: /core/src/com/mygdx)
  2. Crear una variable de tipo I18NBundle en la/s clase/s que vaya a querer traducir
  3. Escribir las Keys dentro de la clase (Cuanto mas descriptivo el nombre de la Key mas facil sera para usted luego) Ejemplo: "menuPrincipal.Titulo"
  4. Una vez tenga puestas todas las Keys en sus clases ejecutar el Escriba-Locale
  5. Nombrar el archivo como "locale" + [codigo_del_idioma](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) + [codigo_del_pais](https://en.wikipedia.org/wiki/ISO_3166-1)  Ejemplo: (locale_es) idioma español  o (locale_es_AR) localizado Argentina   
  6. Revise su carpeta "assets" en busca de un nuevo directorio "locale" ahi tendra su archivo creado con todas las Keys cargadas y listas para editar

## ATENCION: nombrar el archivo con el mismo nombre que el de uno existente le repetira todas las claves encontradas debajo y sin valor. por ahora es recomendable escribir todas de de una y luego ejecutar el Escriba (Sino va a tener que borrar las claves repetidas)

En caso de que quieras entender mejor sobre internacionalizacion y localizacion, canal de youtube [makigas: aprende a programar](https://www.youtube.com/watch?v=l5JxhDhjNRY)
