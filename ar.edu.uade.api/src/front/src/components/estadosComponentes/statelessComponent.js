import React from 'react';

function StatlessComponent(props) {
    return (
        <div>
            <p>Este es un componente Stateless.</p>
            <p>Propiedad recibida: {props.message}</p>
        </div>
    );
}

export default StatlessComponent;