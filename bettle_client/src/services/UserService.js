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
            localStorage.setItem('id', response.data.id);
            localStorage.setItem('username', details.username);
            return true;
        }
        catch(e){
            console.log(e);
            return e;
        }
    }

    async register(details){
        console.log(details);
        try{
            await axios.post("http://localhost:8080/register", {}, {
                params: {
                    username: details.username,
                    password: details.password,
                    role: details.role
                }
            });
            return true;
        }
        catch(e){
            console.log(e);
            return e;
        }
    }

    
    getUser(){
        return axios.get("http://localhost:8080/register");
    }

}

export default new UserService();