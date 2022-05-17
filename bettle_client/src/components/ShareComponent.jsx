import React, {useState} from "react";
import "../css/profilePage.css";
import PostService from "../services/PostService";

function ShareComponent ({betSlipId}) {

    const [caption, setCaption] = useState("");

    const handleShare = (e) => {
        e.preventDefault();
        PostService.createPost(caption, betSlipId);
    }

    return (
        <form className="form-properties" onSubmit={handleShare}>
            <div className="form-inner">
                <div className="form-group">
                    <label >Caption: </label>
                    <input type="text" name="caption" id="caption" onChange={e => setCaption(e.target.value)} value={caption}/>
                
                <div className="formbtn"><button className="loginbtn">Share</button></div>
                </div>
            </div>
        </form>
    );
}
 
export default ShareComponent;