import React from "react";
import logo from '../logo.svg';

function HomeComponent(){
    return(
        <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <p>Welcome to Bettle!</p>
        </header>
    );
}

export default HomeComponent;