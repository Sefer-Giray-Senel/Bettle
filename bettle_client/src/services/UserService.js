import axios from "axios";
class UserService{

    getUsers(){
        return axios.get("http://localhost:8080/users", {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                user_id : localStorage.getItem('id')
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
        return axios.get("http://localhost:8080/social-user/profile", {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                user_id: localStorage.getItem('id'),
                social_user_id: localStorage.getItem('id')
            } 
        });
    }

    addFriend(bettorId){
        return axios.post("http://localhost:8080/bettor/add-friend", {}, {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                first_bettor_id: localStorage.getItem('id'),
                second_bettor_id: bettorId 
            } 
        })
    }

    removeFriend(bettorId){
        return axios.post("http://localhost:8080/bettor/remove-friend", {}, {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                user_id: localStorage.getItem('id'),
                friend_id: bettorId 
            } 
        })
    }

    subscribe(editorId){
        return axios.post("http://localhost:8080/social-user", {}, {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                bettor_id: localStorage.getItem('id'),
                editor_id: editorId 
            }
        })
    }

    unsubscribe(editorId){
        return axios.post("http://localhost:8080/bettor/remove-subscribed-editor", {}, {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                user_id: localStorage.getItem('id'),
                editor_id: editorId 
            }
        })
    }

    

}

export default new UserService();