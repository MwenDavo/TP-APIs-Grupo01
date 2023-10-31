import React, { useContext } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate, Outlet } from 'react-router-dom';
import Home from '../Home/home';
import AboutUs from '../aboutUs/aboutus';
import Contacto from '../Contacto/contacto';
import Error404 from '../Error/error404';
import NavBar from './navbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import ContactUs from '../Contacto/contact';
import ContactUsBoot from '../Contacto/contactusbootstrap';
import ContextEjemplo from '../ReactContext/contextEjemplo';
import ContextDisplay from '../ReactContext/contextDisplay';
import DisplayEdificios from '../DisplayEdificios/displayEdificios';
import DisplayEdificios2 from '../DisplayEdificios/displayEdificiosV2';
import Login from '../Login/login';
import MyContext from '../ReactContext/myContext';
import PrivateRoute from './privateRoute';


function NavigationBoot({ loggedIn, user, onLogin, onLogout }) {
    return (
        <Router>
            <div>
                <NavBar loggedIn={loggedIn} user={user} onLogout={onLogout} />
                <Routes>
                    <Route path="/" element={<Outlet />}>
                        <Route path='/' element={<Home />} />
                        <Route path='/login' element={<Login />} />
                        <Route path='/edificios' element={<DisplayEdificios />} />
                        <Route path='/acerca-de' element={<AboutUs />} />
                        <Route path='*' element={<Error404 />} />
                        <Route path='/contact' element={<ContactUsBoot />} />
                        <Route path='/context' element={<ContextEjemplo />} />
                        <Route path='/contextDisplay' element={<ContextDisplay />} />
                    </Route>
                </Routes>
            </div>
        </Router>
    );
}

export default NavigationBoot;