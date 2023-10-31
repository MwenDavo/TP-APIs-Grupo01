import React, { useState } from 'react';

function ContactUs() {

    const [nombre, setNombre] = useState('');
    const [email, setEmail] = useState('');
    const [enviado, setEnviado] = useState(false);

    const handleNombreChange = (event) => {
        setNombre(event.target.value);
    }

    const handleEmailChange = (event) => {
        setEmail(event.target.value)
    }

    const handleSubmit = (event) => {
        event.preventDefault();

        setEnviado(true);
    }

    return (
        <div>
            {enviado ? (<p>Los datos se enviaron correctamente! Gracias por contactarte con nosotros.</p>) :
                (<form onSubmit={handleSubmit}>
                    <div>
                        <label>Nombre:</label>
                        <input
                            type='text'
                            value={nombre}
                            onChange={handleNombreChange}
                        />
                    </div>
                    <div>
                        <label>Email:</label>
                        <input
                            type='email'
                            value={email}
                            onChange={handleEmailChange}
                        />
                    </div>
                    <button type='submit'>Contactarse</button>
                </form>)}


        </div>
    );
}

export default ContactUs;