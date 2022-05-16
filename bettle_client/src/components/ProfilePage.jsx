import React from "react";
import "../css/profilePage.css";

class ProfilePage extends React.Component {
    state = {  } 
    render() { 
        return (<div className="container mt-5">
            <div className="row d-flex justify-content-center">
                <div className="col-md-7">
                    <div className="card p-3 py-4">
                        <div className="text-center">
                            <h5 className="mt-2 mb-0">Alexender Schidmt</h5>
                        </div>

                        <div className="text-center mt-3">
                            <span>nationality</span>
                            <div className="px-4 mt-1">
                                <p className="fonts">alexanderschidmt@gmail.com </p>
                            </div>

                            <ul className="list-group">
                                <li><p className="fonts2">12.04.20 </p><a href="#"><img src="https://i.imgur.com/bDLhJiP.jpg" width="350px" height="150"/></a></li>
                                <li><p className="fonts2">12.04.20 </p><a href="#"><img src="https://i.imgur.com/bDLhJiP.jpg" width="350px" height="150"/></a></li>
                                <li><p className="fonts2">12.04.20 </p><a href="#"><img src="https://i.imgur.com/bDLhJiP.jpg" width="350px" height="150"/></a></li>

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