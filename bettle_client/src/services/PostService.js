import axios from "axios";
class PostService{

    getPosts(){
        return axios.get("http://localhost:8080/feed/posted", {
            headers: {
            Authorization: localStorage.getItem('token')
            },
            params: {
                user_id: localStorage.getItem('id')
            }
        });
    }

    getFeed(){
        return axios.get("http://localhost:8080/", {
            headers: {
            Authorization: localStorage.getItem('token')
            },
            params: {
                user_id: localStorage.getItem('id')
            }
        });
    }
}

export default new PostService();