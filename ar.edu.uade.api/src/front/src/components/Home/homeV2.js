import React from 'react';
import foto from './2362696.jpg';
import foto2 from './508840.jpg';
import { Button } from 'react-bootstrap';
import { Link, useNavigate } from "react-router-dom";

const Home = (props) => {
    const { loggedIn, email } = props
    const navigate = useNavigate();

    return (
        <div style={{ paddingLeft: 60, paddingTop: 20, paddingRight: 60 }}>
            <h2>Inicio</h2>
            <p>Bienvenido a la pagia de Inicio.</p>
            <div style={{ display: 'flex', justifyContent: 'center', flexDirection: 'column' }}>
                <Button
                    variant="primary"
                    style={{
                        fontSize: '35px',
                        backgroundImage: `url(${foto})`, // Ruta de tu imagen de fondo
                        backgroundSize: 'cover', // Ajusta el tamaño de la imagen para cubrir el botón
                        color: 'white',
                        border: '1px solid #fff',
                        boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
                        position: 'relative', // Para que los estilos de ::before se apliquen correctamente
                        marginLeft: '30px',
                        marginTop: '20px',
                        borderRadius: '10px',
                        overflow: 'hidden',
                        transition: 'background-image 0.3s ease'
                    }}
                    // Pseudo-clase :hover
                    onMouseOver={(e) => {
                        e.currentTarget.querySelector('span').style.transform = 'scale(1.3)'; // Aplica un aumento de escala al texto
                        e.currentTarget.querySelector('span').style.background = 'rgba(0, 0, 0, 1)';
                    }}
                    onMouseOut={(e) => {
                        e.currentTarget.querySelector('span').style.transform = 'scale(1)'; // Restaura la escala original del texto
                        e.currentTarget.querySelector('span').style.background = 'rgba(0, 0, 0, 0.6)';
                    }}
                ><Link to="/edificios" className='nav-link' style={{ textDecoration: 'none', color: 'inherit', padding: '100px' }}>
                        <span
                            style={{
                                background: 'rgba(0, 0, 0, 0.6)', // Fondo blanco semi-transparente
                                padding: '15px', // Ajusta según sea necesario
                                position: 'relative', // Para que los estilos de ::before se apliquen correctamente
                                borderRadius: '10px', // Agrega esquinas circulares
                                display: 'inline-block', // Para que borderRadius funcione correctamente
                                transition: 'transform 0.5s ease, background 0.5s ease',
                            }}
                        >
                            <i className="fas fa-university" style={{ marginRight: '10px' }} />Acceder a edificios Disponibles
                        </span>
                    </Link>
                </Button>


                <Button
                    className="btn btn-success"
                    style={{
                        fontSize: '35px',

                        boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
                        backgroundImage: `url(${foto2})`,
                        backgroundSize: 'cover',
                        border: '1px solid #fff',
                        marginLeft: '30px',
                        marginTop: '20px',
                        borderRadius: '10px',
                        overflow: 'hidden',
                        transition: 'background-color 0.3s ease', // Cambia el color de fondo al hacer hover
                    }}// Pseudo-clase :hover
                    onMouseOver={(e) => {
                        e.currentTarget.querySelector('span').style.transform = 'scale(1.3)'; // Aplica un aumento de escala al texto
                        e.currentTarget.querySelector('span').style.background = 'rgba(0, 0, 0, 1)';
                    }}
                    onMouseOut={(e) => {
                        e.currentTarget.querySelector('span').style.transform = 'scale(1)'; // Restaura la escala original del texto
                        e.currentTarget.querySelector('span').style.background = 'rgba(0, 0, 0, 0.6)';
                    }}
                >
                    <Link to="/contact" className='nav-link' style={{ textDecoration: 'none', color: 'inherit', padding: '100px' }}>
                        <span
                            style={{
                                background: 'rgba(0, 0, 0, 0.6)', // Fondo blanco semi-transparente
                                padding: '15px', // Ajusta según sea necesario
                                position: 'relative', // Para que los estilos de ::before se apliquen correctamente
                                borderRadius: '10px', // Agrega esquinas circulares
                                display: 'inline-block', // Para que borderRadius funcione correctamente
                                transition: 'transform 0.5s ease, background 0.5s ease',
                            }}
                        ><i className="fas fa-envelope" style={{ marginRight: '10px' }}></i>Contactar con el Consorcio</span>
                    </Link>
                </Button>
            </div>
        </div >

    );
}

export default Home;