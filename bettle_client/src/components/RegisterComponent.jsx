import React, {useState} from "react";
import { Link } from "react-router-dom";
import UserService from "../services/UserService";

function RegisterComponent (/*{setName,getName}*/) {

    const [details, setDetails] = useState({username: "", password: ""});
    const [errmsg, setErrMsg] = useState({errmsg: ""});

    const handleRegister = e => {
        e.preventDefault();

        const response = UserService.register(details);
        if(response.type !== Promise){
            setErrMsg({errmsg : response});
        }else{
            //setName(details.username);
        }

    }

    return (
        <form onSubmit={handleRegister}>
            <div className="form-inner">
                <div className="form-group">
                    <label htmlFor="username">Username</label>
                    <input type="text" name="username" id="username" onChange={e => setDetails({...details, username: e.target.value})} value={details.username}/>
                </div>
                <div className="form-group">
                    <label htmlFor="Password">Password</label>
                    <input type="password" name="password" id="password" onChange={e => setDetails({...details, password: e.target.value})} value={details.password}/>
                </div>
                <button>Register</button>
            </div>
            <Link to="/">Login</Link>
        </form>
            
    );
    
}
 
export default RegisterComponent;