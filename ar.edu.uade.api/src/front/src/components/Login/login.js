import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from '../api/api';

function Login({ onLogin }) {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = async () => {
        try {
            const data = await login(username, password);
            onLogin(username); // Assuming onLogin updates the loggedIn state in App.js
            navigate('/'); // Redirect to the home page after successful login
        } catch (error) {
            console.error('Login failed:', error);
            // Handle login failure, show an error message, etc.
        }
    };


    return <div className={"mainContainer"}>
        <div className={"titleContainer"}>
            <div>Inicio de Sesion</div>
        </div>
        <br />
        <div className={"inputContainer"}>
            <input
                type="text"
                value={username}
                placeholder="Ingrese su usuario"
                onChange={(e) => setUsername(e.target.value)}
                className={"inputBox"} />
        </div>
        <br />
        <div className={"inputContainer"}>
            <input
                type="password"
                value={password}
                placeholder="Ingrese su contraseña"
                onChange={(e) => setPassword(e.target.value)}
                className={"inputBox"} />
        </div>
        <br />
        <div className={"inputContainer"}>
            <input
                className={"inputButton"}
                type="button"
                value={"Log in"}
                onClick={handleLogin} />
        </div>
    </div>
}

export default Login;