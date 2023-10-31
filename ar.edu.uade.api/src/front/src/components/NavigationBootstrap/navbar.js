import React from 'react';
import { Link } from "react-router-dom";
import EdificioIcono from '../Iconos/edificioIcono';

const NavBar = () => {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark" style={{ paddingLeft: 20 }}>
                <a className="navbar-brand" href="/"><EdificioIcono />Consorcio COUM</a>
                <div className="collapse navbar-collapse" id='navbarNav'>
                    <ul className="navbar-nav">
                        <li className='nav-item'>
                            <Link to="/" className='nav-link'>Inicio</Link>
                        </li>
                        <li className='nav-item'>
                            <Link to="/acerca-de" className='nav-link'>About Us</Link>
                        </li>
                        <li className='nav-item'>
                            <Link to="/contact" className='nav-link'>Contactanos</Link>
                        </li>
                        <li className='nav-item'>
                            <Link to="/context" className='nav-link'>Contexto</Link>
                        </li>
                        <li className='nav-item'>
                            <Link to="/contextDisplay" className='nav-link'>Context Display</Link>
                        </li>
                    </ul>
                </div>
            </nav >
        </div>
    );
};

export default NavBar;