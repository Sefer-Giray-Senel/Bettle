import React, {useState} from "react";
import { Link , Navigate} from "react-router-dom";
import UserService from "../services/UserService";

function RegisterComponent (/*{setName,getName}*/) {

    const [details, setDetails] = useState({username: "", password: "", role: "", firstname: "", lastname:"", gender:"", email:"",nationality:""});
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
                    <label>Username:</label>
                    <input type="text" name="username" id="username" onChange={e => setDetails({...details, username: e.target.value})} value={details.username}/>
                </div>
                <div className="form-group">
                    <label>Password:</label>
                    <input type="password" name="password" id="password" onChange={e => setDetails({...details, password: e.target.value})} value={details.password}/>
                </div>

                <div className="form-group">
                    <label>Firstname:</label>
                    <input type="text" name="firstname" id="firstname" onChange={e => setDetails({...details, firstname: e.target.value})} value={details.firstname}/>
                </div>
                <div className="form-group">
                    <label>Lastname:</label>
                    <input type="text" name="lastname" id="lastname" onChange={e => setDetails({...details, lastname: e.target.value})} value={details.lastname}/>
                </div>
                <div className="form-group">
                    <label>Gender:</label>
                    <input type="text" name="gender" id="gender" onChange={e => setDetails({...details, gender: e.target.value})} value={details.gender}/>
                </div>
                <div className="form-group">
                    <label>Email:</label>
                    <input type="text" name="email" id="email" onChange={e => setDetails({...details, email: e.target.value})} value={details.email}/>
                </div>
                <div className="form-group">
                    <label>Nationality:</label>
                    <input type="text" name="nationality" id="nationality" onChange={e => setDetails({...details, nationality: e.target.value})} value={details.nationality}/>
                </div>

                <div className="form-group">
                    <label>Role:</label>
                    <select className="custom-select" id="role" onChange={e => setDetails({...details, role: e.target.value})} value={details.role}>
                        <option defaultValue>Choose...</option>
                        <option value="editor">Editor</option>
                        <option value="bettor">Bettor</option>
                    </select>
                </div>
                <div className="formbtn"><button className="loginbtn">Register</button>
                    <Link className="registerbtn" to="/login">Login</Link>
                </div>
            </div>
            <div>{errmsg.message}</div>
            
            { success.state ? (<Navigate push to="/login"/>) : null }
        </form>
            
    );
    
}
 
export default RegisterComponent;