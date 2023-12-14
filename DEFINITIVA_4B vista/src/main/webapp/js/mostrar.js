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
            <button type="submit" class="btn btn-primary" id="modificar"><a href="modificar.html?id=${Tarea.id}">EDITAR</button>
        </td>
        <td class="align-items-center">
            <button type="submit" class="btn btn-primary" id="eliminar"><a href="eliminar.html?id=${Tarea.id}">ELIMINAR</button>
        </td>
      </tr>
</div>`)
div.innerHTML=content
}

getTareas()