/////////////////////////////////////////////////////////////////////////////////////////////7
document.getElementById('leerpedidosporidcomercialBtn').addEventListener('click', function() {
    const idComercial = document.getElementById('idInput3').value;
  
    // Realizar la solicitud GET
    fetch('http://localhost:8085/comercial/pedidos/'+idComercial, {
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
    