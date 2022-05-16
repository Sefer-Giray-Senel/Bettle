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

    render(){
        return (
            <div>
                { this.props.getName() === "" ? (<Navigate push to="/"/>) : null }
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
                                <tr key = {user.username}>
                                    <td>{user.username}</td>
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