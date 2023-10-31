import React from 'react';
import Sumar from './suma/sumar';
import Withdraw from './bank/withdraw';


function PropiedadesEjemplo() {
    const initalBalance = 1000;
    const withdrawalAmount = 200;

    const account = {
        name: "Mi cuenta",
        total: initalBalance,
    };

    return (
        <div>
            <h1>Ejemplo Propiedades</h1>
            <Sumar a={10} b={20} />
            <Withdraw account={account} amount={withdrawalAmount} />
            <div>
                El saldo de la cuenta "{account.name}" es <span style={{ fontWeight: 'bold', color: 'red' }}>{account.total}</span>
            </div>
        </div>
    );
}

export default PropiedadesEjemplo;