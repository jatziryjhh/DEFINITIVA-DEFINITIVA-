document.getElementById('editar').addEventListener('submit',function (event) {
    event.preventDefault();

    const estado = document.getElementById('estado').value;

    const tarea = {
       estado: estado
    };
    editarTarea(tarea)
});

function editarTarea(tarea) {
    const url = 'http://localhost:8080/api/tareas/{id}';
    const options = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(tarea)
    }
    .then(response => {
        if (response.ok) {
            console.log('Tarea editada exitosamente');
        } else {
            console.log('Error al editar la tarea');
        }
    })
    .catch(error => {
        console.log("no se puede");
    });
}

editarTarea()
