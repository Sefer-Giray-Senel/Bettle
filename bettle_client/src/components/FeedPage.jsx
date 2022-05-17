import React from "react";
import { Navigate } from "react-router-dom";
import PostService from "../services/PostService";

class FeedPage extends React.Component {
    state = { 
        posts: []
    } 

    componentDidMount(){
        PostService.getFeed().then((response) => this.setState({posts:response.data}, function() {
            console.log(this.state)
        }));
    }
    
    render() {
        return (
        <div>
            { this.props.getName() === "" ? (<Navigate push to="/"/>) : null }
            <ul className="list-group">
                {this.state.posts.map((post) =>
                <li key={post.betSlipId}>
                    <a href="#">{post.betSlipId}</a>
                    <ul className="list-group">
                        {post.bets.map((bet) => <li className="list-group-item" key={bet.id}>{bet.title}</li>)}
                    </ul>
                </li>
                )} 
            </ul>
        </div>
        );
    }
}
 
export default FeedPage;