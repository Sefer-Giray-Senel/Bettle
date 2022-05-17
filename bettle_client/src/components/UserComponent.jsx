import React from "react";
import UserService from "../services/UserService";
import { Navigate } from "react-router-dom";

class UserComponent extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount(){
        UserService.getUsers().then((response) => {
            this.setState({users : response.data})
        });
    }

    handleAddFriend = (bettorId) => {
        UserService.addFriend(bettorId);
        window.location.reload(false);
    }

    handleRemoveFriend = (bettorId) => {
        UserService.removeFriend(bettorId);
        window.location.reload(false);
    }

    handleSubscribe = (editorId) => {
        UserService.subscribe(editorId);
        window.location.reload(false);
    }

    handleUnsubscribe = (editorId) => {
        UserService.unsubscribe(editorId);
        window.location.reload(false);
    }

    render(){
        return (
            <div>
                { this.props.getName() === "" ? (<Navigate push to="/login"/>) : null }
                <h1 className="text-center">Users List</h1>
                <table className ="table table-striped">
                    <thead>
                        <tr>
                            <td>Username</td>
                        </tr>
                    </thead>
                    <tbody>
                    {
                            this.state.users.map(
                                user =>
                                <tr key = {user.id}>
                                    <td>{user.username}</td>
                                    <td>
                                        { user.editor ? 
                                            <div>{ user.subscribed ? 
                                                <button onClick={() => this.handleUnsubscribe(user.id)}>Unsubscribe</button>
                                                : <button onClick={() => this.handleSubscribe(user.id)}>Subscribe</button>
                                            }</div>
                                            :
                                            <div>{ user.friend ? 
                                                <button onClick={() => this.handleRemoveFriend(user.id)}>Remove Friend</button>
                                                : <button onClick={() => this.handleAddFriend(user.id)}>Add Friend{user.isFriend}</button>
                                            }</div>
                                        }
                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        );
    }
}

export default UserComponent;