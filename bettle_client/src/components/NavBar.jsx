import React from "react";
import { NavLink } from "react-router-dom";

function NavBar(){
    return(
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a href="javascript:void(0);" class="navbar-brand m-2" >Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
                <NavLink to="/" className={(navData)=> navData.isActive ? '' : "nav-links"}><a href="javascript:void(0);" class="nav-item nav-link">Home</a></NavLink>
                <NavLink to="/users" className={(navData)=> navData.isActive ? '' : "nav-links"}><a href="javascript:void(0);" class="nav-item nav-link">Users</a></NavLink>
                <a href="javascript:void(0);" class="nav-item nav-link">Pricing</a>
                <a href="javascript:void(0);" class="nav-item nav-link disabled" tabindex="-1" aria-disabled="true">Disabled</a>
          </div>
        </div>
      </nav>
    );
}

export default NavBar;