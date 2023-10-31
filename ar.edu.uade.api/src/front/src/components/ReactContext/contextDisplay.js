import React, { useContext } from 'react';
import MyContext from './myContext';

function ContextDisplay() {

    const { userData } = useContext(MyContext);

    return (
        <div>
            <p>Nombre: {userData.firstName}</p>
            <p>Apellido: {userData.lastName}</p>
        </div>
    );
}

export default ContextDisplay;