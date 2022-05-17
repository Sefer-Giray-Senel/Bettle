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
        );
    }
}
 
export default FeedPage;