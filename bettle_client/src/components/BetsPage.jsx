import React from "react";
import "../css/profilePage.css";
import BetService from "../services/BetService";

class BetsPage extends React.Component {
    state = { betslips: [] } 

    componentDidMount(){
        BetService.getBetSlips().then((response) => this.setState({betslips:response.data}));
    }

    render() { 
        return (
            <ul className="list-group">
                {this.state.betslips.map((betslip) => 
                <li key={betslip.id}>
                    <a href="#">Click</a>
                    <ul className="list-group">
                        {betslip.map((bet) => <li className="list-group-item" key={bet.id}>{bet.title}</li>)}
                    </ul>
                </li>
                )} 
            </ul>
        );
    }
}
 
export default BetsPage;