import axios from "axios";
class UserService{

    getUsers(){
        return axios.get("http://localhost:8080/users");
    }

    async logIn(details){
        try{
            const response = await axios.post("http://localhost:8080/login", {}, {
                params: {
                    username: details.username,
                    password: details.password
                }
              });
            localStorage.setItem('token', response.data);
            return true;
        }
        catch(e){
            console.log(e);
            return e;
        }
    }

    async register(details){
        try{
            const response = await axios.post("http://localhost:8080/register", details);
            return response;
        }
        catch(e){
            console.log(e);
            return e;
        }
    }

}

export default new UserService();