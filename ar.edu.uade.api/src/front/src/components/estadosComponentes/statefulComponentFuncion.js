import React, { useState } from 'react';


function StatefulComponentFunction() {
    const [count, setCount] = useState(0);

    const incrementCount = () => {
        setCount(count + 1);
    }
    return (
        <div>
            <p>Este es un componente Stateful.</p>
            <p>Contador: {count}</p>
            <button onClick={incrementCount}>Incrementar!</button>
        </div>
    );
}

export default StatefulComponentFunction;