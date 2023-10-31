import React, { Component } from 'react';

class TickDinamico extends Component {
    constructor(props) {
        super(props);
        this.state = {
            time: new Date().toLocaleTimeString()
        };
    }

    componentDidMount() {
        this.intervalID = setInterval(() => {
            this.setState({
                time: new Date().toLocaleTimeString(),
            });
        }, 1000);
    }

    componentWillUnmount() {
        clearInterval(this.intervalID);
    }

    render() {
        return (
            <div>
                <h1>{this.state.time}</h1>
            </div>
        );
    }
}

export default TickDinamico;