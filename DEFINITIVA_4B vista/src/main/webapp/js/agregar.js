document.getElementById('formularioAgregar').addEventListener('submit',function (event) {
    event.preventDefault();

    let nombre = document.getElementById('nombre').value;
    let descripcion = document.getElementById('descripcion').value;
    let fecha = document.getElementById('fecha').value;

    const tarea = {
        nombre: nombre,
        descripcion: descripcion,
        fecha: fecha
    };

});

function guardarTarea(tarea){
    fetch('http://localhost:8080/api/tareas/',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(tarea)
    }).then(response =>{
        if (response.ok){
            console.log('Tarea guardada exitosamente');
        }else{
            console.log('Error al guardar la tarea');
        }
    })
        .catch(error=>{
            console.log(error);
        });
}

guardarTarea()