import React from "react";

class Saludo extends React.Component {
    render() {
        return <h2>Hola {this.props.name}, bienvenido al sistema de gestion del consorcio.</h2>
    }
}

export default Saludo;