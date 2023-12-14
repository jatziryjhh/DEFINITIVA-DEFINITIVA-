const getTareas= async ()=>{
const response = await fetch("http://localhost:8080/api/tareas/")
    const data = await response.json();
    console.log(data);
let content=""
const div=document.getElementById("container")
data.map(Tarea=>content+=`<div>
<tr>
      <td>${Tarea.id}</td>
        <td>${Tarea.nombre}</td>
        <td>${Tarea.descripcion}</td>
        <td>${Tarea.fecha}</td>
        <td>${Tarea.estado}</td>

        <td class="align-items-center">
            <a class="btn btn-primary" href="modificar.html?id=${estado}" id="editarEnlace">Editar</a>
        </td>
        <td class="align-items-center">
            <a class="btn btn-danger" href="eliminar.html?id=${id}" id="editarEnlace">Eliminar</a>
        </td>
      </tr>
</div>`)
div.innerHTML=content
}

getTareas()