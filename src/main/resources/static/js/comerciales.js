//Leer todos comerciales/////////////////////////////////////////////////////////////////
document.getElementById('leertodosBtn').addEventListener('click', function() {

  // Realizar la solicitud GET
  fetch('http://localhost:8085/comercial', {
    method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      },
    })
    .then(respuesta => respuesta.json())
    .then(data => {
      console.log('Respuesta del servidor con la lista de todos los comerciales:', data);
    })
    .catch(error => {
      console.error('Error al leer los productos:', error);
    });
});

/////////////////////////////////////////////////////////////////////////////////////////////
document.getElementById('leercomercialporidBtn').addEventListener('click', function() {
  const idComercial = document.getElementById('idInput1').value;

  // Verificar si el ID está vacío o si estamos metiendo algún caracter no numérico
  if (!idComercial) {
    alert('Por favor, ingresa un ID de comercial válido.');
    return; // Salir de la función si no se proporciona un ID válido
  }

  // Realizar la solicitud GET
  fetch('http://localhost:8085/comercial/uno/'+idComercial, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    },
  })
  .then(respuesta => {
    if (respuesta.ok) {
      // Si la respuesta es exitosa, convertir la respuesta a JSON
      return respuesta.json();
      // Si la respuesta no es exitosa
    } else {
        return respuesta.text().then(mensajeJava => {
        throw new Error(mensajeJava); // Lanzar un error con el mensaje de error devuelto por el servidor
      });
    } 
  })
  .then(data => {
    console.log('Respuesta del servidor:', data);
    // Aquí podrías mostrar el producto en la interfaz de usuario o hacer otras operaciones con él
  })
  .catch(error => {
    console.error('Error 404. Mensaje del servidor:', error);
    alert('Error 404. Mensaje del servidor: ' + error); // Muestra el mensaje de error devuelto por el servidor
  });
});

//Alta//////////////////////////////////
document.getElementById('formularioComercial').addEventListener('submit', function(event) {
  event.preventDefault(); // Evitar el envío del formulario por defecto
  
  // Obtener los valores de los inputs
  const nombre = document.getElementById('nombreInput').value;
  const apellido1 = document.getElementById('apellido1Input').value;
  const apellido2 = document.getElementById('apellido2Input').value;
  const comision = parseFloat(document.getElementById('comisionInput').value);

  // Construir el objeto ProductoDTO
  const comercialDTO = {
    nombre: nombre,
    apellido1: apellido1,
    apellido2: apellido2,
    comision: comision
  };
  
  // Realizar la solicitud POST
  fetch('http://localhost:8085/comercial/alta', {
    method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(comercialDTO)
    })
    .then(respuesta => respuesta.json())
    .then(data => {
      console.log('Comercial creado:', data);
      // Aquí podrías mostrar un mensaje de éxito o redirigir a otra página
    })
    .catch(error => {
      console.error('Error al crear el comercial:', error);
    });
});

//Actualización///////////////////////////////////////////////////////////////////////
document.getElementById('formularioComercial2').addEventListener('submit', function(event) {
  event.preventDefault(); // Evitar el envío del formulario por defecto
  
  // Obtener los valores de los inputs
  const idComercial = document.getElementById('idComercialInput2').value;
  const nombre = document.getElementById('nombreInput2').value;
  const apellido1 = document.getElementById('apellido1Input2').value;
  const apellido2 = document.getElementById('apellido2Input2').value;
  const comision = document.getElementById('comisionInput2').value;

  // Construir el objeto ProductoDTO
  const comercialDTO = {
    idComercial: idComercial,
    nombre: nombre,
    apellido1: apellido1,
    apellido2: apellido2,
    comision: comision,
  };
  
  // Realizar la solicitud PUT
  fetch('http://localhost:8085/comercial/actualizar', {
    method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(comercialDTO)
    })
    .then(respuesta => respuesta.json())
    .then(data => {
      console.log('Comercial actualizado:', data);
    })
    .catch(error => {
      console.error('Error al actualizar el comercial:', error);
    });
});

//Borrar////////////////////////////////////////////////////////
document.getElementById('eliminarBtn').addEventListener('click', function() {
  // Obtener el ID de la familia desde el input
  const idComercial = document.getElementById('idInput2').value;

  // Verificar si el ID está vacío o si estamos metiendo algun caracter no numérico
  if (!idComercial) {
    alert('Por favor, ingresa un ID de producto válido.');
    return; // Salir de la función si no se proporciona un ID válido
  }

  // Realizar la solicitud DELETE
  fetch('http://localhost:8085/comercial/eliminar/'+idComercial, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json'
    },
  })
    .then(respuesta => {
      if (respuesta.ok) {
        // Si la solicitud se completa correctamente, manejar la respuesta del servidor
        respuesta.text().then(data => {
          console.log('Respuesta del servidor:', data);
          alert(data);
        });
      } else {
        console.error('Solicitud no completada');
        alert('Error al procesar la solicitud'); 
      }
    })
    .catch(error => {
      console.error('Error en la solicitud:', error);
      alert('Error en la solicitud: ' + error);
    });
});

//////////////////////////////////////
document.getElementById('leercomercialesconalmenosunpedidoBtn').addEventListener('click', function() {
  // Realizar la solicitud GET
  fetch('http://localhost:8085/comercial/conpedidos', {
    method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      },
    })
    .then(respuesta => respuesta.json())
    .then(data => {
      console.log('Respuesta del servidor con la lista de los comerciales con pedidos:', data);
    })
    .catch(error => {
      console.error('Error al leer los comerciales:', error);
    });
});

//////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////7
document.getElementById('leercomercialesporidclienteBtn').addEventListener('click', function() {
  const idCliente = document.getElementById('idInput4').value;

  // Realizar la solicitud GET
  fetch('http://localhost:8085/comercial/bycliente/'+idCliente, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(respuesta => {
    if (respuesta.ok) {
      // Si la respuesta es exitosa, convertir la respuesta a JSON
      return respuesta.json();
    } else {
      return respuesta.text().then(mensajeJava => {
        throw new Error(mensajeJava); // Lanzar un error con el mensaje de error devuelto por el servidor
      });
    }
  })
  .then(data => {
    console.log('Respuesta del servidor:', data); //Mensaje del servidor
  })
  .catch(error => {
    console.error('Error en la solicitud:', error);
    alert('Error en la solicitud: ' + error); // Muestra el mensaje de error devuelto por JavaScript
  });
});
