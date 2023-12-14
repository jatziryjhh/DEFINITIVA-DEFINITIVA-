function eliminarTarea(TareasPendientes) {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question("INGRESA EL ÍNDICE DE LA TAREA QUE DESEAS ELIMINAR: ", function (indice) {
        if (indice >= 0 && indice < TareasPendientes.length) {
            TareasPendientes.splice(indice, 1);
            console.log("LA TAREA SE ELIMINÓ EXITOSAMENTE.");
        } else {
            console.log("EL ÍNDICE DE TAREA ES INVÁLIDO.");
        }
        rl.close();
    });
}

module.exports = eliminarTarea;