# IngerGYM

![image](https://user-images.githubusercontent.com/78802315/111182794-90cc2100-85af-11eb-8592-9eb71d1e0eaa.png)


## Descripción
La aplicación web simularia la gestión de un gimnasio y brindaría la oportunidad de elegir a sus clientes los horarios y las clases a las que quieren acceder respetando las medidas de aforo y sanidad impuestas. 

## Temática: 

Debido a las reestricciones por el covid y la limitación de aforo, una aplicación web para el control de las salas y las clases de un gimnasio. 
- Públicas:
Ver horarios de clases, como contactar con el gimnasio, ver tarifas , inscribirte al gimnasio. 

- Privadas:
Ver tu propio horario, seleccionar clases, disponibilidad de salas/clases, ver profesores/monitores, ver pistas disponibles, darte de baja.

## Entidades:

- PERSONA(id VARCHAR2(25), contraseña VARCHAR2(25),edad NUMBER(2),situacion_Laboral VARCHAR2(25),Rol VARCHAR2(25),Tarifa VARCHAR2(25));

- SALAS(AforoMax NUMBER(3),Horarios VARCHAR2(25),TipoSala VARCHAR2(25),numSala NUMBER(3));

- CLASES(AforoMax NUMBER(3),Horarios VARCHAR2(25),TipoSala VARCHAR2(25),profesor VARCHAR2(25),numSala NUMBER(3));
(Se relaciona con "SALAS" mediante AforoMax y numSala que los hereda de ella.)

- OPINION(id VARCHAR2(25),Texto VARCHAR2(25));


- Tarifa(edad NUMBER(2),precio NUMBER(2),id VARCHAR2(25));
(Se relaciona con persona para poder llevar un control de quien hace sugerencias en este apartado.)

## Funcionalidad de servicio interno:
El servicio interno se encarga enviar por correo las confirmaciones de registro y de reserva de clases. 

## Integrantes
- Daniel Cáceres González; d.caceres.2018@alumnos.urjc.es
github: DCaceres2018

- Carlos Manuel Barrameda Portieles; cm.barrameda.2018@alumnos.urjc.es
github: CarlosMbp


### Imágenes de las pantallas principales

Pantalla principal (1).

![image](https://user-images.githubusercontent.com/78802315/114551613-ef92c200-9c63-11eb-9e39-74ba8e4f60cd.png)

En esta pestaña un usuario puede decidir si ver horario, registrarse o iniciar con su usuario y contraseña.

Al pulsar sobre el horario. (2)

![image](https://user-images.githubusercontent.com/78802315/111175549-d2a59900-85a8-11eb-9ece-da503fa1c5e0.png)

Saldrán todas las clases disponibles en ese momento en el gimnasio.

En caso de que en vez de ver el horario quisiese registrarse (3).

![image](https://user-images.githubusercontent.com/78802315/110343938-48e84f80-802d-11eb-94cf-584ccedb492c.png)

Tendria que rellenar los campos de texto y numeros correspondiente y se le guardaria.

Para iniciar sesion, usamos el nombre y la contraseña. (4)

![image](https://user-images.githubusercontent.com/78802315/114551682-046f5580-9c64-11eb-8d9a-013c3ccff81c.png)

En función del rol que tengamos nos saldrá la web para admins :

![image](https://user-images.githubusercontent.com/78802315/114551764-21a42400-9c64-11eb-8fa8-d12890470ff3.png)

O la web para usuarios:

![image](https://user-images.githubusercontent.com/78802315/114551814-31236d00-9c64-11eb-9a44-fc1e7315dd4a.png)

En caso de que querer entrar en salas (4.1)

![image](https://user-images.githubusercontent.com/78802315/110344401-ba280280-802d-11eb-9a76-963c4865b4e4.png)

Nos saldrian todas las salas disponibles y dentro de ellas un boton de reserva y un indicador del número de plazas restantes.

![image](https://user-images.githubusercontent.com/78802315/110344508-d7f56780-802d-11eb-8158-f7741ce2ce4c.png)

Igual que aqui en Piscina igual.

En caso de que querer entrar en clases (4.2)

![image](https://user-images.githubusercontent.com/78802315/111175879-20220600-85a9-11eb-839b-df7444740f1a.png)

Salen las clases disponibles y deberiamos introducir el nombre de la clase a la que queremos suscribirnos.


En caso de que querer entrar en tarifas (4.3)

![image](https://user-images.githubusercontent.com/78802315/111176084-5069a480-85a9-11eb-9afc-a704f6e0a5cc.png)

Nos saldrán unos enlaces con los diferentes precios. Al clickar en alguno nos mostraria la lista de usuarios con esa tarifa.

En caso de que querer enviar una opinión (4.4)

![image](https://user-images.githubusercontent.com/78802315/110345063-77b2f580-802e-11eb-91b7-e159e66c939c.png)

Cada usuario podrá escribir su opinión respecto al gimnasio y esta quedara guardada en la base de datos y se unirá a la lista de opiniones de todos los usuarios. Las cuales se muestras abajo.

En caso de pulsar sobre Usuarios disponibles (4.5) 

![image](https://user-images.githubusercontent.com/78802315/111176335-8870e780-85a9-11eb-869b-8edcdf2d2ebb.png)

Podremos seleccionar cualquier usuario y borrarlo. 

![image](https://user-images.githubusercontent.com/78802315/111176410-9c1c4e00-85a9-11eb-83c0-22e6a1189511.png)

En caso de pulsar sobre Ver mis clases (4.6) 

![image](https://user-images.githubusercontent.com/78802315/111176524-b3f3d200-85a9-11eb-8cb4-45f0b5d0ab3e.png)

Sale una lista con las clases a las que estas inscrito.

En caso de querer crear una clase (4.7)

![image](https://user-images.githubusercontent.com/78802315/111176642-cd951980-85a9-11eb-83d5-24da7c833159.png)

Deberiamos rellenar el formulario y se crearia una sala.

### Diagrama de navegación

![image](https://user-images.githubusercontent.com/78802315/111177727-ce7a7b00-85aa-11eb-9cac-d557a41c405b.png)

### Diagrama de clases

![image](https://user-images.githubusercontent.com/78802315/111180451-582b4800-85ad-11eb-9c51-f11256c2eeee.png)

### Diagrama Entidad/relacion

![image](https://user-images.githubusercontent.com/78802315/111182770-89a51300-85af-11eb-9402-dd9539f37810.png)




# FASE 3

Primero de todo, este es nuestro diagrama de clases de ambas aplicaciones. 

![DiagramaDAD](https://user-images.githubusercontent.com/78802315/114550566-a4c47a80-9c62-11eb-94b3-b213fcc97ec8.png)

Y los templates relacionados con sus respectivos controladores.

![ControlladoresTemplates](https://user-images.githubusercontent.com/78802315/114550635-b443c380-9c62-11eb-94da-064f5b9af467.png)


## Para el despliegue de la aplicación necesitaremos :computer:

-Java 11 (**Muy importante**)
-MySQL server 9.0.23
-MySQL workbench 8.023

Antes que nada comprobaremos que todos los paquetes de nuestro sistema están actualizados, para ello ejecutaremos los siguientes  comandos.
`sudo apt update`
`sudo apt upgrade`

##Java 11 :package:

Insatalaremos  OpenJDK 11 en nuestro sistema, para ello ejecutaremos en  nuestro terminal.
`sudo apt install openjdk-11-jdk`

Podremos comprobar que se ha instalado correctamente la versión.
`java -version`

##Instalación de MySQL server :package:

-Para ello ejecutaremos el siguiente comando en nuestra terminal.
`sudo apt install mysql-server  `
(En el proceso nos preguntara si estamos de acuerdo con el espacio total necesario)

-Comprobaremos que se ha instalado correctamente.
`sudo mysql`

-Por ahora únicamente tendremos un usuario por defecto ‘root’, pero la contraseña para el aun no esta definida, para ello ejecutaremos el siguiente comando.
`mysql> ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '1234';`
(Dónde ‘root’ es la contraseña que elegiremos, root en este caso).

-Para salir de la consola “mysql>” escribiremos el siguiente comando.
`mysql> exit;`

#Instalación de MySQL workbecnh 8.0.23 :package:

-Antes que nada comprobaremos que el MySQL community server esta ejecutándose a traves del siguiente comando.
`systemctl status mysql.service`

-A continuación instalaremos el MySQL workbench a traves del siguiente comando.
`sudo apt install mysql-workbench`

Por último, para que la aplicación funcione deberemos seguir los siguientes pasos en nuestro MySQL workbench.

-Deberemos iniciar el workbench, para ello ejecutaremos el siguiente comando.
`mysql-workbench`

-Nos conectaremos a la instancia local, con la contraseña seleccionada anteriormente (en nuestro caso “1234”).

-En el menú superior crearemos un esquema (“Create a new schema in the connected server”) cuyo nombre en este caso será ‘posts’.

##Despliegue de la aplicación :rocket:

-En primer lugar clonaremos el repositorio de la aplicación, para ello ejecutaremos en la terminal el siguiente comando:
`Git clone https://github.com/DCaceres2018/IngerGYM.git`

-Accederemos a las carpetas target de “IngerGYM” e “internal_service” respectivamente y ejecutaremos los siguientes comandos.
`java -jar IngerGYM-spring-0.0.1-SNAPSHOT.jar`
`java -jar internal_service-1.0.0.jar`

-Por último, accederemos a la aplicación a través del navegador en el siguiente link ![https://localhost:8443/]( https://localhost:8443/ ).

