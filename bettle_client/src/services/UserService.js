import axios from "axios";
class UserService{

    getUsers(){
        return axios.get("http://localhost:8080/api/users");
    }

    async logIn(details){
        try{
            const response = await axios.post("http://localhost:8080/login", details);
            return response;
        }
        catch(e){
            console.log(e);
            return e;
        }
    }

}

export default new UserService();