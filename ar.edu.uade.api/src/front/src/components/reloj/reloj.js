import React from "react";
import Tick from "./tick";
import TickDinamico from "./tickDinamico";
import TickDinamicoFuncion from "./tickDinamicoFuncion";

function Reloj() {
    return (
        <div>
            <h1>Hora Actual: </h1>
            {/*<Tick />
            <TickDinamico />*/}
            <TickDinamicoFuncion />
        </div>
    );
}

export default Reloj;