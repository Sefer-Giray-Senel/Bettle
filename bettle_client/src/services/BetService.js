import axios from "axios";
class BetService{

    getMatches(){
        return axios.get("http://localhost:8080/matches", {
            headers: {
            Authorization: localStorage.getItem('token')
            }
        });
    }

    getBets(matchId){
        return axios.post("http://localhost:8080/matches", {
            headers: {
            Authorization: localStorage.getItem('token')
            }}, {
            params: {
                matchId: matchId
            }
        });
    }

    createBetslip(betslip){
        return axios.post("http://localhost:8080/matches", {
            headers: {
            Authorization: localStorage.getItem('token')
            }}, {
            params: {
                bets: betslip
            }
        });
    }

}

export default new BetService();