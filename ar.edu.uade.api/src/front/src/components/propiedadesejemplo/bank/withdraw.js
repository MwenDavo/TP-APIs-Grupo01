import React from 'react';

function Withdraw(props) {

    const { account, amount } = props;

    retirar(account, amount);

    return (
        <div>
            Retiro exitoso de ${amount} de la cuenta de "{account.name}".
        </div>
    );
}

function retirar(account, amount) {
    account.total -= amount;
}

export default Withdraw;