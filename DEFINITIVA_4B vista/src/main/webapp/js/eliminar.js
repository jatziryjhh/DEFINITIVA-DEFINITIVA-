function eliminarTarea(id){
    const url = 'http://localhost:8080/api/tareas/{id}';

    const options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        }
    };
    fetch(url, options)
        .then(response=> {
            if (response.ok) {
                console.log('Tarea eliminada exitosamente');
            } else {
                console.log('Error al eliminar la tarea');
            }
        })
        .catch(error=>{
            console.log("no se puede");
        });
}
eliminarTarea()