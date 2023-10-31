import React, { useContext } from 'react';
import MyContext from './myContext';

function ContextEjemplo() {

    const { userData, setUserData } = useContext(MyContext);

    const handleFirstNameChange = (nuevoNombre) => {
        setUserData({ ...userData, firstName: nuevoNombre });
    }
    const handleLastNameChange = (nuevoNombre) => {
        setUserData({ ...userData, lastName: nuevoNombre });
    }

    return (
        <div>
            <p>Nombre: {userData.firstName}</p>
            <p>Apellido: {userData.lastName}</p>
            <input
                type='text'
                value={userData.firstName}
                onChange={(e) => handleFirstNameChange(e.target.value)}
            />
            <input
                type='text'
                value={userData.lastName}
                onChange={(e) => handleLastNameChange(e.target.value)}
            />
        </div>
    );
}

export default ContextEjemplo;