import React from 'react';

function Sumar(props) {
    const { a, b } = props; // a y b
    return (
        <div>
            El resultado de la suma de {a} y {b} es: {suma(a, b)}
        </div>
    );
}

function suma(a, b) {
    return a + b;
}

export default Sumar;