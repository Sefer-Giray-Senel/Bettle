import React, {useState} from "react";
import { Link , Navigate} from "react-router-dom";
import UserService from "../services/UserService";

function RegisterComponent (/*{setName,getName}*/) {

    const [details, setDetails] = useState({username: "", password: ""});
    const [errmsg, setErrMsg] = useState({message : ""});
    const [success, setSuccess] = useState({state: false});

    const handleRegister = (e) => {
        e.preventDefault();

        const response = UserService.register(details);
        response.then(value => {
            if(value !== true){
                setErrMsg({message : value.message});
            }
            else{
                setSuccess({state: true});
            }
        });
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
            <div>{errmsg.message}</div>

            <div className="alert alert-danger" role="alert">
                {errmsg.message}
            </div>
            
            { success.state ? (<Navigate push to="/"/>) : null }
        </form>
            
    );
    
}
 
export default RegisterComponent;