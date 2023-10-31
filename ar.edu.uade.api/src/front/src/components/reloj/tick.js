import React from "react";

function Tick() {
    return (
        <div>
            <h4>{new Date().toLocaleTimeString()}</h4>
        </div>
    );
}

export default Tick;