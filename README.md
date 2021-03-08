# IngerGYM


Nombre: "IngerGYM"

# Descripción
La aplicación web simularia la gestión de un gimnasio y brindaría la oportunidad de elegir a sus clientes los horarios y las clases a las que quieren acceder respetando las medidas de aforo y sanidad impuestas. 

# Temática: 

Debido a las reestricciones por el covid y la limitación de aforo, una aplicación web para el control de las salas y las clases de un gimnasio. 
- Públicas:
Ver horarios de clases, como contactar con el gimnasio, ver tarifas , inscribirte al gimnasio. 

- Privadas:
Ver tu propio horario, seleccionar clases, disponibilidad de salas/clases, ver profesores/monitores, ver pistas disponibles, darte de baja.

# Entidades:

- PERSONA(id VARCHAR2(25), contraseña VARCHAR2(25),edad NUMBER(2),situacion_Laboral VARCHAR2(25),Rol VARCHAR2(25),Tarifa VARCHAR2(25));

- SALAS(AforoMax NUMBER(3),Horarios VARCHAR2(25),TipoSala VARCHAR2(25),numSala NUMBER(3));

- CLASES(AforoMax NUMBER(3),Horarios VARCHAR2(25),TipoSala VARCHAR2(25),profesor VARCHAR2(25),numSala NUMBER(3));
(Se relaciona con "SALAS" mediante AforoMax y numSala que los hereda de ella.)

- OPINION(id VARCHAR2(25),Horarios VARCHAR2(25),DiasTrabajo VARCHAR2(25),Rol VARCHAR2(25));
(Hereda de Persona el id y el Rol de los trabajadores.)

- CONTACTO(numero NUMBER(9),email VARCHAR2(25),id VARCHAR2(25));
(Se relaciona con persona para poder llevar un control de quien hace sugerencias en este apartado.)

# Funcionalidad de servicio interno:
El servicio interno se encarga de la gestión del aforo , la reserva de las clases por parte de los usuarios y la aplicación de las tarifas en función del cliente. Además del control de los turnos de los trabajadores.

# Integrantes
- Daniel Cáceres González; d.caceres.2018@alumnos.urjc.es
github: DCaceres2018

- Carlos Manuel Barrameda Portieles; cm.barrameda.2018@alumnos.urjc.es
github: CarlosMbp


# Imágenes de las pantallas principales

Pantalla principal (1).
![image](https://user-images.githubusercontent.com/78802315/110342172-64eaf180-802b-11eb-8618-da96f3aef5b5.png)
En esta pestaña un usuario puede decidir si Iniciar sesión como invitado, registrarse o iniciar con su usuario y contraseña.

Al pulsar sobre el Inicio de invitados. (2)
![image](https://user-images.githubusercontent.com/78802315/110343280-a29c4a00-802c-11eb-92b9-f5ab3d2ce270.png)
Podrá elegir si quiere ver el horario del gimnasio (clases) o si decide ver el contacto del gimnasio.

Si quiere ver el horario (2.1)
![image](https://user-images.githubusercontent.com/78802315/110343578-edb65d00-802c-11eb-8ba6-912604d26e6d.png)
Le redireccionara a una pestaña donde podra verlo y descargarlo (en un futuro ambas cosas)

Si quiere ver el Contacto (2.2)
![image](https://user-images.githubusercontent.com/78802315/110343735-12123980-802d-11eb-96ef-2015e6d5347d.png)
Aqui puede ver las formas de contactar con el gimnasio y sus horarios de apertura y cierre. (No es el mismo que el de clases)

En caso de que en vez de Iniciar como invitado quisiese registrarse (3).
![image](https://user-images.githubusercontent.com/78802315/110343938-48e84f80-802d-11eb-94cf-584ccedb492c.png)
Tendria que rellenar los campos de texto y numeros correspondiente y se le guardaria.

Para iniciar sesion, usamos el nombre y la contraseña. (4)
![image](https://user-images.githubusercontent.com/78802315/110344207-8d73eb00-802d-11eb-9575-57a39b0a84f7.png)
Nos redirecciona a esta página donde podemos elegir que queremos hacer dentro ya del la web bajo nuestro nombre.

En caso de que querer entrar en salas (4.1)
![image](https://user-images.githubusercontent.com/78802315/110344401-ba280280-802d-11eb-9a76-963c4865b4e4.png)
Nos saldrian todas las salas disponibles y dentro de ellas un boton de reserva y un indicador del número de plazas restantes.
![image](https://user-images.githubusercontent.com/78802315/110344508-d7f56780-802d-11eb-8158-f7741ce2ce4c.png)
Igual que aqui en Piscina igual.

En caso de que querer entrar en clases (4.2)
![image](https://user-images.githubusercontent.com/78802315/110344620-f5c2cc80-802d-11eb-9f7e-c62f76d27163.png)
Sigue el esquema de sala pero con el pequeño cambio que aqui ya viene el horario establecido de cada clase 
![image](https://user-images.githubusercontent.com/78802315/110344722-12f79b00-802e-11eb-8a22-b24f2edb59b1.png)

En caso de que querer entrar en contacto (4.3)
![image](https://user-images.githubusercontent.com/78802315/110344801-273b9800-802e-11eb-8299-316f683fad02.png)
Al igual que el contacto al iniciar sesión como invitado, este también indica los datos y los horarios del gym.

En caso de que querer comprobar tu tarifa (4.4)
![image](https://user-images.githubusercontent.com/78802315/110344928-518d5580-802e-11eb-8abc-0f2d188db9cc.png)
Le redirecciona a una página la cual te indica cual es tu tarifa ese mes dentro del gym. 

En caso de que querer enviar una opinión (4.5)
![image](https://user-images.githubusercontent.com/78802315/110345063-77b2f580-802e-11eb-91b7-e159e66c939c.png)
Cada usuario podrá escribir su opinión respecto al gimnasio y esta quedara guardada en la base de datos y se unirá a la lista de opiniones de todos los usuarios. Las cuales se muestras abajo.




# Diagrama de navegación

![image](https://user-images.githubusercontent.com/78802315/110346155-91087180-802f-11eb-9aca-26e3f71de40a.png)

# Diagrama de clases
![image](https://user-images.githubusercontent.com/78802315/110349649-2f4a0680-8033-11eb-8c8c-891e47ae28f0.png)

# Diagrama Entidad/relacion
![image](https://user-images.githubusercontent.com/78802315/110351338-0591df00-8035-11eb-84cf-06178b63a964.png)









