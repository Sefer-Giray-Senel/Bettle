import axios from "axios";

class UserService{

    getUsers(){
        return axios.get("http://localhost:8080/api/users");
    }

    logIn(details){
        return axios.post("http://localhost:8080/login", details);
    }

}

export default new UserService();