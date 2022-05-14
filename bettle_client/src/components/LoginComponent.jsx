import React, {useState} from "react";
import UserService from "../services/UserService";

function LoginComponent () {

    const [details, setDetails] = useState({username: "", password: ""});

    const handleLogin = e => {
        e.preventDefault();

        UserService.logIn(details);
    }

    return (
        <form onSubmit={handleLogin}>
            <div className="form-inner">
                <div className="form-group">
                    <label htmlFor="username">Username</label>
                    <input type="text" name="username" id="username" onChange={e => setDetails({...details, username: e.target.value})} value={details.username}/>
                </div>
                <div className="form-group">
                    <label htmlFor="Password">Password</label>
                    <input type="password" name="password" id="password" onChange={e => setDetails({...details, password: e.target.value})} value={details.password}/>
                </div>
                <button>Log in</button>
            </div>
        </form>
            
    );
    
}
 
export default LoginComponent;