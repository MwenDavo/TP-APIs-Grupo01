import React, { useEffect, useState } from 'react';

function ProcesarDatosApi() {
    const [datos, setDatos] = useState(null);
    const [error, setError] = useState(null);

    async function obtenerDatosDeAPI(callback) {
        try {
            const respuesta = await fetch("https://jsonplaceholder.typicode.com/posts/1");
            if (!respuesta.ok) {
                throw new Error("Error en la solicitud");
            }

            const datos = await respuesta.json();

            callback(null, datos);
        } catch (error) {
            callback(error, null);
        }
    }

    useEffect(() => {
        obtenerDatosDeAPI((err, data) => {
            if (err) {
                setError(err);
            } else {
                setDatos(data);
            }
        })
    }, []);

    return (
        <div>
            <h1>Datos de la API</h1>

            {error ? (
                <p>Error: {error.message}</p>
            ) :/*los dos puntos es un else!*/(
                <div>
                    <h2>Titulo: {datos?.title}</h2>
                    <p>Cuerpo: {datos?.body}</p>
                </div>
            )}
        </div>
    );

}

export default ProcesarDatosApi;