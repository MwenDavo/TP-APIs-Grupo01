import MiApp from './components/saludo/miApp'
import Reloj from './components/reloj/reloj';
import PropiedadesEjemplo from './components/propiedadesejemplo/propiedadesEjemplo';
import StatlessComponent from './components/estadosComponentes/statelessComponent';
import StatefulComponent from './components/estadosComponentes/statefulComponent';
import StatefulComponentFunction from './components/estadosComponentes/statefulComponentFuncion';
import ProcesarDatosApi from './components/functionCallback/procesarDatosApi';
import Navigation from './components/navigation/navigation';
import NavigationBoot from './components/NavigationBootstrap/navigationBoot';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import { MyProvider } from './components/ReactContext/myContext';
import './App.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import React, { useState } from 'react';
import "react-bootstrap/dist/react-bootstrap.min.js";


function App() {
  const [loggedIn, setLoggedIn] = useState(false);
  const [user, setUser] = useState("");

  const handleLogin = (username) => {
    setLoggedIn(true);
    setUser(username);
  };

  const handleLogout = () => {
    setLoggedIn(false);
    setUser("");
  };


  return (
    <MyProvider>
      <NavigationBoot loggedIn={loggedIn}
        user={user}
        onLogin={handleLogin}
        onLogout={handleLogout} />
    </MyProvider >
  );
}

export default App;