import React, {useState} from "react";
import { Link } from "react-router-dom";
import UserService from "../services/UserService";
import "../css/login.css";

function LoginComponent ({setName}) {

    const [details, setDetails] = useState({username: "", password: ""});
    const [errmsg, setErrMsg] = useState({message : ""});

    const handleLogin = e => {
        e.preventDefault();

        const response = UserService.logIn(details);

        response.then(value => {
            console.log(value);
            if(value !== true){
                setErrMsg({message : value.message});
            }
            else{
                setName(details.username);
            }
        });

    }

    return (
        <form className="form-properties" onSubmit={handleLogin}>
            <div className="form-inner">
                <div className="form-group">
                    <label >Username: </label>
                    <input type="text" name="username" id="username" onChange={e => setDetails({...details, username: e.target.value})} value={details.username}/>
                </div>
                <div className="form-group">
                    <label>Password: </label>
                    <input type="password" name="password" id="password" onChange={e => setDetails({...details, password: e.target.value})} value={details.password}/>
                </div>
                <button className="loginbtn">Log in</button>
            </div>
            <Link to="/register">Register</Link>
            <div>{errmsg.message}</div>
        </form>
    );
    
}
 
export default LoginComponent;