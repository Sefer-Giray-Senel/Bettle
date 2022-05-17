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

    createPost(caption, betSlipId){
        return axios.post("http://localhost:8080/feed/share-bet-slip", {}, {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                bet_slip_id: betSlipId,
                user_id: localStorage.getItem('id'),
                post_text: caption
            }
        });
    }

    getFeed(){
        return axios.get("http://localhost:8080/feed", {
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