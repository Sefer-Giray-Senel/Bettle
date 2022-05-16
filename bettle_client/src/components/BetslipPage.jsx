import React from "react";
import BetService from "../services/BetService";

class BetslipPage extends React.Component {
    state = { 
        matches:[],
        activeId: 0,
        bets:[],
        betslip:[],
        enable: false
    } 

    componentDidMount(){
        BetService.getMatches().then((response) => {
            this.setState({matches: response.data});
        });
    }

    getBets = (match) => {
        this.setState({activeId:match.id});
        BetService.getBets(match.id).then((response) => {
            this.setState({bets: response.data.map(bet => bet["match"] = match.name)});
        });
    }

    addBet = (bet) => {
        const betslip = [...this.state.betslip, bet];
        this.setState({betslip});
    }

    removeBet = (betId) => {
        const betslip = this.state.betslip.filter(b => b.id !== betId);
        this.setState({betslip});
    }

    createBetslip = () => {
        BetService.createBetslip(this.state.betslip);
    }

    render() { 
        return (
        <div>
            Betslip Page
            <div style={{overflow: 'hidden'}}>
                <div class="list-group">
                    {this.state.matches.map(match => <button type="button" onClick={() => this.getBets(match)}
                        className={this.state.activeId === match.id ? "list-group-item list-group-item-action active" : 
                        "list-group-item list-group-item-action"} key={match.id}>{match.name}</button>)}
                </div>
                <div class="list-group">
                    {this.state.bets.map(bet => <button type="button" onClick={() => this.addBet(bet)}
                        className="list-group-item list-group-item-action" key={bet.id}>{bet.name}</button>)}
                </div>
                <div>BETSLIP
                <ul class="list-group list-group-flush">
                    {this.state.betslip.map(bet => <li className="list-group-item" key={bet.id}>{bet.matchName} - {bet.name}
                        <button type="button" onClick={() => this.removeBet(bet)} className="btn btn-danger">X</button></li>)}
                </ul>
                    { this.state.enable ? <button onClick={this.createBetslip}>Create</button> : <button disabled>Create</button> }
                </div>
            </div>
            

        </div>);
    }
}
 
export default BetslipPage;