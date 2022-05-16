import React, {useState} from "react";
import { Link , Navigate} from "react-router-dom";
import UserService from "../services/UserService";

function RegisterComponent (/*{setName,getName}*/) {

    const [details, setDetails] = useState({username: "", password: "", role: ""});
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
                <div className="input-group mb-3">
                    <div className="input-group-prepend">
                        <label className="input-group-text" htmlFor="inputGroupSelect01">Role</label>
                    </div>
                    <select className="custom-select" id="inputGroupSelect01" onChange={e => setDetails({...details, role: e.target.value})} value={details.role}>
                        <option defaultValue>Choose...</option>
                        <option value="editor">Editor</option>
                        <option value="bettor">Bettor</option>
                    </select>
                </div>
                <button>Register</button>
            </div>
            <Link to="/">Login</Link>
            <div>{errmsg.message}</div>
            
            { success.state ? (<Navigate push to="/"/>) : null }
        </form>
            
    );
    
}
 
export default RegisterComponent;