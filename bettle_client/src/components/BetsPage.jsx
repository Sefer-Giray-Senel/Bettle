import React from "react";
import "../css/profilePage.css";
import { Navigate } from "react-router-dom";
import BetService from "../services/BetService";
import ShareComponent from "./ShareComponent";

class BetsPage extends React.Component {
    state = { 
        betslips: [],
        shareId: 0
    } 

    componentDidMount(){
        BetService.getBetSlips().then((response) => {
            this.setState({betslips:response.data});
        });
        
    }

    render() { 
        return (
            <div>
                { this.props.getName() === "" ? (<Navigate push to="/login"/>) : null }
                <ul className="list-group">
                    {this.state.betslips.map((betslip) => 
                    <li key={betslip.betSlipId}>
                        <ul className="list-group">
                            {betslip.betList.map((bet) => <li className="list-group-item" key={bet.bet.id}>
                            {bet.game.firstTeamName} - {bet.game.secondTeamName} ( {bet.game.date} ) {bet.bet.title}</li>)}
                        </ul>
                        
                        { betslip.betSlipId !== this.state.shareId ? <button onClick={() => this.setState({shareId:betslip.betSlipId})}>Share</button>
                            : <ShareComponent betSlipId={betslip.betSlipId}/>}
                    </li>
                    )} 
                </ul>
            </div>
        );
    }
}
 
export default BetsPage;