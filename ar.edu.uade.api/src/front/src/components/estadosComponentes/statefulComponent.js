import React, { Component } from 'react';

class StatefulComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0,
        }
    }

    incrementCount = () => {
        this.setState({ count: this.state.count + 1 });
    }

    render() {
        return (
            <div>
                <p>Este es un componente Stateful.</p>
                <p>Contador: {this.state.count}</p>
                <button onClick={this.incrementCount}>Incrementar!</button>
            </div>
        );
    }

}

export default StatefulComponent;