import React from "react";
import "../css/profilePage.css";
import UserService from "../services/UserService";

class ProfilePage extends React.Component {
    state = { 
        user: {},
        posts: []
    }
    
    componentDidMount(){
        UserService.getUser().then((response) => this.setState({user:response.data}));
        UserSerivce.getPosts().then((response) => this.setState({posts:response.data}));
    }


    render() { 
        return (<div className="container mt-5">
            <div className="row d-flex justify-content-center">
                <div className="col-md-7">
                    <div className="card p-3 py-4">
                        <div className="text-center">
                            <h5 className="mt-2 mb-0">{user.username}</h5>
                        </div>

                        <div className="text-center mt-3">
                            <span>nationality</span>
                            <div className="px-4 mt-1">
                                <p className="fonts">{user.email}</p>
                            </div>

                            <ul className="list-group">
                                {this.state.posts.map((post) => 
                                <li key={post.id}>
                                    <p className="fonts2">{post.text}</p>
                                    <a href="#">
                                    <img src="https://i.imgur.com/bDLhJiP.jpg" width="350px" height="150"/>
                                    </a>
                                    <ul>
                                        {post.map((bet) => <li key={bet.id}>{}</li>)}
                                    </ul>
                                </li>
                                )} 

                            </ul>

                            <div className="buttons">

                            </div>


                        </div>


                    </div>

                </div>

            </div>

        </div>);
    }
}
 
export default ProfilePage;