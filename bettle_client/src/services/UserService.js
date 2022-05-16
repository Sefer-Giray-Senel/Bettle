import axios from "axios";
class UserService{

    getUsers(){
        return axios.get("http://localhost:8080/users", {
            headers: {
            Authorization: localStorage.getItem('token')
            }
          });
    }

    async logIn(details){
        try{
            const response = await axios.post("http://localhost:8080/login", {}, {
                params: {
                    username: details.username,
                    password: details.password
                }
            });
            localStorage.setItem('token', response.data.token);
            localStorage.setItem('username', details.username);
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
            return true;
        }
        catch(e){
            console.log(e);
            return e;
        }
    }

}

export default new UserService();