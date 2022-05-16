import React from "react";
import { NavLink } from "react-router-dom";

function NavBar({setName,getName}){
    return(
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <NavLink to="/" className="nav-links">Bettle</NavLink>
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div className="navbar-nav">
                <NavLink to="/home" className={(navData)=> navData.isActive ? "nav-links-active" : "nav-links"}>Home</NavLink>
                {(getName() === "") ? "" : 
                <div className="navbar-nav">
                    <NavLink to="/users" className={(navData)=> navData.isActive ? "nav-links-active" : "nav-links"}>Users</NavLink>
                    <NavLink to="/profile" className={(navData)=> navData.isActive ? "nav-links-active" : "nav-links"}>Profile</NavLink>
                    <NavLink to="betslip" className={(navData)=> navData.isActive ? "nav-links-active" : "nav-links"}>Bet</NavLink>
                    <NavLink to="/feed" className={(navData)=> navData.isActive ? "nav-links-active" : "nav-links"}>Feed</NavLink>
                    <button onClick={() => setName("")}>Logout</button>
                </div>}
          </div>
        </div>
      </nav>
    );
}

export default NavBar;