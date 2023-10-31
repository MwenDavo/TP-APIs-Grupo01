import React from 'react';
import { useNavigate } from 'react-router-dom';

const AboutUs = () => {
    const nav = useNavigate();

    function navegarAtras() {
        nav(-1);
    }

    return (
        <div style={{ paddingLeft: 40, paddingTop: 20 }}>
            <h2>Acerca de Nosotros</h2>
            <p>Somos COUM, un consorcio de residencias basado en Buenos Aires, Argentina.</p>

            <div>
                <button onClick={navegarAtras}>Navegar Atrás</button>
            </div>
        </div>
    );
}

export default AboutUs;