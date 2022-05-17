import React from "react";
import BetService from "../services/BetService";
import "../css/betSlip.css";

class BetslipPage extends React.Component {
    state = { 
        matches:[],
        activeId: 0,
        bets:[],
        betslip:[],
        maxMbn: 0,
        enable: false
    } 

    componentDidMount(){
        BetService.getMatches().then((response) => {
            this.setState({matches: response.data});
        });
    }

    getBets = (match) => {
        this.setState({activeId:match.id});
        BetService.getBetsByMatch(match.id).then((response) => {
            var extendedBets = JSON.parse(JSON.stringify(response.data));
            extendedBets.forEach((bet) => {
                bet.match = match.firstTeamName + " - " + match.secondTeamName + " (" + match.date + ")"
            });
            this.setState({bets: extendedBets});
        });
    }

    addBet = (bet) => {
        if( this.state.betslip.find(b => b.id === bet.id) === undefined){
            const betslip = [...this.state.betslip, bet];
            this.setState({betslip});
            if(bet.mbn > this.state.maxMbn){
                this.setState({maxMbn: bet.mbn});
                if(betslip.length >= bet.mbn){
                    this.setState({enable: true});
                }
                else{
                    this.setState({enable: false});
                }
            }else{
                if(betslip.length >= this.state.maxMbn){
                    this.setState({enable: true});
                }
            }            
        }
    }

    removeBet = (bet) => {
        const betslip = this.state.betslip.filter(b => b.id !== bet.id);
        this.setState({betslip});
        if(bet.mbn === this.state.maxMbn ){
            const newMbn = Math.max(...betslip.map(bet => bet.mbn));
            this.setState({maxMbn:newMbn});
            if(betslip.length < newMbn){
                this.setState({enable: false});
            }
            else{
                this.setState({enable: true});
            }
        }
        else if(betslip.length < this.state.maxMbn)
            this.setState({enable: false});

        if(betslip.length === 0){
            this.setState({enable: false});
            this.setState({maxMbn: 0});
        }
    }

    createBetslip = () => {
        BetService.createBetslip(this.state.betslip.map(bet => bet.id));
        window.location.reload(false);
    }

    render() { 
        return (
        <div>
            <div className="wrapper" style={{overflow: 'hidden'}}>
                <div className="leftdiv">
                    <h4>Matches</h4>
                    {this.state.matches.map(match => <button type="button" onClick={() => this.getBets(match)}
                        className={this.state.activeId === match.id ? "list-group-item list-group-item-action active" : 
                        "list-group-item list-group-item-action"} key={match.id}>{match.firstTeamName} - {match.secondTeamName} ({match.date})</button>)}
                </div>
                <div className="middiv">
                    <h4>Bets</h4>
                    {this.state.bets.map(bet => <button type="button" onClick={() => this.addBet(bet)}
                        className="list-group-item list-group-item-action" key={bet.id}>{bet.title}</button>)}
                </div>
                <div className="rightdiv">
                    <h4>Your Betslip</h4>
                    <ul className="list-group list-group-flush">
                        {this.state.betslip.map(bet => <li className="list-group-item" key={bet.id}>{bet.match} - {bet.title} - MBN: {bet.mbn} ... 
                            <button type="button" onClick={() => this.removeBet(bet)} className="btn btn-danger">X</button></li>)}
                    </ul>
                    { this.state.enable ? <button onClick={this.createBetslip}>Create</button> : <button disabled>Create</button> }
                </div>
            </div>
            

        </div>);
    }
}
 
export default BetslipPage;