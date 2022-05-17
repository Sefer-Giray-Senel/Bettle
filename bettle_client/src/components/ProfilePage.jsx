import React from "react";
import "../css/profilePage.css";
import { Navigate } from "react-router-dom";
import UserService from "../services/UserService";
import PostService from "../services/PostService";

class ProfilePage extends React.Component {
    state = { 
        user: {},
        posts: []
    }
    
    componentDidMount(){
        UserService.getUser().then((response) => this.setState({user:response.data}));
        PostService.getPosts().then((response) => this.setState({posts:response.data}));
    }


    render() { 
        return (<div className="container mt-5">
            { this.props.getName() === "" ? (<Navigate push to="/"/>) : null }
            <div className="row d-flex justify-content-center">
                <div className="col-md-7">
                    <div className="card p-3 py-4">
                        <div className="text-center">
                            <h5 className="mt-2 mb-0">{this.state.user.firstName} {this.state.user.lastName}</h5>
                            <h5 className="mt-2 mb-0">({this.state.user.username})</h5>
                        </div>

                        <div className="text-center mt-3">
                            <span>Nationality: {this.state.user.nationality}</span>
                            <div className="px-4 mt-1">
                                <p className="fonts">{this.state.user.email}</p>
                            </div>

                            <ul className="list-group">
                                {this.state.posts.map((post) => 
                                <li key={post.betSlipId}>
                                    <img src="https://i.imgur.com/bDLhJiP.jpg" width="350px" height="150"/>
                                    <ul className="list-group">
                                        {post.bets.map((bet) => <li className="list-group-item" key={bet.bet.id}>
                                            {bet.game.firstTeamName} - {bet.game.secondTeamName} ( {bet.game.date} ) {bet.bet.title}</li>)}
                                    </ul>
                                    <p className="font-weight-bold">{post.username}</p>
                                    <p className="font-weight-normal">{post.text}</p>
                                    <span className="badge badge-pill badge-primary">{post.likeCount} likes</span>
                                </li>
                                )} 
                            </ul>

                        </div>
                    </div>
                </div>
            </div>
        </div>);
    }
}
 
export default ProfilePage;