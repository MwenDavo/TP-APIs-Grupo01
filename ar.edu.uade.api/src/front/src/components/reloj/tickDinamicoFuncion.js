import React, { useEffect, useState } from "react";

function TickDinamicoFuncion() {
    const [time, setTime] = useState(new Date().toLocaleTimeString());
    useEffect(() => {
        const intervalID = setInterval(() => {
            setTime(new Date().toLocaleTimeString());
        }, 1000);

        return () => {
            clearInterval(intervalID);
        }
    }, []);

    return (
        <div>
            <h4>Son las {time}!</h4>
        </div>
    );
}

export default TickDinamicoFuncion;