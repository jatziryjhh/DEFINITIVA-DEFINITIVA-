let url = 'http://localhost:8080/api/tareas/{id}';

const mostrarPorEstado = ({estado }) => {
    document.getElementById('estado').value = estado;
};


fetch(url, {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
})
    .then(response => response.json())
    .then(tarea => {
        console.log(tarea);
        tarea.map(item => mostrarPorEstado(item));
    })
    .catch(error => {
        console.log(error);
    });

