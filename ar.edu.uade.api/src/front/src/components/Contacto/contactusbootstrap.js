import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function ContactUsBoot() {
    const nav = useNavigate();
    const [nombre, setNombre] = useState('');
    const [email, setEmail] = useState('');
    const [enviado, setEnviado] = useState(false);

    const handleNombreChange = (event) => {
        setNombre(event.target.value);
    }

    const handleEmailChange = (event) => {
        setEmail(event.target.value)
    }

    const reiniciarFormulario = () => {
        setEnviado(false);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(`Nombre: ${nombre}, Email: ${email}`);
        setEnviado(true);
    }

    return (
        <div style={{ paddingLeft: 40, paddingTop: 20 }}>
            <h2>Contactanos</h2>
            <p>Dejanos tu mensaje.</p>

            <div className='container mt-4' >
                <div className='row'>
                    <div className='col-md-6 offset-md-3'>
                        <div className='card bg-dark text-white'>
                            <div className='card-body'>
                                {enviado ? (
                                    <>
                                        <div className='alert alert-success' role='alert'>
                                            Los datos se enviaron correctamente! Gracias por contactarte con nosotros.
                                        </div>
                                        <div>
                                            <button onClick={reiniciarFormulario}>Volver al formulario</button>
                                        </div>
                                    </>
                                ) : (<form onSubmit={handleSubmit}>
                                    <div className='form-group mb-3'>
                                        <label>Nombre:</label>
                                        <input
                                            type='text'
                                            className='form-control'
                                            value={nombre}
                                            onChange={handleNombreChange}
                                        />
                                    </div>
                                    <div className='form-group mb-3'>
                                        <label>Email:</label>
                                        <input
                                            type='email'
                                            className='form-control'
                                            value={email}
                                            onChange={handleEmailChange}
                                        />
                                    </div>
                                    <button type='submit' className='btn btn-primary'>Enviar</button>
                                </form>
                                )}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
export default ContactUsBoot;