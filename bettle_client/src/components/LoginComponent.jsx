import React, {useState} from "react";
import UserService from "../services/UserService";
function LoginComponent ({setName,getName}) {

    const [details, setDetails] = useState({username: "", password: ""});
    const [errmsg, setErrMsg] = useState({errmsg: ""});

    const handleLogin = e => {
        e.preventDefault();

        const response = UserService.logIn(details);
        if(response !== true){
            setErrMsg({errmsg : response});
            setName("Usman");
        }else{
            setName(details.username);
        }

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