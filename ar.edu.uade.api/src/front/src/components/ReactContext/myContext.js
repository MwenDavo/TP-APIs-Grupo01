import React, { Children, createContext, useContext, useState } from 'react';

const MyContext = createContext();

export const MyProvider = ({ children }) => {
    const [userData, setUserData] = useState({
        usuario: '',
        contrasenia: ''
    });

    return (
        <MyContext.Provider value={{ userData, setUserData }}>
            {children}
        </MyContext.Provider>
    );
}

export default MyContext;