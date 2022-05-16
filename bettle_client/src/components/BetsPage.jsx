import React from "react";
import "../css/profilePage.css";

class BetsPage extends React.Component {
    state = {  } 
    render() { 
        return (
            <ul className="list-group">
                {this.state.posts.map((post) => 
                <li key={post.id}>
                    <p className="fonts2">{post.text}</p>
                    <a href="#">
                    <img src="https://i.imgur.com/bDLhJiP.jpg" width="350px" height="150"/>
                    </a>
                    <ul className="list-group">
                        {post.map((bet) => <li className="list-group-item" key={bet.id}>{bet.title}</li>)}
                    </ul>
                </li>
                )} 
            </ul>
        );
    }
}
 
export default BetsPage;