Desarrollo web en entorno servidor

# AD-4 Microservicios web con Spring Boot y JPA

## Enunciado

Una Empresa tiene recogido en una base de datos los pedidos solicitados por Clientes y el Comercial asociado a la venta. La tabla pedidos recoge el importe total del pedido realizado.

La aplicación la van a usar los jefes de comerciales  para ver la información, tanto de clientes como de sus comerciales.

Tablas:

![imagen](/Desarrollo_WE_Servidor_AD-4_imagen1.png)

Se adjunta el script del sql (en la unidad formativa UF6) con la creación de la base de datos (ventasbbdd_2024) de las tablas, insert para pruebas y creación del usuariouventas_2024 con la password uventas.

## Ejercicio

Crear un proyecto Spring web, con Spring data Jpa y MySql 8 para los siguientes servicios web restfull, y probar con ~~postman~~ tu propio código Javascript:

| **url**         | **Descripción**|
| ----------------| ------------- |
| /comercial      | @RequestMapping(“/comercial”)  |
| /alta           | Dar de alta el comercial  |
| /eliminar/{id}  | Eliminar de la bbdd el comercial cuyo id coincida  |
| /uno/{id}       | Devolver los datos del comercial cuyo id coincida  |
| /bycliente/{id} | Devolver la lista de los comerciales que han atendido pedidos delcliente que coincida con ese id. |
| /conpedidos     | Devolver la lista de comerciales que han atendido algún pedido |
| /pedidos/{id}   | Devolver la lista de pedidos gestionados por el comercial quecoincida con ese id. |