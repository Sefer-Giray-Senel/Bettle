import React from "react";
import { Navigate } from "react-router-dom";

class FeedPage extends React.Component {
    state = {  } 
    render() { 
        return (
        <div>
            { this.props.getName() === "" ? (<Navigate push to="/"/>) : null }
            Feed Page
        </div>);
    }
}
 
export default FeedPage;