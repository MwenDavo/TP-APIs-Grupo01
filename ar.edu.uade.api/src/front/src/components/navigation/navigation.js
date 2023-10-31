import React from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";
import Contacto from '../Contacto/contacto';
import Home from '../Home/home';
import AboutUs from '../aboutUs/aboutus';
import Error404 from '../Error/error404';

function Navigation() {
    return (
        <Router>
            <div>
                <header>
                    <nav>
                        <ul>
                            <li>
                                <Link to="/">Inicio</Link>
                            </li>
                            <li>
                                <Link to="/acerca-de">About Us</Link>
                            </li>
                            <li>
                                <Link to="/contacto">Contacto</Link>
                            </li>
                        </ul>
                    </nav>
                </header>
                <Routes>
                    <Route path='/' element={<Home />} />
                    <Route path='/acerca-de' element={<AboutUs />} />
                    <Route path='/contacto/' element={<Contacto />} />
                    <Route path='*' element={<Error404 />} />
                </Routes>
            </div>
        </Router>
    );
}

export default Navigation;